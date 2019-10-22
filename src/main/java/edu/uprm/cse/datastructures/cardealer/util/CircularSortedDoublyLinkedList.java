package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.uprm.cse.datastructures.cardealer.model.CarComparator;

public class CircularSortedDoublyLinkedList<E> implements SortedList<E> {
	
	private Node<E> header;
	private int size;
	private AbstractComparator<E> cmp = (AbstractComparator<E>) new CarComparator();
	
	public CircularSortedDoublyLinkedList() {
		header = new Node<E>();
		header.setNext(header);
		header.setPrev(header);
		size = 0;
	}
	

	@Override
	public Iterator<E> iterator() {
		return new ForwardIterator();
	}

	@Override
	public boolean add(E obj) {
		Node<E> nta = new Node<E>(obj);
		if(isEmpty()) {
			nta.setPrev(header);
			nta.setNext(header);
			header.setNext(nta);
			header.setPrev(nta);
			size++;
			return true;
		}
		
		Node<E> tmp = header.getNext();
		
		while(tmp != header && cmp.compare(tmp.getData(), nta.getData()) < 0) {
			tmp = tmp.getNext();
		}
		
		nta.setNext(tmp);
		nta.setPrev(tmp.getPrev());
		tmp.getPrev().setNext(nta);
		tmp.setPrev(nta);
		size++;
		return true;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean remove(E obj) {
		if(isEmpty()) {
			return false;
		}
		
		Node<E> tmp = header.getNext();
		
		while(tmp != header || !tmp.getData().equals(obj)) {
			tmp = tmp.getNext();
		}
		
		if(tmp == header) return false;
		else {
			tmp.getPrev().setNext(tmp.getNext());
			tmp.getNext().setPrev(tmp.getPrev());
			tmp.clean();
			size--;
			return true;
		}
		
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("remove: " + index);
		
		Node<E> tmp = header.getNext();
		
		for(int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}
		
		tmp.getPrev().setNext(tmp.getNext());
		tmp.getNext().setPrev(tmp.getPrev());
		tmp.clean();
		size--;
		return true;
		
	}

	@Override
	public int removeAll(E obj) {
		int count = 0;
		while(contains(obj)) {
			remove(obj);
			count++;
		}
		return count;
	}

	@Override
	public E first() {
		if(isEmpty()) return null;
		else return header.getNext().getData();
	}

	@Override
	public E last() {
		if(isEmpty()) return null;
		else return header.getPrev().getData();
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("get: " + index);

		Node<E> tmp = header.getNext();

		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}

		return tmp.getData();

	}

	@Override
	public void clear() {
		while(!isEmpty()) remove(0);
		
	}

	@Override
	public boolean contains(E e) {
		if(isEmpty()) return false;
		
		Node<E> tmp = header.getNext();
		
		while(tmp != header || !tmp.getData().equals(e)) {
			tmp = tmp.getNext();
		}
		
		if(tmp == header) return false;
		else return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int firstIndex(E e) {
		int index = 0;
		Node<E> tmp = header.getNext();

		while (tmp != header && !tmp.getData().equals(e)) {
			tmp = tmp.getNext();
			index++;
		}

		if (index >= 0 && tmp != header)
			return index;
		else
			return -1;

	}

	@Override
	public int lastIndex(E e) {
		int index = size - 1;
		Node<E> tmp = header.getPrev();

		while (tmp != header && !tmp.getData().equals(e)) {
			tmp = tmp.getPrev();
			index--;
		}

		if (index <= size - 1 && tmp != header)
			return index;
		else
			return -1;

	}
	
	private class Node<E> {
		
		private E data;
		private Node<E> next, prev;
		
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public Node(E data) {
			this(data, null, null);
		}
		
		public Node() {
			this(null, null, null);
		}

		public E getData() {
			return data;
		}

		public Node<E> getNext() {
			return next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setData(E data) {
			this.data = data;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		
		public void clean() {
			this.data = null;
			this.next = null;
			this.prev = null;
		}
	}
	
	private class ForwardIterator implements Iterator<E> {

		private Node<E> current;
		private Node<E> recent;

		public ForwardIterator() {
			current = header.getNext();
			recent = null;
		}

		public ForwardIterator(int index) {
			if (index < 0 || index >= size)
				throw new IndexOutOfBoundsException("ForwardIterator: " + index);

			current = header.getNext();

			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}

			recent = null;
		}

		public boolean hasNext() {
			return current != header;
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException("No more data");
			recent = current;
			current = current.getNext();
			return recent.getData();
		}
	}


}
