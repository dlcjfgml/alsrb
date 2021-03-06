package ds.main;
import java.io.StringReader;
import java.util.Scanner;

import ds.bst.GradeSearch;

public class Main {
	private static final int ADD = 0;
	private static final int REMOVE = 1;
	private static final int GET = 2;
	private static final int SIZE = 3;
	private static final int ORDER = 4;
	private static final int FIRST = 5;
	private static final int LAST = 6;
	private static final int RANGE = 7;
	private static final int ERROR = 8;

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		GradeSearch gradeSearch = new GradeSearch();
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			String name = null;
			int grade = 0;
			
			switch(getCommandNum(cmd)){
			case ADD:
				name = i_scanner.next();
				grade = Integer.parseInt(i_scanner.next());
				
				// fill your code
			
				break;
			case REMOVE:
				name = i_scanner.next();

				// fill your code
				
				break;
			case GET:
				name = i_scanner.next();

				// fill your code
			
				break;
			case SIZE:	

				// fill your code
				
				break;
			case ORDER:

				// fill your code
			
				break;
			case FIRST:

				// fill your code
			
				break;
			case LAST:

				// fill your code
			
				break;
			case RANGE:
				String from = i_scanner.next();
				String to = i_scanner.next();

				// fill your code
			
				break;
			case ERROR:
				break;
			}
			
			
			i_scanner.close();
		}
		
		scanner.close();
	}
	
	private static int getCommandNum(String cmd){
		//System.out.println(cmd);
		if(cmd.equals("add"))
			return ADD;
		else if(cmd.equals("remove"))
			return REMOVE;
		else if(cmd.equals("get"))
			return GET;
		else if(cmd.equals("size"))
			return SIZE;
		else if(cmd.equals("order"))
			return ORDER;
		else if(cmd.equals("first"))
			return FIRST;
		else if(cmd.equals("last"))
			return LAST;
		else if(cmd.equals("range"))
			return RANGE;
		return ERROR;
	}

}
