package ds.stack;
import ds.list.LinkedList;

public class LinkedStack<E> implements Stack<E> {

	LinkedList p1 = new LinkedList();

	@Override
	public void clear() {
		p1.clear();
	}

	@Override
	public void push(E item) {
		p1.insert(p1.cnt, item);
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			return null;
		} else
			return (E) p1.remove(p1.cnt-1);
	}

	@Override
	public int length() {
		return p1.cnt;
	}

	@Override
	public boolean isEmpty() {
		if(length() == 0)
			return true;
		else
			return false;
	}

}
