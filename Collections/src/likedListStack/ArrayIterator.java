package likedListStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

	private int count;
	private int current;
	private T [] items;
	public ArrayIterator(T[] list, int size){
		items = list;
		count = size;
		current = 0;
	}
	@Override
	public boolean hasNext() {
		
		return (current < count);
	}

	@Override
	public T next() {
		if(! hasNext()){
			throw new  NoSuchElementException("finnes ikke");
		}
		
		current++; 
		
		return items[current - 1];
	}

	@Override
	public void remove() {
		

	}

}
