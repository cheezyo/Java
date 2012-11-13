package likedListStack;

import java.util.Iterator;

import arrayListStack.StackList;

public class Client {
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("Hei");
		myList.add("Hade");
		
		Iterator<String> i = myList.iterator();
		
		StackList<String> list = new StackList<String>();
		list.add("BLa");
		list.add("bleee");
		System.out.println(list.size());
		
		
	}
}
