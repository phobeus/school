package ch.zhaw.ads.helpClasses;


import ch.zhaw.ads.interfaces.Stack;

public class ImplStack<E extends Object> implements Stack<E> {
	
	private E[] brackets = (E[])new Object[100];
	private int bracketsCount = 0;

	public void push(E x) throws StackOverflowError {
		brackets[bracketsCount]=x;
		bracketsCount++;
	}

	public E pop() {
		E pop = brackets[bracketsCount];
		bracketsCount--;
		return pop;
	}

	public boolean isEmpty() {
		if(bracketsCount == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public E peek() {
		return brackets[bracketsCount];
	}

	public void makeEmpty() {
		for(int i = 0; i<brackets.length; i++) {
			brackets[i]=null;
		}
	}

	public boolean isFull() {
		if (bracketsCount == 99) {
			return true;
		}
		else {
			return false;
		}
	}
}
