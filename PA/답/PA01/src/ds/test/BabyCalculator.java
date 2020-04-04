package ds.test;
import ds.stack.LinkedStack;
import ds.stack.Stack;

public class BabyCalculator {

	// Using java predefined or built-in data structures are not allowed.
	Stack<Character> stack = new LinkedStack<Character>();
	private int value;

	public int murmurAdd(String equation) {
		// TODO Implement this method
		System.out.print(value);

		for(int i=0; i<equation.length(); i++) {

			char c = equation.charAt(i);
			int digit = Character.getNumericValue(c);
			if(Character.isDigit(c)) {
				stack.push(c);
				value += digit;
			}
			else if(c == '(') {
				stack.push(c);
			}
			else if(c == ')') {
				char temp;
				while(( temp = stack.pop()) != '(' ) {
					System.out.print("+" + temp);
				}
			}
		}

		while(!stack.isEmpty()) {
			System.out.print("+" + stack.pop());
		}
		System.out.println();
		System.out.println("RESULT " + value);

		return 0;
	}

	public int getValue() {
		// TODO Implement this method
		return value;
	}

	public void setValue(int newValue) {
		// TODO Implement this method
		value = newValue;
	}
}