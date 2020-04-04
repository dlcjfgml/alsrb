
public class PascalTriangle {

	/**
	 * Computes a binomial coefficient indexed by given n and k.
	 * 
	 * @param n
	 *            The row index of the binomial coefficient
	 * @param k
	 *            The column index of the binomial coefficient
	 * @return The binomial coefficient indexed by given n and k
	 */
	public static int computeBinomialCoef(int n, int k) {
		// Fill your code to compute a binomial coefficient.
		// Note that you have to use recursive function call.
		if(n==k || k == 0)
			return 1;
		else 
			return computeBinomialCoef(n-1, k-1) + computeBinomialCoef(n-1, k);
	}

	/**
	 * Prints a Pascal's triangle with n + 1 rows.
	 * 
	 * @param n
	 *            A number of rows in the triangle
	 */
	public static void drawPascalTriangle(int n) {
		// Fill your code to print a Pascal's triangle with n + 1 rows.
		// Hint 1: use computeBinomialCoef method multiple times.
		// Hint 2: use loop statements
		int i, j;
		for(i=0; i<=n; i++) {
			for(j=0; j<i; j++) {
				System.out.print(computeBinomialCoef(i-1,j) + " ");
			}
			System.out.println();
		}
	}
	
}
