
public class TowerOfHanoi {

	static int cnt = 0;

	/**
	 * Prints a log message to console.
	 *
	 * @param start The pole where the ring exists
	 * @param goal  The pole where the ring targets
	 */
	public static void move(int start, int goal) {
		// Fill your code to print a log message.
		System.out.print(start + ", " + goal);
	}

	/**
	 * Solves a Tower of Hanoi problem with given condition.
	 *
	 * @param n     The number of all rings
	 * @param start The pole which has the all rings
	 * @param goal  The pole where the rings targets
	 * @param temp  The intermediate pole
	 * @return The number of ring moves to solve a Tower of Hanoi problem
	 */
	public static int towerOfHanoi(int n, int start, int goal, int temp) {
		// Fill your code to solve the Tower of Hanoi problem.
		System.out.println("Move " + n + " rings!");

		if (n == 1) {
			move(start, goal);
			cnt++;
		} else {
			towerOfHanoi(n - 1, start, goal, temp);
			move(start, goal);
			cnt++;
			towerOfHanoi(n - 1, temp, goal, start);
		}
		return cnt;
	}
}
