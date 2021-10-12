package model.arrayContainers.queues;
import java.lang.Iterable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import model.MyQueue;

public class StaticQeueWithArray<T> implements MyQueue<T>{
	
	private T[] myContainer;
	private int ini;
	private int fin;
	private final int len;
	private final Class clazz;
	
	public StaticQeueWithArray(Class<T> clazz, int n) {

		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, n);
		ini = 0;
		fin = 0;
		len = n;
	}
	
	public int lengthmax() {
		return len;
	}
	
	public void push (T item) {
		if(fin - ini < len && item != null) {
			myContainer[fin%len]=item;
			fin++;
		}
	}
	
	public T get(int index) {
		if(index>=len) {
			return null;
		}
		return myContainer[index+ini];
	}
	
	public T pop() {
		if(ini<fin) {
		T ret = myContainer[ini%len];
		ini++;
		return ret;
		}
		return null;
	}
	
	
	
	@Override
	public String toString() {
		return "StaticQeueWithArray= [" + Arrays.toString(myContainer) + "]";
	}

	public int length() {
		return fin - ini;
	}
	
	public void clean() {
		
		myContainer = (T[]) Array.newInstance(clazz, len);
		ini = 0;
		fin = 0;
		
	}
	

}
