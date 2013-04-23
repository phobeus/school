import java.util.*;

public interface Graph<E> {

	// füge Knoten hinzu, tue nichts, falls Knoten schon existiert
	public Vertex<E> addVertex (E source);

	// füge gerichtete Kante hinzu
	// erstelle Vertices, falls noch nicht vorhanden
	public void addEdge(E source, E dest, double weight);

	// finde den Knoten
	public Vertex<E> findVertex(E obj);

	// Iterator über die Kanten eines Knoten
	public Iterator getEdges(Vertex<E> source);

	// Iterator über alle Knoten
	public Iterator<Vertex<E>> getVertices();
}
