package ds.sort;

public class RadixSorter { 

	public void pass(int[] arr, int i, int base) {
		// TODO
		// Perform 2-pass algorithm bin-sort based on (i)th digit
		int [] bin = new int[base];
		int [] A = new int[arr.length];
		int cnt = 0;

		for (int j =0; j<base; j++){
			bin[j] = 0;
		}

		for (int j = 0; j < arr.length; j++) {
			bin[(int) (arr[j] / (Math.pow(10, i)) % 10)]++;
		}

		for(int j=0; j<base; j++ ) {
			if(bin[j] != 0) {
				for(int k = 0; k<arr.length; k++) {
					if ((int) (arr[k] / (Math.pow(10, i)) % 10) == j)
						A[cnt++] = arr[k];
				}
			}
		}

		for(int j =0; j<arr.length; j++) {
			arr[j] = A[j];
		}
	}

}
