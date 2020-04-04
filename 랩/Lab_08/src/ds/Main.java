package ds;

import java.io.StringReader;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String line = "";
		Scanner scanner = new Scanner(System.in);
		MinHeap<HuffTree<Character>> Hheap = 
				new MinHeap<>((HuffTree<Character>[])new HuffTree[100], 0, 100);
		HuffTree<Character> tree = null;

		while (true) {
			line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();

			if (cmd.equals("freq")) {
				char c = i_scanner.next().charAt(0);
				int freq = Integer.valueOf(i_scanner.next());
				HuffTree<Character> t = new HuffTree<Character>(c, freq);
				Hheap.insert(t);
			} else if (cmd.equals("build")) {
				tree = buildTree(Hheap);
			} else if (cmd.equals("encode")) {
				String res = encode(tree, i_scanner.next());
				System.out.println("encoded: " + res);
			} else if (cmd.equals("decode")) {
				String res = decode(tree, i_scanner.next());
				System.out.println("decoded: " + res);
			} else if (cmd.equals("show")) {
				show(tree.root(), "");
			} else if (cmd.equals("quit")) {
				i_scanner.close();
				break;
			} else {
				System.out.println("Wrong command!");
			}
			
			i_scanner.close();
		}
		
		scanner.close();
	}

	public static HuffTree<Character> buildTree(MinHeap<HuffTree<Character>> Hheap) {
		HuffTree<Character> first, second, bt = null;

		while (Hheap.heapsize() > 1 ) {
			first = Hheap.removemin();
			second = Hheap.removemin();
			bt = new HuffTree(first.root(), second.root(), first.weight()+second.weight());
			Hheap.insert(bt);
		}
		return bt;
	}
	
	public static String encode(HuffTree<Character> tree, String codes) {
		String prefix = "";
		String code = "";

		for(int i = 0; i<codes.length(); i++) {
			code = code + encodeRecur(tree.root(), codes.charAt(i), prefix );
			prefix = "";
		}
		return code;

	}

	private static String encodeRecur(HuffBaseNode<Character> tree, char c, String prefix) {
		if(tree.isLeaf()) {
			if(((HuffLeafNode<Character>)tree).element() == c)
				return prefix;
			else
				return "";
		}
		else {
			HuffInternalNode<Character> temp = (HuffInternalNode<Character>)tree;
			return encodeRecur(temp.right(), c, prefix + "1") + encodeRecur(temp.left(), c, prefix + "0");
		}

	}


	public static String decode(HuffTree<Character> tree, String codes) {

		HuffBaseNode<Character> temp = tree.root();
		String prefix = "";

		for (int i = 0; i < codes.length(); i++) {
			if (codes.charAt(i) == '0')
				temp = ((HuffInternalNode<Character>) temp).left();
			else
				temp = ((HuffInternalNode<Character>) temp).right();

			if (temp.isLeaf()) {
				prefix += ((HuffLeafNode<Character>) temp).element();
				temp = tree.root();
			}
		}

		return prefix;
	}



	public static void show(HuffBaseNode<Character> tree, String prefix) {

		if (tree.isLeaf()) {
			System.out.println(((HuffLeafNode<Character>) tree).element() + " " + tree.weight() + " " + prefix);
		} else {
			HuffInternalNode<Character> temp = (HuffInternalNode<Character>) tree;
			show(temp.right(), prefix + "1");
			show(temp.left(), prefix + "0");
		}
	}
}

