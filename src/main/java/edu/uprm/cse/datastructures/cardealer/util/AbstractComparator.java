package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Comparator;

public class AbstractComparator<Object> implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1.equals(o2)) return 0;
		else return -1;
	}

}
