package ds.list;

public class LinkedList<E> implements List<E> {

	public Link<E> head = null;
	public Link<E> curr = null;
	public Link<E> tail = null;
	public int cnt = 0;

	public LinkedList() {
		head = curr = tail = new Link<E>(null, null);
		cnt = 0;
	}


	@Override
	public void insert(int pos, E item) {
		Link<E> temp = head;

		if(pos<0 || pos > length())
			return ;

		for(int i = 0; i<pos; i++) {
			temp = temp.next();
		}
		temp.setNext(new Link<E>(item, temp.next()));
		cnt++;
		if( tail == temp )
			tail = temp.next();

	}



	@Override
	public void clear() {
		head = curr = tail =new Link<E>(null, null);
		cnt = 0;

	}

	@Override
	public E remove(int pos) {
		Link<E> temp = head;

		if(pos<0 || pos > length()-1)
			return null;
		for(int i = 0; i<pos; i++) {
			temp = temp.next();
		}
		E it = temp.next().getElement();
		if(tail == temp.next())
			tail = temp;
		temp.setNext(temp.next().next());
		cnt--;
		return it;

	}

	@Override
	public int length() {
		return cnt ;
	}

	@Override
	public E getValue(int pos) {
		Link<E> temp = head;

		if(pos<0 || pos > length()-1)
			return null;
		for(int i = 0; i<pos; i++) {
			temp = temp.next();
		}
		return temp.next().getElement();
	}

}
