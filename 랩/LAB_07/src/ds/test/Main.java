package ds.test;

import java.io.StringReader;
import java.util.Scanner;

import ds.equiv.ParPtrTree;

public class Main {
	private static final int ERROR = -1;
	private static final int UNIONWU = 0;
	private static final int UNIONDU = 1;
	private static final int DEPTH = 2;
	private static final int GROUPSIZE = 3;
	private static final int DIFFER = 4;
	private static final int FIND = 5;

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int size = 15;
		ParPtrTree PPT = new ParPtrTree(size);

		while(scanner.hasNext()){
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			int Node1 = 0;
			int Node2 = 0;

			switch(getCommandNum(cmd)){
				case UNIONWU:
					Node1 = i_scanner.nextInt() ;
					Node2 = i_scanner.nextInt();
					PPT.unionWU(Node1, Node2);
					break;

				case UNIONDU:
					Node1 = i_scanner.nextInt() ;
					Node2 = i_scanner.nextInt();
					PPT.unionDU(Node1, Node2);
					break;

				case DIFFER:
					Node1 = i_scanner.nextInt() ;
					Node2 = i_scanner.nextInt();
					boolean result = PPT.differ(Node1, Node2);

					if(result) System.out.println("DIFFER: YES");
					else System.out.println("DIFFER: NO");
					break;

				case GROUPSIZE:
					Node1 = i_scanner.nextInt();
					System.out.println("GROUPSIZE: "+PPT.groupsize(Node1));
					break;

				case DEPTH:
					Node1 = i_scanner.nextInt();
					System.out.println("DEPTH: "+PPT.depth(Node1));
					break;
			}
			i_scanner.close();
		}

		scanner.close();
	}


	private static int getCommandNum(String cmd){
		//System.out.println(cmd);
		if(cmd.equals("unionWU"))
			return UNIONWU;
		else if(cmd.equals("unionDU"))
			return UNIONDU;
		else if(cmd.equals("groupsize"))
			return GROUPSIZE;
		else if(cmd.equals("depth"))
			return DEPTH;
		else if(cmd.equals("differ"))
			return DIFFER;
		else if(cmd.equals("find"))
			return FIND;
		else
			return ERROR;
	}

}
