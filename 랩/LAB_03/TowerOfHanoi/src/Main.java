import java.util.Scanner;

public class Main {


	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		
		while (sc.hasNext()) {
			int n = sc.nextInt();
			TowerOfHanoi.towerOfHanoi(n, int start, int goal, int temp );
			int a = TowerOfHanoi.towerOfHanoi(n, int start, int goal, int temp);
			System.out.println("Solved with " + a + " moves!" );
		}


		sc.close();
	}

}


	TowerOfHanoi p = new TowerOfHanoi();
