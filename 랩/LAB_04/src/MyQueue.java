public class MyQueue<E> implements Queue<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

	public MyQueue() {
		first = last = null;
		size = 0;
	}

	@Override
	public void enqueue(E item) {
		// TODO Auto-generated method stub
		if(isEmpty()) {

			first = new Node(item, last);
			last = first;
			size++;
			return;
		}
		Node<E> temp = new Node<E>(item, last.getNext());
		last.setNext(temp);
		last = temp;
		size++;
		return;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
			return null;
		E ele = first.getItem();
		first = first.getNext();
		size--;
		return ele;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		Node<E> cursor = first;
		StringBuffer sb = new StringBuffer("(");
		while (cursor != null) {
			sb.append(cursor.getItem());
			if (cursor != last) {
				sb.append(' ');
			}
			cursor = cursor.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

}
