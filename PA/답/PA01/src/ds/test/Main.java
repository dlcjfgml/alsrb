package ds.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BabyCalculator babyCalculator = new BabyCalculator();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String command = sc.next();

			if ("ADD".equals(command)) {

				String equation = sc.next();
				babyCalculator.murmurAdd(equation);

			} else if ("SHOW".equals(command)) {

				System.out.println("VALUE " + babyCalculator.getValue() );

			} else if ("CLEAR".equals(command)) {
				babyCalculator.setValue(0);
				System.out.println("VALUE CLEARED");

			} else if ("SET".equals(command)) {

				int newValue = sc.nextInt();
				babyCalculator.setValue(newValue);
				System.out.println("VALUE SET TO " + newValue);

			} else if ("EXIT".equals(command)) {

				System.out.println("FINAL VALUE " + babyCalculator.getValue());

			}
		}
		sc.close();
	}
}
