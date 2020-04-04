package ds.sort;


public class InsertionSorter<K extends Comparable<? super K>> {

	/**
	 * Sorts the elements in given array from `left` to `right` in lexicograph order using insertion sort algorithm.
	 */

	public void sort(Pair<K, ?>[] array, int left, int right) {
		for(int i = left+1; i< right+1; i++) {
			for(int j = i; (j>left)&&(array[j].getKey().compareTo(array[j-1].getKey())<0) ; j-- ) {
				swap(array, j, j-1);
			}
		}
	}

	public void swap(Pair<K, ?>[] array, int i, int j) {
		Pair<K, ?> temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
		
