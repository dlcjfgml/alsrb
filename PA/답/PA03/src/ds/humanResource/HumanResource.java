package ds.humanResource;

public class HumanResource {
	private ParPtrTree PPT;
	private static final int MAXMEMBER = 100000;
	
	public HumanResource(){
		PPT = new ParPtrTree(MAXMEMBER);
	}
	
	public void Hire(int member, int ability){
		PPT.setAbility(member, ability);
		PPT.setGroupAbility(member, ability);
		PPT.setGroupSize(member, 1);
		// fill your code
	}
	
	public boolean Merge(int member1, int member2){
		// fill your code
		Integer rootA = PPT.FIND(member1);
		Integer rootB = PPT.FIND(member2);
		if(rootA == rootB) 
			return false;
		else {
			if(PPT.getGroupAbility(rootA) > PPT.getGroupAbility(rootB)) {
				PPT.UNION(member1, member2);
			}
			else if(PPT.getGroupAbility(rootA) < PPT.getGroupAbility(rootB)) {
				PPT.UNION(member2, member1);
			}
			else {
				if(rootA < rootB) 
					PPT.UNION(member1, member2);
				else 
					PPT.UNION(member2, member1);
			}
			return true;
		}
	}
	
	public void AbilityOfPerson(int member){
		// fill your code
		System.out.println(PPT.getAbility(member));
	}
	
	public void DepthOfPerson(int member){
		// fill your code
		System.out.println(PPT.getDepth(member));
	}
	
	public void AbilityOfGroup(int member) {
		// fill your code
		System.out.println(PPT.getGroupAbility(member));
	}
	
	public void SizeOfGroup(int member) {
		// fill your code
		System.out.println(PPT.getGroupSize(member));
	}
}
