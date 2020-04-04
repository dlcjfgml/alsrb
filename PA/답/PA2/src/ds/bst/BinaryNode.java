package ds.bst;

/** Node class for binary trees */
public class BinaryNode {
    /** Element of this node */
	private String key;
    private int element;
    /** Left and right children of this node */
    private BinaryNode left;
    private BinaryNode right;

    // Declare more variables HERE

    /** A constructor */
    public BinaryNode() {
        element = 0;
        left = right = null;
    }
    // Implement more constructors HERE

	public BinaryNode(String k, int val)
	{ left = right = null; key = k; element = val; }


	public void setKey(String k) { key = k; }
	public void setElement(int v) { element = v; }

	
    /** Returns the element */
    public String getKey() {
        return key;
    }
    
    /** Returns the element */
    public int getElement() {
        return element;
    }

    /** Returns the left child */
    public BinaryNode getLeft() {
        return left;
    }

    /** Returns the right child */
    public BinaryNode getRight() {
        return right;
    }

    /** Set the left child as the given node l */
    public void setLeft(BinaryNode l) {
        left = l;
    }

    /** Set the right child as the given node r */
    public void setRight(BinaryNode r) {
        right = r;
    }

    /** Returns if this node is a leaf or not */
    public boolean isLeaf() {
        return left == null && right == null;
    }

    // Implement more functions HERE
}
