package ds.humanResource;

public class ParPtrTree {
	private Integer[] Parent; 
	private Integer[] Ability; 
	private Integer[] GroupAbility; 
	private Integer[] GroupSize; 
	
	public ParPtrTree(int size) {
		Parent = new Integer[size];
		for (int i = 0; i < size; i++)
			Parent[i] = null;
		
		Ability = new Integer[size]; 
		for (int i = 0; i < size; i++)
			Ability[i] = null;
		
		GroupAbility = new Integer[size]; 
		for (int i = 0; i < size; i++)
			GroupAbility[i] = null;
		
		GroupSize = new Integer[size];
		for (int i = 0; i < size; i++)
			GroupSize[i] = null;
	}
	
	public void setAbility(Integer index, Integer ability) {
		// fill your code
		Ability[index] = ability;
	}
	
	public void setGroupAbility(Integer index, Integer GA) {
		// fill your code
		GroupAbility[FIND(index)] = GA;
	}

	public void setGroupSize(Integer index, Integer GS) {
		// fill your code
		GroupSize[FIND(index)] = GS;
	}
	
	public void addGroupAbility(Integer index, Integer GA) {
		// fill your code
		GroupAbility[FIND(index)] = GroupAbility[FIND(index)] + GA;
	}
	
	public void addGroupSize(Integer index, Integer GS) {
		// fill your code
		GroupSize[FIND(index)] = GroupSize[FIND(index)] + GS;
	}
	
	public Integer getAbility(Integer index) {
		// fill your code
		return Ability[index];
	}

	public Integer getGroupAbility(Integer index) {
		// fill your code
		return GroupAbility[FIND(index)];
	}
	
	public Integer getGroupSize(Integer index) {
		// fill your code
		return GroupSize[FIND(index)];
	}
	
	public Integer getDepth(Integer index) {
		// fill your code
		int cnt = 0;
		while(Parent[index] != null) {
			cnt++;
			index = Parent[index];
		}
		return cnt;
	}

	public boolean differ(int a, int b) {
		Integer rootA = FIND(a);
		Integer rootB = FIND(b);
		
		return rootA != rootB;
	}

	public void UNION(int a, int b) {
		// fill your code
		Integer root1 = FIND_pathCompression(a);
		Integer root2 = FIND_pathCompression(b);
		Parent[root2] = root1;
		GroupAbility[root1] += GroupAbility[root2];
		GroupSize[root1] += GroupSize[root2];
	}

	public Integer FIND_pathCompression(Integer curr) {
		// fill your code
		// must use path compression
		if (Parent[curr] == null) 
			return curr;
		Parent[curr] = FIND_pathCompression(Parent[curr]);
		return Parent[curr];
	}
	
	public Integer FIND(Integer curr) {
		// fill your code
		// without path compression
		while(Parent[curr]!=null){
			curr = Parent[curr];
		}
		return curr;
	}
}
