package ch.zhaw.ads;

/**
 * @(#)ArrayStack.java
 *
 * Array implementation of interface Stack<E>
 *
 * class StackOverflowException extends RuntimeException
 *
 * @author	Arnold Aders
 * @version 1.00 20130228
 */
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
	private E[] a;
	private int sp;		// stackPointer

	@SuppressWarnings("unchecked")
	public ArrayStack(int n) {
		a  = (E[]) new Object[n];
		sp = 0;
	}

	public void push(E e) {
		if (sp<a.length-1) a[sp++] = e;
		else throw new StackOverflowException();
	}

	public E pop() {
		if (sp>0) return a[--sp];
		throw new EmptyStackException();
	}

	public int size() { return sp; }

	public boolean isEmpty() { return sp==0; }
}

class StackOverflowException extends RuntimeException {
	public StackOverflowException() { }
	public StackOverflowException(String msg) { super(msg); }
}
