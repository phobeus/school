import java.util.*;

public interface Graph<E> {

	// f�ge Knoten hinzu, tue nichts, falls Knoten schon existiert
	public Vertex<E> addVertex (E source);

	// f�ge gerichtete Kante hinzu
	// erstelle Vertices, falls noch nicht vorhanden
	public void addEdge(E source, E dest, double weight);

	// finde den Knoten
	public Vertex<E> findVertex(E obj);

	// Iterator �ber die Kanten eines Knoten
	public Iterator getEdges(Vertex<E> source);

	// Iterator �ber alle Knoten
	public Iterator<Vertex<E>> getVertices();
}
