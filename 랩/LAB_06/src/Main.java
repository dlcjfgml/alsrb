
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("testcase/sample input.txt"));
			String line = null;
			int key = 0;
			int value = 0;
			BST<Integer, Integer> bst = new BST<Integer, Integer>();
			while ((line = reader.readLine()) != null) {
//				System.out.print(line + "\t");
				if (line.startsWith("insert")) {
					key = Integer.parseInt(line.split(" ")[1]);
					value = Integer.parseInt(line.split(" ")[2]); 
					//fill in the code
					
				} else if (line.startsWith("find")) {
					key = Integer.parseInt(line.split(" ")[1]);
					//fill in the code

				} else if (line.startsWith("remove")) {
					key = Integer.parseInt(line.split(" ")[1]);
					//fill in the code

				} else if (line.startsWith("getmin")) {
					//fill in the code

				} else if (line.startsWith("getmax")) {
					//fill in the code

				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
