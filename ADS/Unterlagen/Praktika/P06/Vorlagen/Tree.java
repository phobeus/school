// interface of Tree ADT
public interface Tree<T extends Comparable<T>> {

	// add an element to the tree
	public void insert (T t);

	// remove an element; return the element if found else return null
	public Tree<T> delete (T t);

	// test if tree is empty
	public boolean isEmpty();

	// return an instance of a class that implements the Traversal interface
	public Traversal<T> traversal();
}
