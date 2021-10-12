package model.arrayContainers.queues;

import java.lang.reflect.Array;
import java.util.Arrays;

import model.MyQueue;

public class DinamicQueueWithArray<T> implements MyQueue<T>{

	private T[] myContainer;
	private final int max;
	private final Class clazz;
	
	public DinamicQueueWithArray(Class<T> clazz) {
		max = -1;
		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, 0);
	}
	
	public DinamicQueueWithArray(Class<T> clazz, int max) {
		this.max = max;
		myContainer = (T[]) Array.newInstance(clazz, 0);
		this.clazz = clazz;
	}
	
	@Override
	public void push(T item) {
		if(item !=null && (myContainer.length < max || max == -1)) {
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
		T ret = myContainer[0];
		T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length-1);
		for (int i = 1; i<myContainer.length; i++) {
			auxMyContainer[i]=myContainer[i];
		}
		myContainer = auxMyContainer;
		return ret;
	}

	public int lengthmax() {
		return max;		
	}

	@Override
	public int length() {
		return myContainer.length;
	}

	@Override
	public String toString() {
		return "DinamicQueueWithArray = [" + Arrays.toString(myContainer) + "]";
	}
	
	public void clean() {
		myContainer = (T[]) Array.newInstance(clazz, 0);
	}
	
	
}
