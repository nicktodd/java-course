package com.conygre.generics.wildcards;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestExtendsSuper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//call 1
		List<? super Object> ls1 = new LinkedList<Object>();
		addandDisp(ls1,new String());

		//call 2
		List<? extends Object> ls2 = new LinkedList<Object>();
		addandDisp(ls2,new Object());

		//call 3
		List<Object> ls3 = new LinkedList<Object>();
		addandDisp(ls3,new String());

		//call 4
		List<? super Object> ls4 = new LinkedList<Object>();
		addandDisp(ls4,new Object());

	}

	
	public static <S> void addandDisp(Collection<S> cs, S t)
	{
	for (S o : cs)
	{
	cs.add(o);
	}
	for (S o : cs)
	{
	System.out.println(o);
	}
	}

}
