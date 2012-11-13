package orderedList;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedList<T> implements OrderedListADT<T>, Iterable<T>, Comparable<T> {
	private int count;
	private LinearNode<T> head;
	private LinearNode<T> tail;
	
	public LinkedList(){
		count = 0;
		head = tail = null;
	}
	@Override
	public T removeFirst() {
		if(isEmpty()){
			return null;
		}
		LinearNode<T> current = head;
		head = current.getNext();
		count--;
		return (T) current;
	}

	@Override
	public T removeLast() {
		LinearNode<T> current = head;
		while(! current.getNext().equals(tail)){
			
		}
		
		return null;
	}

	@Override
	public T remove(T element){
		if(isEmpty()){
			return null;
		}
		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		
		while(current != null && !found){
			if(element.equals(current.getElement())){
				found = true;
			}else 
			{
				previous = current;
				current = current.getNext();
			}
		}
			if(!found){
				return null;
			}
			if(size() == 1){
				head = tail = null;
			}else if(current.equals(head)){
				head = current.getNext();
			}else if(current.equals(tail)){
				tail = previous;
				tail.setNext(null);
			}else{
				previous.setNext(current.getNext());
			}
			count--;
			return current.getElement();
		
		
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T element) {
		LinearNode<T> current = null;
		if(size() > 1){
			
		}else if (size() == 1) {
			if(){
				
			}
		}else{
			head.setElement(element);
			head.setNext(tail);
			tail.setNext(null);
		}
		
	}
	@Override
	public int compareTo(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

}
