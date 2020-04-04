package ds.humanResource;

public class ParPtrTree {
	private Integer[] Parent; // The value of the array is the index of parent
	private Integer[] Ability; // The value of the array is the ability of corresponding member
	private Integer[] GroupAbility; // The value of the array is the total group ability. This is available only for leader.
	private Integer[] GroupSize; // The value of the array is the number of group members. This is available only for leader.
	
	public ParPtrTree(int size) {
		Parent = new Integer[size]; // Create parent array
		for (int i = 0; i < size; i++)
			Parent[i] = null;
		
		Ability = new Integer[size]; // Create ability array
		for (int i = 0; i < size; i++)
			Ability[i] = null;
		
		GroupAbility = new Integer[size]; // Create GroupAbility array
		for (int i = 0; i < size; i++)
			GroupAbility[i] = null;
		
		GroupSize = new Integer[size]; // Create GroupSize array
		for (int i = 0; i < size; i++)
			GroupSize[i] = null;
	}
	
	public void setAbility(Integer index, Integer ability) {
		// fill your code
	}
	
	public void setGroupAbility(Integer index, Integer GA) {
		// fill your code
	}
	
	public void setGroupSize(Integer index, Integer GS) {
		// fill your code
	}
	
	public void addGroupAbility(Integer index, Integer GA) {
		// fill your code
	}
	
	public void addGroupSize(Integer index, Integer GS) {
		// fill your code
	}
	
	public Integer getAbility(Integer index) {
		// fill your code
		return null;
	}

	public Integer getGroupAbility(Integer index) {
		// fill your code
		return null;
	}
	
	public Integer getGroupSize(Integer index) {
		// fill your code
		return null;
	}
	
	public Integer getDepth(Integer index) {
		// fill your code
		return null;
	}

	/** Determine if nodes are in different trees */
	public boolean differ(int a, int b) {
		// fill your code
		return true;
	}

	/** Merge two subtrees.
	 * 'b' group is attached to 'a' group, which means that the leader of 'a' group goes to the leader of the merged group. */
	public void UNION(int a, int b) {
		// fill your code
		return;
	}

	/** Find the root node and connect the curr node to root directly. **/
	public Integer FIND_pathCompression(Integer curr) {
		// fill your code
		// must use path compression
		return null;
	}
	
	/** Find the root of the curr’s tree. No path compression */
	public Integer FIND(Integer curr) {
		// fill your code
		// without path compression
		return null;
	}
}
