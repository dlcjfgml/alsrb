package ds.heap;

import java.util.Arrays;

public class HeapSort<E extends Comparable<? super E>> {
	private MaxHeap<E> maxHeap;
	private int n;
	private E[] array;
	public String addstring = "ADD : ";

	public HeapSort(int n){
		array = newArray(n);
		maxHeap = new MaxHeap<E>(array, 0, n);
		this.n = n;
	}
	
	public void add(E value){
		addstring += (value + " ");
		maxHeap.insert(value);
		System.out.println(addstring);
	}
	
	public void build() {
		maxHeap.buildheap();
		System.out.print("BUILD : ");
		for(int i = 0; i<maxHeap.heapsize(); i++)
			System.out.print(array[i] + " " );
	}
	
	public void sort() {
		System.out.print("SORT : ");
		int heapsize = maxHeap.heapsize();
		E[] A = newArray(n);
		for(int i = 0; i<heapsize; i++) {
			A[i] = maxHeap.removemax();
			System.out.print(A[i] + " ");
		}
		System.out.println();

		for(int i =0; i<heapsize; i++) {
			array[i] = A[i];
			maxHeap.insert(A[i]);
		}
	}
	
	//This function is for allocating an generic array of size n
	private static <E> E[] newArray(int length, E... array)
	{
	    return Arrays.copyOf(array, length);
	}
}
