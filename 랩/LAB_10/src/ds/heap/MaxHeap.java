package ds.heap;


import java.lang.Comparable;

/** Max-heap implementation */
public class MaxHeap<E extends Comparable<? super E>> {
	private E[] Heap;   // Pointer to the heap array
	private int size;   // Maximum size of the heap
	private int n;      // Number of things in heap

	/** Constructor supporting preloading of heap contents */
	public MaxHeap(E[] h, int num, int max){ 
		Heap = h;  
		n = num;  
		size = max;  
		buildheap(); 
	}

	/** @return Current size of the heap */
	public int heapsize() { 
		return n; 
	}

	/** @return True if pos a leaf position, false otherwise */
	public boolean isLeaf(int pos){ 
		return (pos >= n/2) && (pos < n); 
	}

	/** @return Position for left child of pos */
	public int leftchild(int pos) {
		assert pos < n/2 : "Position has no left child";
		return 2*pos + 1;
	}

	/** @return Position for right child of pos */
	public int rightchild(int pos) {
		assert pos < (n-1)/2 : "Position has no right child";
		return 2*pos + 2;
	}

	/** @return Position for parent */
	public int parent(int pos) {
		assert pos > 0 : "Position has no parent";
		return (pos-1)/2;
	}

	private void swap(E[] A, int p1, int p2) {
		E temp = A[p1];
		A[p1] = A[p2];
		A[p2] = temp;
	}
	
	/** Heapify contents of Heap */
	public void buildheap(){
		// fill your code
		for (int pos = heapsize() - 1; pos >= 0; pos--) {
			siftdown(pos);
		}
	}

	/** Insert val into heap */
	public void insert(E val) {
		Heap[n++] = val;

		for (int i = n - 1; i > 0; i = parent(i)) {
			if (Heap[parent(i)].compareTo(Heap[i]) >= 0) return;
			else swap(Heap, parent(i), i);
		}
	}

	/** Put element in its correct place */
	private void siftdown(int pos) {
		while (!isLeaf(pos)) {
			int j = leftchild(pos);
			if ((j < (n - 1)) && (Heap[j].compareTo(Heap[j + 1]) < 0)) j++;
			if (Heap[pos].compareTo(Heap[j]) >= 0) return;
			swap(Heap, pos, j);
			pos = j;
		}
	}

	/** Remove and return maximum value */
	public E removemax() {
		E result = Heap[0];
		Heap[0] = Heap[--n];
		siftdown(0);
		return result;
	}
}