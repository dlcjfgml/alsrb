package ds.hash;

public class HashTable {
	Integer[] table;
	int c1, c2, c3;
	int marker = -1;
	
	public HashTable(int n) {
		table = new Integer[n];
		for(int i=0; i<n; i++) {
			table[i] = null;
		}
	}

	public void Create(int c1, int c2, int c3){
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}
	
	public void Insert(Integer key){
		int hashed_key = key.intValue() % 1009;
		if(table[hashed_key] == null || table[hashed_key].equals(-1)) {
			table[hashed_key] = key;
			System.out.println("INSERT: "+key+ " / INDEX: "+hashed_key);
		}
		else {
			int i = 1;
			while(true) {
				hashed_key = (key.intValue() + c1*i*i + c2*i +c3) % 1009;
				if(table[hashed_key]==null || table[hashed_key].equals(-1)) {
					table[hashed_key] = key;
					System.out.println("INSERT: "+key+ " / INDEX: "+hashed_key);
					return;
				}
				else if(table[hashed_key].compareTo(key) == 0) {
					return;
				} else {
					i++;
				}
			}
		}
	}

	public void Delete(Integer key){
		int index = SearchHelper(key);
		if(index == -1)
			System.out.println("Failed to find " + key + ".");
		else {
			System.out.println("DELETE: "+key+ " / INDEX: "+index);
			table[index] = marker;
		}
	}
	
	public void Search(Integer key){
		int index = SearchHelper(key);
		if(index == -1)
			System.out.println("Failed to find " + key + ".");
		else
			System.out.println("SEARCH: "+key+ " / INDEX: "+index);
	}
	
	private int SearchHelper(Integer key) {
		int hashed_key = key.intValue() % 1009;
		if(table[hashed_key]==null) {
			return -1;
		}
		else if(table[hashed_key].equals(key)) {
			return hashed_key;
		}
		else {
			int i = 1;
			while(true) {
				hashed_key = (key.intValue() + c1*i*i + c2*i + c3) % 1009;
				if(table[hashed_key] == null) {
					return -1;
				}
				else if(table[hashed_key].equals(key)) {
					return hashed_key;
				}
				else {
					i++;
				}
			}
		}
	}
}
