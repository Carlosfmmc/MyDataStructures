package model.arrayContainers;

import java.lang.reflect.Array;

import model.MyQueue;

public class StuckWithArray<T> implements MyQueue<T> {

	private T[] myContainer;
	private final int max;
	private final Class clazz;
	
	public StuckWithArray(Class<T> clazz) {
		max = -1;
		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, 0);
	}
	public StuckWithArray(Class<T> clazz, int max) {
		this.max = max;
		myContainer = (T[]) Array.newInstance(clazz, 0);
		this.clazz = clazz;
	}
	
	@Override
	public void push(T item) {
		if(item != null && (myContainer.length < max || max == -1)) {
			T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length+1);
			for (int i = 0; i<myContainer.length; i++) {
				auxMyContainer[i]=myContainer[i];
			}
			myContainer = auxMyContainer;
			myContainer[myContainer.length-1]=item;
		}		
	}

	@Override
	public T pop() {
		T ret = myContainer[myContainer.length-1];
		T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length-1);
		for (int i = 0; i<myContainer.length-1; i++) {
			auxMyContainer[i]=myContainer[i];
		}
		myContainer = auxMyContainer;
		return ret;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return myContainer.length;
	}

}
