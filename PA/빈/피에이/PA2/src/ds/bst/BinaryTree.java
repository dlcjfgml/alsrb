package ds.bst;

import ds.list.SingleLinkedList;

/**
 * A class of a binary tree.
 */
public class BinaryTree {
    /** Head node for this tree */
    BinaryNode root;
    // Declare more variables HERE

 	/** Constructor */
	public BinaryTree() { 

		// fill your code
	}
    // Implement more constructors HERE

	/** Reinitialize tree */
	public void clear() { 
		// fill your code

	}

	/** Insert a record into the tree. */
	public void insert(String name, int grade) {
		
		// fill your code

	}

	/** Remove a record from the tree. */
	public int remove(String name) {
		// fill your code
		return 0;

	}


	/** @return Record with key value k, null if none exist. */
	public int find(String name) { 
		// fill your code
		return findhelp(root,name);
	}

	/** @return The number of records. */
	public int size() { 

		// fill your code

		return 0; 
	}
	private int findhelp(BinaryNode rt, String name) {

		// fill your code
		
		return 0;
		
	}

	public void inorder(SingleLinkedList list) { 
		inorderHelper(root, list); 
	}
	
	private void inorderHelper(BinaryNode rt, SingleLinkedList list){

		// fill your code
		
	}
	
	public int rangeSearch(String from, String to) { 
		return rangeSearchHelper(root, from, to); 
	}
	
	private int rangeSearchHelper(BinaryNode rt, String from, String to){
		
		// fill your code
		return 0;
	}
	
	
	/** @return The current subtree, modified to contain
 the new item */
	private BinaryNode inserthelp(BinaryNode rt, String name, int grade) {
	
		return null;
		// fill your code
	}
	
	/** Remove a node with key value k
  @return The tree with the node removed */
	private BinaryNode removehelp(BinaryNode rt, String name) {

		return null;
	}
	
	private BinaryNode getmin(BinaryNode rt) {
		// fill your code
		
		return null;
		
	}
	
	private BinaryNode deletemin(BinaryNode rt) {
		
		return null;
	}
	


    // Implement more functions HERE
}
