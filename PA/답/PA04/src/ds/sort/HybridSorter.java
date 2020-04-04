package ds.sort;


import java.lang.reflect.Array;

public class HybridSorter<K extends Comparable<? super K>> {
	InsertionSorter<K> insertionSort = new InsertionSorter<K>();
	private final int RUN = 32;

	/**
	 * Sorts the elements in given array from `left` to `right in lexicographic order
	 * using the hybrid sorting algorithm.
	 */


	public Pair<K, ?> search(Pair<K, ?>[] array, int k) {

		return array[k];
	}

	public void sort(Pair<K, ?>[] array, int l, int r) {
		int i, j, k;
		int mid = (l + r) / 2;
		if (l == r) return;
		if ((mid - l) >= RUN) {
			sort(array, l, mid);
		} else insertionSort.sort(array, l, mid);

		if ((r - mid) > RUN) {
			sort(array, mid + 1, r);
		} else insertionSort.sort(array, mid + 1, r);


		Pair<K, ?>[] temp = (Pair<K, ?>[]) Array.newInstance(Pair.class, array.length);

		for (i = l; i <= mid; i++)
			temp[i-l] = array[i];
		for (j = 1; j <= r - mid; j++)
			temp[r - j + 1] = array[j + mid];
		for (i = l, j = r, k = l; k <= r; k++) {
			if (temp[i].getKey().compareTo(temp[j].getKey()) < 0) {
				array[k] = temp[i++];
			} else array[k] = temp[j--];
		}
	}
}



	/*

	public void sorthelper(Pair<K, ?>[] array, int l, int r) {
		int i, j, k;
		int mid = (l + r) / 2;
		Pair<K, ?>[] temp = (Pair<K, ?>[]) Array.newInstance(Pair.class, r-l+1);

		for (i = l; i <= mid; i++)
			temp[i] = array[i];
		for (j = 1; j <= r - mid; j++)
			temp[r - j + 1] = array[j + mid];
		for (i = l, j = r, k = l;  k <= r; k++) {
			if (temp[i].getKey().compareTo(temp[j].getKey()) < 0) {
				array[k] = temp[i++];
			} else array[k] = temp[j--];
		}


	}
}


for (i=l; i<=mid; i++)
			temp[i] = array[i];
		for (j=1; j<=r-mid; j++)
			temp[r-j+1] = array[j+mid];
		for (i=l,j=r,k=l; k<=r; k++){
			if (temp[i].getKey().compareTo(temp[j].getKey())<0)
				array[k] = temp[i++];
			else array[k] = temp[j--];




for (int curr = l; curr <= r; curr++) {
			if (i1 == mid + 1)
				array[curr] = temp[i2++];
			else if (i2 > r)
				array[curr] = temp[i1++];
			else if (temp[i1].getKey().compareTo(temp[i2].getKey()) < 0)
				array[curr] = temp[i1++];
			else array[curr] = temp[i2++];



	public void sort(Pair<K, ?>[] array, int left, int right) {
		if (right - left <= RUN)
			insertionSort.sort(array, left, right);
		else {
			int mid = (left + right) / 2;
			sort(array, left, mid);
			sort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}

	public void merge(Pair<K, ?>[] f, int p, int q, int r) {

		int i = p;
		int j = q;
		Pair<K, ?>[] temp = f;
		int t = 0;
		while (i < q && j < r) {
			if (f[i].getKey().compareTo(f[j].getKey()) <= 0) {
				temp[t] = f[i];
				i++;
				t++;
			} else {
				temp[t] = f[j];
				j++;
				t++;
			}

			//tag on remaining sequence
			while (i < q) {
				temp[t] = f[i];
				i++;
				t++;

			}
			while (j < r) {
				temp[t] = f[j];
				j++;
				t++;
			}
			//copy temp back to f  if(f[i].getKey() <= f[j].getKey()){
			i = p;
			t = 0;
			while (t < temp.length) {
				f[i] = temp[t];
				i++;
				t++;
			}
		}
	}
}

	public void merge (Pair<K, ?>[] f, int left , int right) {

		Pair<K, ?>[] temp ;
		int mid = (left + right) / 2;
		if (left == right) return;
		merge(f, left, mid);
		merge(f,mid + 1, right);
		for (int i = left; i <= right; i++) {
			temp[i] = f[i];
		}

		int i1 = left;
		int i2 = mid + 1;
		for (int curr = left; curr <= right; curr++) {
			if (i1 == mid + 1)
				f[curr] = temp[i2++];
			else if (i2 > right)
				f[curr] = temp[i1++];
			else if (temp[i1].getKey().compareTo(temp[i2].getKey()) < 0)
				f[curr] = temp[i1++];
			else f[curr] = temp[i2++];
		}
	}

		// Hint: Maybe you need to create the helper methods.

}











public void sort(Pair<K, ?>[] array, int l, int r) {

		int mid = (l + r) / 2;
		if (l == r) return;
		if ((mid - l) >= RUN) {
			sorthelper(array, l, mid);
		} else insertionSort.sort(array, l, mid);

		if ((r - mid) > RUN) {
			sorthelper(array, mid + 1, r);
		} else insertionSort.sort(array, mid + 1, r);
	}

	public void sorthelper(Pair<K, ?>[] array, int l, int r) {
		int i, j, k;
		int mid = (l + r) / 2;
		Pair<K, ?>[] temp = (Pair<K, ?>[]) Array.newInstance(Pair.class, r - l + 1);

		for (i = l; i <= mid; i++)
			temp[i] = array[i];
		for (j = 1; j <= r - mid; j++)
			temp[r - j + 1] = array[j + mid];
		for (i = l, j = r, k = l;  k <= r; k++) {
			if (temp[i].getKey().compareTo(temp[j].getKey()) < 0)
				array[k] = temp[i++];
			else array[k] = temp[j--];
		}


	}
}



*/