import java.lang.Comparable;

/** Binary Search Tree implementation for Dictionary ADT */
public class BST<Key extends Comparable<? super Key>, E> {

	private BSTNode<Key, E> root; // Root of the BST
	int numNodes; // Number of nodes in the BST
	int count = 0;

	/** Insert the given pair (k, e) to this BST */
	public void insert(Key k, E e) {
		root = insertHelper(root, k, e);
		numNodes++;
	}

	public BSTNode<Key, E> insertHelper(BSTNode<Key, E> rt, Key k, E e) {
		if(rt == null)
			return new BSTNode<>(k, e);
		if(rt.key().compareTo(k) >0 )
			rt.setLeft(insertHelper(rt.left(), k, e));
		else
			rt.setRight(insertHelper(rt.right(), k, e));
		return rt;
	}

	/** Find a pair by the given key k, and return the value of found pair */
	public E find(Key k) {
		if(findHelper(root, k) != null)
			return findHelper(root, k).element();
		else
			return null;
	}

	private BSTNode<Key, E> findHelper(BSTNode<Key, E> rt, Key k) {
		if(rt == null)
			return null;
		if(rt.key().compareTo(k) > 0)
			return findHelper(rt.left(), k);
		else if(rt.key().compareTo(k) == 0)
			return rt;
		else
			return findHelper(rt.right(), k);
	}

	/** Delete a pair whose key is minimum */
	public BSTNode<Key, E> deleteMin() {
		numNodes--;
		BSTNode temp = findMinHelper(root);
		root = deleteMinHelper(root);
		return temp;
	}

	private BSTNode<Key, E> findMinHelper(BSTNode<Key, E> rt) {

		if(rt == null)
			return null;
		if(rt.left() == null)
			return rt;
		else
			return findMinHelper(rt.left());

	}

	private BSTNode<Key, E> deleteMinHelper(BSTNode<Key, E> rt) {
		if(rt == null)
			return null;
		if(rt.left() == null)
			return rt.right();
		else {
			rt.setLeft(deleteMinHelper(rt.left()));
			return rt;
		}
	}

	/** Return the number of pairs in this BST */
	public int size() {
		return numNodes;
	}

	public void preorder() {
		count = 0;
		preorderHelper(root);
	}

	private void preorderHelper(BSTNode<Key, E> rt) {
		if(rt == null)
			return ;
		if(count !=0) {
			System.out.print(" / ");
		}
		System.out.print(rt.key() + "-"+ rt.element() );
		count++;
		preorderHelper(rt.left());
		preorderHelper(rt.right());

	}

	/** Print all pairs in this BST in inorder */
	public void inorder() {
		count = 0;
		inorderHelper(root);

	}

	private void inorderHelper(BSTNode<Key, E> rt) {
		if(rt == null)
			return ;
		inorderHelper(rt.left());
		if(count !=0) {
			System.out.print(" / ");
		}
		count++;
		System.out.print(rt.key() + "-"+ rt.element());
		inorderHelper(rt.right());
	}

	/** Print all pairs in this BST in postorder */
	public void postorder() {
		count = 0;
		postorderHelper(root);
	}

	private void postorderHelper(BSTNode<Key, E> rt) {
		if(rt == null)
			return ;
		postorderHelper(rt.left());
		postorderHelper(rt.right());
		if(count !=0) {
			System.out.print(" / ");
		}
		count++;
		System.out.print(rt.key() + "-"+ rt.element() );
	}

}
