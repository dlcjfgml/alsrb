
public interface Queue<E> {
	
	public void enqueue(E item);
	public E dequeue();
	public void clear();
	public int size();
	
}
