package ds.test;

import java.io.StringReader;
import java.util.Scanner;

import ds.heap.HeapSort;

public class Main {
	private static final int ERROR = -1;
	private static final int ADD = 0;
	private static final int BUILD = 1;
	private static final int SORT = 2;

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int size = 100;
		HeapSort<Integer> hs = new HeapSort<Integer>(size);
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			int value = 0;
			
			switch(getCommandNum(cmd)){
				case ADD:
					value = i_scanner.nextInt();
					hs.add(value);
					break;

				case BUILD:
					hs.build();
					break;

				case SORT:
					hs.sort();
					break;
			}
			i_scanner.close();
		}
		
		scanner.close();
	}
	
	private static int getCommandNum(String cmd){
		if(cmd.equals("add"))
			return ADD;
		else if(cmd.equals("build"))
			return BUILD;
		else if(cmd.equals("sort"))
			return SORT;
		else 
			return ERROR;
	}

}
