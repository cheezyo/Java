package forelesning2;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Queue;

public class CircularArrayQueue<T> implements Queue<T> {
	   private final int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;
	public CircularArrayQueue() {
		front = rear = count = 0;
		queue = (T[])(new Object[DEFAULT_CAPACITY]);
	}
	
	public CircularArrayQueue (int initialCapacity)  {
		front = rear = count = 0;
		queue = (T[]) (new Object[initialCapacity]);
	}
	public void enqueue (T element)  {
		if(size()== queue.length){
			expandCapacity();
		}
		
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
		
	}
	public T dequeue() throws EmptyStackException   {
		if(rear == queue.length){
			throw new EmptyStackException();
		}
		T result = queue[front];
		queue[front] = null;
		front = (front + 1)% queue.length;
		count--;

		return result;
		}
	public void expandCapacity()   {
		T[] expand = (T[])(new Object[queue.length * 2]);
		
		for(int i = 0; i < queue.length; i++){
			expand[i] = queue[front];
			front = (front + 1) % queue.length;
		}
		front = 0;
		rear = count;
		queue = expand;
	}
	public String toString() {
		
		
		return null;
		}
	public T first(){
		T element = queue[front];
		return element;
		}
	public int size() {
		
		return count;
		}
	public boolean isEmpty() {
		if(size() == 0)return true;
		else
		return false;
		}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean offer(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
}