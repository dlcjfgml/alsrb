
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BST<Integer, Integer> tree = new BST<Integer, Integer>();

		while (scanner.hasNext()) {
			String cmd = scanner.next();
			Integer key = 0;
			Integer value = 0;
			
			if ("insert".equals(cmd)) {
				key = scanner.nextInt();
				value = scanner.nextInt();
				tree.insert(key, value);
			} else if ("find".equals(cmd)) {
				key = scanner.nextInt();
				value = tree.find(key);
				if (value != null) {
					System.out.println("Find: " + key + " " + value);
				} else {
					System.out.println("Find: not found");
				}
			} else if ("deletemin".equals(cmd)) {
				BSTNode<Integer, Integer> node = tree.deleteMin();
				if (node != null) {
					System.out.println("DeleteMin: " + node.key() + " " + node.element());
				} else {
					System.out.println("DeleteMin: empty");
				}
			} else if ("preorder".equals(cmd)) {
				tree.preorder();
			} else if ("inorder".equals(cmd)) {
				tree.inorder();
			} else if ("postorder".equals(cmd)) {
				tree.postorder();
			} else if ("size".equals(cmd)) {
				System.out.println("Size: " + tree.size());
			}
		}

		scanner.close();
	}

}
