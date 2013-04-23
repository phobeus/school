import java.util.*;

public class AdjListGraph<E> implements Graph<E> {
	private List<Vertex<E>> vertices = new LinkedList<Vertex<E>>();

	// füge Knoten hinzu, tue nichts, falls Knoten schon existiert
	public Vertex<E> addVertex (E source) {
	   	Vertex<E> vrtx = findVertex(source);
		if (vrtx == null) {
			vrtx = new Vertex<E>(source);
			vertices.add(vrtx);
		}
		return vrtx;
	}

	// füge gerichtete Kante hinzu
	// erstelle Vertices, falls noch nicht vorhanden
	public void addEdge(E source, E dest, double cost) {
		Vertex<E> src = addVertex(source);
		Vertex<E> dst = addVertex(dest);
		Edge<E> edge = new Edge<E>(dst,cost);
		src.addAdjacent(edge);
	}

	// finde den Knoten anhand seines Namens
	public Vertex<E> findVertex(E element) {
		Iterator<Vertex<E>> itr = vertices.iterator();
		while (itr.hasNext()) {
			Vertex<E> vertex = itr.next();
			if (element.equals(vertex.getElement())) return vertex;
		}
		return null;
	}
	// Iterator über die Kanten eines Knoten
	public Iterator<Edge<E>> getEdges(Vertex<E> source) {
		return source.getEdges();
	}

	// Iterator über alle Knoten
	public Iterator<Vertex<E>> getVertices(){
		return vertices.iterator();
	}
}
