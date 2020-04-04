package ds;

/** Huffman tree node implementation: Base class */
public interface HuffBaseNode<E> {
	public boolean isLeaf();
	public int weight();
}
