package ds.test;

import java.util.Arrays;
import java.util.Scanner;

import ds.sort.RadixSorter;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RadixSorter rsort = new RadixSorter();
		int[] input = null;
		int size = 0;
		int base = 10;

		while (sc.hasNext()) {
			String command = sc.next();
			if (command.startsWith("input")) {
				size = sc.nextInt();
				input = new int[size];
				int i = 0;
				while (sc.hasNextInt() && i < size) {
					input[i++] = sc.nextInt();
				}
				command = sc.nextLine();
			} else if ("pass".equals(command)) {
				int i = sc.nextInt();
				rsort.pass(input, i-1, base);
			} else if ("print".equals(command)) {
				System.out.println(Arrays.toString(input));
			}
		}
		sc.close();
	}
}
