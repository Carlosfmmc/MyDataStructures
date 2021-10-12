package model.arrayContainers.model.arrayContainers.lists;

import java.lang.reflect.Array;
import java.util.Iterator;


public class SortedListWithArray<T extends Comparable<T>> implements Iterable<T> {
	
	private T[] myContainer;
	private int max;
	private Class<T> clazz;
	
	public SortedListWithArray(Class<T> clazz) {
		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, 0);
		max = -1;
	}
	
	public SortedListWithArray(Class<T> clazz, int n) {
		this.clazz = clazz;
		myContainer = (T[]) Array.newInstance(clazz, n);
		max = n;
	}
	
	public boolean add(T item) {
		if(item == null) return false;
		int a = 0;
		int b = myContainer.length-1;
		int m = b/2;
		while(b>a) {
			if(item.compareTo(myContainer[m])==0) {
				T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length+1);
				for(int i = 0; i<auxMyContainer.length; i++) {
					if(i==m) {
						auxMyContainer[i]=item;
					}else if (i<m) {
						auxMyContainer[i]= myContainer[i];
					}else {
						auxMyContainer[i]= myContainer[i-1];
					}
				}
				myContainer = auxMyContainer;
				return true;
			}
			if(item.compareTo(myContainer[a])==0) {
				T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length+1);
				for(int i = 0; i<auxMyContainer.length; i++) {
					if(i==a) {
						auxMyContainer[i]=item;
					}else if (i<a) {
						auxMyContainer[i]= myContainer[i];
					}else {
						auxMyContainer[i]= myContainer[i-1];
					}
				}
				myContainer = auxMyContainer;
				return true;
			}
			if(item.compareTo(myContainer[b])==0) {
				T[] auxMyContainer = (T[]) Array.newInstance(clazz, myContainer.length+1);
				for(int i = 0; i<auxMyContainer.length; i++) {
					if(i==b) {
						auxMyContainer[i]=item;
					}else if (i<b) {
						auxMyContainer[i]= myContainer[i];
					}else {
						auxMyContainer[i]= myContainer[i-1];
					}
				}
				myContainer = auxMyContainer;
				return true;
			}
			if(item.compareTo(myContainer[m])<0) {
				b = m-1;
				m = b-java.lang.Math.min(1, ((b-a)/2));
			}
			if(item.compareTo(myContainer[m])>0) {
				a = m+1;
				m = a+java.lang.Math.min(1,((b-a)/2));
			}
		}
		
		return true;
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
		if(item == null || myContainer.length==0) return -1;
		int a = 0;
		int b = myContainer.length-1;
		int m = b/2;
		while(b>a) {
			if(item.compareTo(myContainer[m])==0)return m;
			if(item.compareTo(myContainer[a])==0)return a;
			if(item.compareTo(myContainer[b])==0)return b;
			if(item.compareTo(myContainer[m])<0) {
				b = m-1;
				m = b-java.lang.Math.min(1, ((b-a)/2));
			}
			if(item.compareTo(myContainer[m])>0) {
				a = m+1;
				m = a+java.lang.Math.min(1,((b-a)/2));
			}
		}
		return -1;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
