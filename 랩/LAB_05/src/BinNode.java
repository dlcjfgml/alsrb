/** ADT for binary tree nodes */
public interface BinNode<E> {
	/** Get the element value */
	public E element();

	/** Set the element value */
	public void setElement(E v);

	/** @return The left child */
	public BinNode<E> left();

	/** @return The right child */
	public BinNode<E> right();

	/** @return True if a leaf node, false otherwise */
	public boolean isLeaf();
}
