package ch.zhaw.ads;

/**
 * @(#)Stack.java
 *
 *
 * @author	Arnold Aders
 * @version 1.00 2013/2/26
 */


public interface Stack<E> {
    public void push(E e);
    public E pop();
    public int size();		// number of elements in stack
    public boolean isEmpty();
}