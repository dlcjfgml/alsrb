package ds.bst;
import ds.list.SingleLinkedList;

public class GradeSearch {
	private BinaryTree bst;
	SingleLinkedList p = new SingleLinkedList();

	public GradeSearch() {
		bst = new BinaryTree();
	}
	
    // Implement more constructors HERE
	
	public void add(String name, int grade){
		bst.insert(name, grade);
	}
	
	public int remove(String name){
		return bst.remove(name);
	}
	
	public int get(String name){
		return bst.find(name);
	}
	
	public int size() {
		return bst.size();
	}
	
	public void order(){
		SingleLinkedList temp = new SingleLinkedList();
		bst.inorder(temp);
		if(temp.getValue() == null) {
			System.out.println("GradeSearch does not have any student");
			return;
		}
		while(temp.getValue() != null) {
			System.out.println("ORDER: "+temp.getValue()+ " "+ bst.find(temp.getValue()));
			temp.next();
		}
		return;
	}
	
	public String first(){
		SingleLinkedList temp = new SingleLinkedList();
		bst.inorder(temp);
		if(temp.getValue() == null)
			return null;
		return temp.getValue();
	}
	
	public String last(){
		SingleLinkedList temp = new SingleLinkedList();
		bst.inorder(temp);
		if(temp.getValue() == null) {
			return null;
		}
		temp.moveToEnd();
		temp.prev();
		return temp.getValue();
	}
	
	public int range(String from, String to){
		return bst.rangeSearch(from, to);
	}

}
