package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Iterator;

public interface SortedList<E> extends Iterable<E>{

		// valid position in the list
		// [0, size() - 1]
		
		public boolean add(E obj); //done
		public int size(); //done
		public boolean remove(E obj); //done
		public boolean remove(int index); //done
		public int removeAll(E obj); //done
		public E first(); //done
		public E last(); //done
		public E get(int index); //done
		public void clear(); //done
		public boolean contains(E e); //done
		public boolean isEmpty(); //done
		public int firstIndex(E e); //done
		public int lastIndex(E e); //done

		
}
