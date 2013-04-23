// Remove doesn't work

class TestBinaryTree {

  	public static void main (String[] args) {
		BinaryTree<String> t = new BinaryTree<String>();
		t.insert("Berta");
		t.insert("Adam");
		t.insert("Moni");
		t.insert("Uschi");
		t.insert("Otto");
		t.insert("Dani");
		t.insert("Ruth");
		t.insert("Zeta");
		t.insert("Toni");
		t.insert("Walter");
		t.insert("Peter");
		t.insert("Kurt");
		t.insert("Ueli");
		Traversal<String> travel = t.traversal();
		Visitor<String> v = new MyVisitor<String>();
		System.out.println("\nPreorder");
		travel.preorder(v);
		System.out.println("\nInorder");
		travel.inorder(v);
		System.out.println("\nPostorder");
		travel.postorder(v);


/*		System.out.println("\nDeleting Ueli");
		t = t.remove("Ueli");
		travel.inorder(v);

		System.out.println("\nDeleting Toni");
		t = t.remove("Toni");
		travel.inorder(v);

		System.out.println("\nDeleting Uschi");
		t = t.remove("Uschi");
		travel.inorder(v);

		System.out.println("\nDeleting Berta");
		t = t.remove("Berta");
		travel.inorder(v);


		System.out.println("\nDeleting Juanita");
		t = t.remove("Juanita");
		travel.inorder(v);
*/
	}
}

class MyVisitor<T> implements Visitor<T> {
  	public void visit (T element) {
  		System.out.println(element.toString());
  	}
}




