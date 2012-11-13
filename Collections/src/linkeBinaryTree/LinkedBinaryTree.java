package linkeBinaryTree;
/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 * 
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/19/08
 */



import java.util.Iterator;
import exceptions.*;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
	protected int count;
	protected BinaryTreeNode<T> root;

	/**
	 * Creates an empty binary tree.
	 */
	public LinkedBinaryTree() {
		count = 0;
		root = null;
	}

	/**
	 * Creates a binary tree with the specified element as its root.
	 * 
	 * @param element
	 *            the element that will become the root of the new binary tree
	 */
	public LinkedBinaryTree(T element) {
		count = 1;
		root = new BinaryTreeNode<T>(element);
	}

	/**
	 * Returns a reference to the specified target element if it is found in
	 * this binary tree. Throws a NoSuchElementException if the specified target
	 * element is not found in the binary tree.
	 * 
	 * @param targetElement
	 *            the element being sought in this tree
	 * @return a reference to the specified target
	 * @throws RuntimeException 
	 * @throws ElementNotFoundException
	 *             if an element not found exception occurs
	 */
	public T find(T targetElement) throws RuntimeException {
		BinaryTreeNode<T> current = findAgain(targetElement, root);

		if (current == null)
			throw new RuntimeException("binary tree");

		return (current.element);
	}

	/**
	 * Returns a reference to the specified target element if it is found in
	 * this binary tree.
	 * 
	 * @param targetElement
	 *            the element being sought in this tree
	 * @param next
	 *            the element to begin searching from
	 */
	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
		if (next == null)
			return null;

		if (next.element.equals(targetElement))
			return next;

		BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

		if (temp == null)
			temp = findAgain(targetElement, next.right);

		return temp;
	}

	/**
	 * Performs an inorder traversal on this binary tree by calling an
	 * overloaded, recursive inorder method that starts with the root.
	 * 
	 * @return an in order iterator over this binary tree
	 */
	public Iterator<T> iteratorInOrder() {
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inorder(root, tempList);

		return tempList.iterator();
	}

	/**
	 * Performs a recursive inorder traversal.
	 * 
	 * @param node
	 *            the node to be used as the root for this traversal
	 * @param tempList
	 *            the temporary list for use in this traversal
	 */
	protected void inorder(BinaryTreeNode<T> node,
			ArrayUnorderedList<T> tempList) {
		if (node != null) {
			inorder(node.left, tempList);
			tempList.addToRear(node.element);
			inorder(node.right, tempList);
		}
	}

	@Override
	public boolean contains(T targetElement) {
		boolean found = false;

		try {
			find(targetElement);
			found = true;
		} catch (Exception ElementNotFoundException) {
			found = false;
		}

		return found;
	}

	@Override
	public T getRoot() {
		
		return (T) root;
	}

	@Override
	public boolean isEmpty() {
		if(count == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		
		return count;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void preorder(BinaryTreeNode<T> node,
			ArrayUnorderedList<T> tempList) {
		if (node != null) {
			tempList.addToRear(node.element);
			preorder(node.left, tempList);
			preorder(node.right, tempList);
		}
	}

	
	public String toString(){
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		preorder(root, tempList);

		return tempList.toString();
	}
}
