public class Edge<E> {

	protected Vertex<E> dest;	// Zielknoten der Kante
	protected double weight;	// Kantengewicht

	public Edge(Vertex<E> d, double c) {
		dest = d;
		weight = c;
	}

	Vertex<E> getDest() {
		return dest;
	}

	double getWeight() {
		return weight;
	}
}
