package likedListStack;

import java.util.Iterator;

public class ArrayList<T> implements ListADT<T>, Iterable<T> {
	protected final int DEFAULT_CAPACITY = 100;
	private final int NOT_FOUND = -1;
	protected int rear;
	protected T[] list;

	public ArrayList() {
		rear = 0;
		list = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	public ArrayList(int initialCapacity) {
		rear = 0;
		list = (T[]) (new Object[initialCapacity]);
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) {
		T result = null;
		int index = find(element);
		if (index == NOT_FOUND)
			// throw new Exception ("list");
			result = list[index];
		rear--;
		// shift the appropriate elements
		for (int scan = index; scan < rear; scan++)
			list[scan] = list[scan + 1];
		list[rear] = null;
		return result;

	}

	public void add(T element) {
		if (size() == list.length)
			expandCapacity();
		Comparable<T> temp = (Comparable<T>) element;
		int scan = 0;
		while (scan < rear && temp.compareTo(list[scan]) > 0)
			scan++;
		for (int scan2 = rear; scan2 > scan; scan2--)
			list[scan2] = list[scan2 - 1];
		list[scan] = element;
		rear++;
	}

	private void expandCapacity() {
		
		
	}

	private int find(T element) {
		int scan = 0, result = NOT_FOUND;
		boolean found = false;
		if (!isEmpty())
			while (!found && scan < rear)
				if (element.equals(list[scan]))
					found = true;
				else
					scan++;
		if (found)
			result = scan;
		return result;
	}

	@Override
	public T first() {
		return null;
	}

	@Override
	public T last() {
		return null;
	}

	@Override
	public boolean contains(T target) {
		return (find(target) != NOT_FOUND);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator<T>(list, rear);
	}
}
