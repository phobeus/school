/**
 * @(#)Deque.java
 *
 * interface Deque<E> (=double ended queue) (ADS)
 *
 * @author Arnold Aders
 * @version 1.00 20130326
 */

public interface Deque<E> {
	public boolean isEmpty();
	public int size();
	public void putToEnd(E el);
	public void putToBegin(E el);
	public E getFromEnd();
	public E getFromBegin();
}