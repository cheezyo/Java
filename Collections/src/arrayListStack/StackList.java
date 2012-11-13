package arrayListStack;

public class StackList<T> implements ListADT<T> {
	
	protected int count;
	private final int DEFAULT_CAPACITY = 2;
	protected T [] list;
	public StackList(){
		list = (T[]) (new Object[DEFAULT_CAPACITY]);
		count = 0;
	}

	
	public void expandCapacity(){
		 T[] temp =(T[])(new Object[list.length * 2]);
		 for(int i = 0; i < list.length; i++){
			 temp[i] = list[i];
		 }
		 list = temp;
	}
	public void add(T element){
		if(size() == list.length)
			expandCapacity();

		list[count] = element;
		count++;
		
		
		
	}
	@Override
	public T removeFirst() {
		T element = list[size() - 1];
		list[size()] = null;
		count--;
		return element;
	}

	@Override
	public T first() {
		if(!isEmpty())
		return list[size() -  1];
		else return null;
	}

	@Override
	public boolean isEmpty() {
		if(size() > 0)
		return false;
		else 
			return true;
	}

	@Override
	public int size() {
		return count;
	}

}
