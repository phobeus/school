/**
 * @(#)TestDeque.java
 *
 * TestDeque testet Klasse ListDeque<E> (ADS)
 *
 * @author Arnold Aders
 * @version 1.00 20130326
 */

public class TestDeque {
	public static void main(String[] args) {
		final int N=3;
		Deque<String> deque = new ListDeque<String>();
		for (int i=0; i<N; i++) {
			String s = "Hah"+(char)((int)'a'+i);
			deque.putToBegin(s);
			System.out.println("putToBegin(\""+s+"\"); "+deque.size()+" drin");
		}
		do System.out.println("getFromEnd() -> \""+deque.getFromEnd()+"\"; "
			+deque.size()+" drin");
		while (!deque.isEmpty());
		System.out.println("getFromEnd() -> \""+deque.getFromEnd()+"\"; "
			+deque.size()+" drin");
		for (int i=0; i<N; i++) {
			String s = "Hah"+(char)((int)'a'+i);
			deque.putToEnd(s);
			System.out.println("putToEnd(\""+s+"\"); "+deque.size()+" drin");
		}
		do System.out.println("getFromEnd() -> \""+deque.getFromEnd()+"\"; "
			+deque.size()+" drin");
		while (!deque.isEmpty());
	}
}
