import java.util.*;

public class Vertex<E> { //implements Comparable<Vertex> {

	private E element;
	private List<Edge<E>> adj;		// Adjazenzliste
	private double value = Double.MAX_VALUE;
	private Vertex<E> prev;		// direkter Vorgängerknoten
	private boolean mark = false;	// Knoten besucht

	public Vertex(E e) {
		element = e;
		adj = new LinkedList<Edge<E>>();
	}

	public E getElement() {
		return element;
	}

	public Iterator<Edge<E>> getEdges() {
		return adj.iterator();
	}

	public void addAdjacent(Edge<E> edge) {
		adj.add(edge);
	}

	public void setValue(double w) {
		value = w;
	}

	public double getValue() {
		return value;
	}

	public void setMark(boolean m) {
		mark = m;
	}

	public boolean getMark() {
		return mark;
	}

	public void setPrev(Vertex<E> p) {
		prev = p;
	}

	public Vertex<E> getPrev() {
		return prev;
	}
/*
	public int compareTo(Vertex<E> other) {
		if (this.getValue() > other.getValue()) {
			return 1;
		} else if (this.getValue() < other.getValue()) {
			return -1;
		} else {
			return 0;
		}
	}
*/
}
