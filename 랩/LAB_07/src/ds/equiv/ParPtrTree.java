package ds.equiv;

import java.util.Arrays;

/** General Tree class implementation for UNION/FIND */
public class ParPtrTree {
	private Integer[] array; // Node array
	private Integer[] size; // groupsize array. Consider only values of root nodes. We don't need to care others.
	private Integer[] depth; // depth array. Consider only values of root nodes. We don't need to case others.

	public ParPtrTree(int maxsize) {
		array = new Integer[maxsize]; // Create node array
		size = new Integer[maxsize];
		depth = new Integer[maxsize];
		for (int i = 0; i < maxsize; i++) {
			array[i] = null;
			size[i] = 1;
			depth[i] = 0;
		}
	}

	/** Determine if nodes are in different trees */
	public boolean differ(Integer a, Integer b) {
		Integer root1 = find(a);
		Integer root2 = find(b);
		return root1 != root2;
	}

	/** Merge two subtrees */
	public void unionWU(Integer a, Integer b) {
		Integer root1 = find(a);
		Integer root2 = find(b);
		if(root1 != root2) {
			if(size[root2] > size[root1]) {
				array[root1] = root2;
				size[root2] += size[root1];
			}
			else {
				array[root2] = root1;
				size[root1] += size[root2];
			}
		}
	}


	public void unionDU(Integer a, Integer b) {
		Integer root1 = find(a);
		Integer root2 = find(b);
		if(root1 != root2) {
			if(depth[root2] > depth[root1]) {
				array[root1] = root2;
				size[root2] += size[root1];

				for(Integer i = 0; i < array.length; i++) {
					if(depth(i) > depth[root2]) {
						depth[root2] = depth(i);
					}
				}
			}
			else {
				array[root2] = root1;
				size[root1] += size[root2];

				for(Integer i = 0; i<array.length; i++) {
					if(depth(i) > depth[root1]) {
						depth[root1] = depth(i);
					}
				}
			}
		}
	}

	public Integer find(Integer curr) {
		if( array[curr] == null)
			return curr;
		array[curr] = find(array[curr]);
		return array[curr];
	}

	/** Return the depth of the node */
	public Integer depth(Integer curr) {
		Integer cnt = 0;
		while(array[curr] != null) {
			cnt++;
			curr = array[curr];
		}
		return cnt;
	}

	/** Return the size of the graph that the node belongs to */
	public Integer groupsize(Integer node) {
		return size[find(node)];
	}

	public void print() {
		System.out.println(Arrays.toString(array).replace("null", "N"));
	}
}
