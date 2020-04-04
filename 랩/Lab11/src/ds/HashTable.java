package ds;
public class HashTable<Key extends Comparable<? super Key>, E> {
	private int M; // Size of the table
	private KVpair<Key, E>[] T; // Array of the elements
	private KVpair<Key, E> TombStone = new KVpair<Key, E>(); // Tombstone

	@SuppressWarnings("unchecked") // Allow the generic array allocation
	public HashTable(int m) {
		M = m;
		T = (KVpair<Key, E>[]) new KVpair[M];
	}

	/** Insert record r into T */
	public void hashInsert(Key k, E r) {
		// Fill in your codes
		int hashed = (hash1(k) + hash2(k))%10;
		T[hashed] = new KVpair<Key, E>(k, r);
	}

	/** Search for the record with key k */
	public E hashSearch(Key k) {
		int hashed = (hash1(k) + hash2(k))%10;
		if(T[hashed] == null) {
			return null;
		}
		return T[hashed].value();
	}

	/** Remove a record with key value k from the hash table */
	public E hashRemove(Key k) {
		if (hashSearch(k) == null) {
			return null;
		}
		int hashed = (hash1(k) + hash2(k))%10;
		E temp = T[hashed].value();
		T[hashed] = TombStone;
		return temp;
	}

	public void printHashTable() {
		for(int i=0; i<M; i++) {
			if(T[i] != null) {
				System.out.println("PRINT: ("+T[i].key()+", "+T[i].value()+")");
			}
		}
	}

	/**
	 * If the key is an Integer, then use a simple mod function for the hash
	 * function. If the key is a String, then use folding.
	 */
	private int hash1(Key k) {
		Object keyO = (Object) k;
		if (keyO.getClass() == Integer.class) {
			// Fill in your codes

			return (Integer)keyO % 9;
		} else {
			return k.hashCode() % M;
		}
	}

	/**
	 * If the key is an Integer, then use a simple mod function for the hash
	 * function. If the key is a String, then use folding.
	 */
	private int hash2(Key k) {
		Object keyO = (Object) k;
		if (keyO.getClass() == Integer.class) {
			// Fill in your codes
			return (Integer)keyO % 7;
		} else {
			return k.hashCode() % M;
		}
	}
}
