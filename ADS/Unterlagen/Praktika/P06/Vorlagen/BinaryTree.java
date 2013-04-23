import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

	class Wrapper<T> { T c; }

	T element = null;
	BinaryTree<T> left = null;
	BinaryTree<T> right = null;

	public BinaryTree() {}

	public BinaryTree(T element) {
		this.element = element;
	}

	public Traversal<T> traversal() {
		// TO DO
		return null;	// Nur damit es compiliert
	}


	public void insert (T c) {
		if (element==null) element = c;	// only necessary for root
		else if (c.compareTo(element) <= 0) {
			if (left==null) left = new BinaryTree<T>(c);
			else left.insert(c);
		}
		else {
			if (right==null) right = new BinaryTree<T>(c);
			else right.insert(c);
		}
	}


  	private BinaryTree<T> removeLargest(Wrapper<T> w) {
  		if (right != null) right = right.removeLargest(w);
  		else {  // found
 			w.c = element;
  			return left;
  		}
  		return this;
  	}

	public Tree<T> delete(T c) {
		BinaryTree<T> tree = remove(c);
		if (tree==null) tree=new BinaryTree<T>();
		return tree;
	}

	public BinaryTree<T> remove(T c) throws NoSuchElementException {
		if (element == null) return this;	// an empty tree.
	//	else {
			int comp = c.compareTo(element);
			if(comp < 0) {
				if (left!=null) left = left.remove(c);
				else throw new NoSuchElementException();
			}
			else if (comp > 0) {
				if (right!=null) right = right.remove(c);
				else throw new NoSuchElementException();
			}
			else {	// found
				if (left == null) return right;
				if (right == null) return left;
			//	else {
					Wrapper<T> w = new Wrapper<T>();
					left = left.removeLargest(w);
					element = w.c;
			//	}
			}
	//	}
		return this;
	}

	public boolean isEmpty() {
		return element==null;
	}

	public T getFirst() {
		if (left==null) return element;
		else return left.getFirst();
	}

	public void clear() {
		element = null;
		left = null;
		right = null;
	}

}