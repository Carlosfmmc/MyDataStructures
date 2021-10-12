package model.arrayContainers.model.arrayContainers.lists;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ListWithArray<T> implements Iterable<T>{
	
	private T[] myContainer;
	private int max;
	private Class<T> clazz;
	
	public ListWithArray(Class<T> clazz) {

		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, 0);
		max = -1;
	}
	public ListWithArray(Class<T> clazz, int n) {

		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, n);
		max = n;
	}
	
	public boolean add(T item) {
		if(item == null) return false;
		if(myContainer.length < max || max == -1) {
			T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length+1);
			for (int i = 0; i<myContainer.length; i++) {
				auxMyContainer[i]=myContainer[i];
			}
			myContainer = auxMyContainer;
			myContainer[myContainer.length-1]=item;
			return true;
		}
		return false;
	}
	
	public boolean delete(T item) {
		if(item == null) return false;
		int k = getIndexOf(item);
		if(k==-1) return false;
		T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length-1);
		for(int j = 0; j<auxMyContainer.length; j++) {
			if(j>=k) {
				auxMyContainer[j] = myContainer[j+1];
			}
		}
		myContainer = auxMyContainer;
		return true;
	}
	
	public T get(int index) {
		if (index<0 || index >= myContainer.length) return null;
		return myContainer[index];
	}
	
	public int getIndexOf(T item) {
		if(item == null) return -1;
		for(int i=0; i<myContainer.length; i++) {
			if(item.equals(myContainer[i]))return i;
		}
		return -1;
	}
	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListWithArrayIterator<T>();
	}
	
	private class ListWithArrayIterator<T> implements Iterator<T>{
		private int index;
		T[] myContainerIterator;
		
		public ListWithArrayIterator() {
			index = -1;
			myContainerIterator = (T[]) myContainer;
		}
		@Override
		public boolean hasNext() {
			if(index<myContainerIterator.length-1) return true;
			return false;
		}

		@Override
		public T next() {
			if(index<myContainerIterator.length-1) {
				index++;
				return myContainerIterator[index];
			}
			return null;
		}
		
	}

}
