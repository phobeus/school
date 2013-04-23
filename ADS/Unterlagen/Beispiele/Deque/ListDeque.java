/**
 * @(#)ListDeque.java
 *
 * Klasse ListDeque<E> (ADS)
 * double ended queue als doppelt verkettete Liste implementiert
 *
 * @author Arnold Aders
 * @version 1.00 20130326
 */

public class ListDeque<E> implements Deque<E> {
	private int size=0;
	private ListElement begin, end;

	private class ListElement {
		public E nd;	// NutzDaten
		public ListElement next, prev;
		public ListElement(E nd, ListElement next, ListElement prev ) {
			this.nd = nd;
			this.next = next;
			this.prev = prev;
		}
	}

	public boolean isEmpty() { return size==0; }
	public int size() { return size; }

	public void putToEnd(E el) {
		end = new ListElement ( el, null, end );
		if (size==0) begin = end;
		else end.prev.next = end;
		size++;
	}

	public void putToBegin(E el) {
		begin = new ListElement ( el, begin, null );
		if (size==0) end = begin;
		else begin.next.prev = begin;
		size++;
	}

	public E getFromEnd() {
		if (size==0) return null;
		E result=end.nd;
		end = end.prev;
		if (end!=null) end.next=null;
		else begin=null;
		size--;
		return result;
	}

	public E getFromBegin() {
		if (size==0) return null;
		E result=begin.nd;
		begin = begin.next;
		if (begin!=null) begin.prev=null;
		else end=null;
		size--;
		return result;
	}
}
