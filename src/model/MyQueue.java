package model;

public interface MyQueue<T> {
	public abstract void push(T item);
	public abstract T pop();
	public abstract int length();
	
	
}
