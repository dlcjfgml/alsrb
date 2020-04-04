package ds.bst;

import ds.list.SingleLinkedList;

/**
 * A class of a binary tree.
 */
public class BinaryTree {
	/** Head node for this tree */
	BinaryNode root;
	int nodecount;
	// Declare more variables HERE

	/** Constructor */
	public BinaryTree() {
		root = null;
		nodecount = 0;
		// fill your code
	}
	// Implement more constructors HERE
	/** Reinitialize tree */
	public void clear() {
		// fill your code
		root = null;
		nodecount=0;
	}

	/** Insert a record into the tree. */
	public void insert(String name, int grade) {
		root = inserthelp(root, name, grade);
		nodecount++;
		// fill your code

	}

	/** Remove a record from the tree. */
	public int remove(String name) {
		int temp = findhelp(root, name);
		if(temp < 0) {
			return temp;
		}
		root = removehelp(root, name);
		nodecount--;
		return temp;

	}


	/** @return Record with key value k, null if none exist. */
	public int find(String name) {

		return findhelp(root,name);
	}

	/** @return The number of records. */
	public int size() {

		return nodecount;
	}
	private int findhelp(BinaryNode rt, String name) {
		if(rt == null) return -1;
		if(rt.getKey().compareTo(name) == 0) {
			return rt.getElement();
		}
		else if(rt.getKey().compareTo(name) > 0) {
			return findhelp(rt.getLeft(), name);
		} else {
			return findhelp(rt.getRight(), name);
		}

	}

	public void inorder(SingleLinkedList list) {
		inorderHelper(root, list);
	}

	private void inorderHelper(BinaryNode rt, SingleLinkedList list){
		if(rt == null) return;
		inorderHelper(rt.getLeft(), list);
		list.append(rt.getKey());
		inorderHelper(rt.getRight(), list);
		// fill your code

	}

	public int rangeSearch(String from, String to) {
		return rangeSearchHelper(root, from, to);
	}

	private int rangeSearchHelper(BinaryNode rt, String from, String to){
		if(rt == null) return 0;
		if(rt.getKey().compareTo(from)>=0 && rt.getKey().compareTo(to)<=0) {
			return 1 + rangeSearchHelper(rt.getLeft(), from, to) + rangeSearchHelper(rt.getRight(), from, to);
		}
		return 0;
	}


	/** @return The current subtree, modified to contain
	the new item */
	private BinaryNode inserthelp(BinaryNode rt, String name, int grade) {
		if(rt == null) { return new BinaryNode(name, grade); }
		if(rt.getKey().compareTo(name) > 0) {
			rt.setLeft(inserthelp(rt.getLeft(), name, grade));
		} else {
			rt.setRight(inserthelp(rt.getRight(), name, grade));
		}
		return rt;
	}

	/** Remove a node with key value k
	 @return The tree with the node removed */
	private BinaryNode removehelp(BinaryNode rt, String name) {
		if(rt == null) return null;
		if(rt.getKey().compareTo(name) > 0) {
			rt.setLeft(removehelp(rt.getLeft(), name));
		}
		else if(rt.getKey().compareTo(name) < 0) {
			rt.setRight(removehelp(rt.getRight(), name));
		} else {
			if(rt.getRight() == null) {
				return rt.getLeft();
			}
			else if(rt.getLeft() == null) {
				return rt.getRight();
			} else {
				BinaryNode temp = getmin(rt);
				rt.setElement(temp.getElement());
				rt.setKey(temp.getKey());
				rt.setRight(deletemin(rt));
			}
		}
		return rt;
	}

	private BinaryNode getmin(BinaryNode rt) {
		while(!rt.isLeaf()) {
			rt = rt.getLeft();
		}
		return rt;

	}

	private BinaryNode deletemin(BinaryNode rt) {
		if(rt == null) return null;
		if(rt.getLeft() == null) {
			return rt.getRight();
		} else {
			rt.setLeft(deletemin(rt.getLeft()));
			return rt;
		}
	}
}