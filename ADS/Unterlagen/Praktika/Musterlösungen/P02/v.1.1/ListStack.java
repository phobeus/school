package ch.zhaw.ads;

/**
 * @(#)ListStack.java
 *
 * Linked list implementation of interface Stack<E>
 *
 * @author	Arnold Aders
 * @version 1.00 20130314
 */
import java.util.EmptyStackException;

public class ListStack<E> implements Stack<E> {
	private class ListElement {
		public E nd;	// NutzDaten
		public ListElement next;
		public ListElement(E nd, ListElement next) {
			this.nd = nd;
			this.next = next;
		}
	}
	private ListElement sp;		// stackPointer
	private int size=0;

	public void push(E e) {
		sp = new ListElement(e,sp);
		size++;
	}

	public E pop() {
		if (sp==null) throw new EmptyStackException();
		size--;
		E res = sp.nd;
		sp = sp.next;
		return res;
	}

	public int size() { return size;  }

	public boolean isEmpty() { return sp==null; }
}
