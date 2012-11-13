package pcLab;

import java.util.Iterator;

public class TreeTest {
	public static void main(String[] args) {
		LinkedBinarySearchTree<Integer> tree 
			= new LinkedBinarySearchTree<Integer>();
		tree.addElement(6);
		tree.addElement(8);
		tree.addElement(7);
		tree.addElement(9);
		tree.addElement(5);
		tree.addElement(4);
		tree.addElement(9);
		tree.addElement(12);
		tree.addElement(9);
		tree.addElement(1);
		
		Iterator<Integer> iterator = tree.iteratorLevelOrder();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		
		tree.removeAllOccurrences(9);
		iterator = tree.iteratorLevelOrder();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(tree.contains(1));
//		System.out.println(tree.depth(10));
	}

	private static void print(LinkedBinarySearchTree<Integer> tree) {
		Iterator<Integer> iterator = tree.iteratorLevelOrder();
		int n = 0;
		int fac = 1;
		int c = 4;
		System.out.printf("%" + (c * 3) + "s", " ");
		while (iterator.hasNext()) {
			System.out.printf("%6d", iterator.next());
			n++;
			if (n == fac) {
				System.out.println();
				n = 0;
				fac *=2;
				c--;
				String f = "%" + (c * 3) + "s";
				System.out.printf(f, " ");
			}
		}
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println();
	}
}
