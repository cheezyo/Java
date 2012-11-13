/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface 
 * with links.
 * 
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/19/08
 */

package pcLab;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements
		BinarySearchTreeADT<T> {
	/**
	 * Creates an empty binary search tree.
	 */
	public LinkedBinarySearchTree() {
		super();
	}

	/**
	 * Creates a binary search with the specified element as its root.
	 * 
	 * @param element
	 *            the element that will be the root of the new binary search
	 *            tree
	 */
	public LinkedBinarySearchTree(T element) {
		super(element);
	}

	/**
	 * Adds the specified object to the binary search tree in the appropriate
	 * position according to its key value. Note that equal elements are added
	 * to the right.
	 * 
	 * @param element
	 *            the element to be added to the binary search tree
	 */
/*	
	public void addElement(T element) {
		BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
		Comparable<T> comparableElement = (Comparable<T>) element;

		if (isEmpty())
			root = temp;
		else {
			BinaryTreeNode<T> current = root;
			boolean added = false;

			while (!added) {
				if (comparableElement.compareTo(current.element) < 0) {
					if (current.left == null) {
						current.left = temp;
						added = true;
					} else
						current = current.left;
				} else {
					if (current.right == null) {
						current.right = temp;
						added = true;
					} else
						current = current.right;
				}
			}
		}

		count++;
	}
*/
	//Metoden addElement er lagt til i klassen BinaryTreeNode
	public void addElement(T element) {
		if (isEmpty())
			root = new BinaryTreeNode<T>(element);
		else {
			root.addElement(element);
		}
		count++;
	}

	/**
	 * Removes the first element that matches the specified target element from
	 * the binary search tree and returns a reference to it. Throws a
	 * ElementNotFoundException if the specified target element is not found in
	 * the binary search tree.
	 * 
	 * @param targetElement
	 *            the element being sought in the binary search tree
	 * @throws ElementNotFoundException
	 *             if an element not found exception occurs
	 */
	public T removeElement(T targetElement) throws ElementNotFoundException {
		T result = null;

		if (!isEmpty()) {
			if (((Comparable) targetElement).equals(root.element)) {
				result = root.element;
				root = replacement(root);
				count--;
			} else {
				BinaryTreeNode<T> current, parent = root;
				boolean found = false;

				if (((Comparable) targetElement).compareTo(root.element) < 0)
					current = root.left;
				else
					current = root.right;

				while (current != null && !found) {
					if (targetElement.equals(current.element)) {
						found = true;
						count--;
						result = current.element;

						if (current == parent.left) {
							parent.left = replacement(current);
						} else {
							parent.right = replacement(current);
						}
					} else {
						parent = current;

						if (((Comparable) targetElement)
								.compareTo(current.element) < 0)
							current = current.left;
						else
							current = current.right;
					}
				} // while

				if (!found)
					throw new ElementNotFoundException("binary search tree");
			}
		} // end outer if

		return result;
	}

	public boolean contains(T targetElement) throws ElementNotFoundException {
		boolean found = false;

		if (!isEmpty()) {
			if (((Comparable) targetElement).equals(root.element)) {
				found = true;
			} else {
				BinaryTreeNode<T> current = root;

				if (((Comparable) targetElement).compareTo(root.element) < 0)
					current = root.left;
				else
					current = root.right;

				while (current != null && !found) {
					if (targetElement.equals(current.element)) {
						found = true;
					} else {
						if (((Comparable) targetElement)
								.compareTo(current.element) < 0)
							current = current.left;
						else
							current = current.right;
					}
				} // while
			}
		} // end outer if

		return found;
	}

	   public int depth(T element) {
		   int length = -1;
		   Comparable<T> comparableElement = (Comparable<T>) element;
		   if (comparableElement.compareTo(root.element) < 0) {
			   length = findDepth(root.left, element);
		   } else if (comparableElement.compareTo(root.element) > 0) {
			   length = findDepth(root.right, element);
		   } else
			   return 0;
		   return length;
	   }
	   
	   private int findDepth(BinaryTreeNode<T> subTree, T element) {
		   Comparable<T> comparableElement = (Comparable<T>) element;
		   if (comparableElement.compareTo(subTree.element) < 0) {
			   return 1 + findDepth(subTree.left, element);
		   } else if (comparableElement.compareTo(subTree.element) > 0) {
			   return 1 + findDepth(subTree.right, element);
		   } else
			   return 1;
	   }

	 /**
	 * Removes elements that match the specified target element from the binary
	 * search tree. Throws a ElementNotFoundException if the sepcified target
	 * element is not found in this tree.
	 * 
	 * @param targetElement
	 *            the element being sought in the binary \ search tree
	 * @throws ElementNotFoundException
	 *             if an element not found exception occurs
	 */
	public void removeAllOccurrences(T targetElement)
			throws ElementNotFoundException {
//		removeElement(targetElement);

//		try {
			while (contains( targetElement))
				removeElement(targetElement);
//		}

//		catch (Exception ElementNotFoundException) {
//		}
	}

	/**
	 * Removes the node with the least value from the binary search tree and
	 * returns a reference to its element. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 * 
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	public T removeMin() throws EmptyCollectionException {
		T result = null;

		if (isEmpty())
			throw new EmptyCollectionException("binary search tree");
		else {
			if (root.left == null) {
				result = root.element;
				root = root.right;
			} else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.left;
				while (current.left != null) {
					parent = current;
					current = current.left;
				}
				result = current.element;
				parent.left = current.right;
			}

			count--;
		}

		return result;
	}

	/**
	 * Removes the node with the highest value from the binary search tree and
	 * returns a reference to its element. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 * 
	 * @return a reference to the node with the highest value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	public T removeMax() throws EmptyCollectionException {
		T result = null;

		if (isEmpty())
			throw new EmptyCollectionException("binary search tree");
		else {
			if (root.right == null) {
				result = root.element;
				root = root.left;
			} else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.right;
				while (current.right != null) {
					parent = current;
					current = current.right;
				}

				result = current.element;
				parent.right = current.left;
			}

			count--;
		}

		return result;
	}

	/**
	 * Returns the element with the least value in the binary search tree. It
	 * does not remove the node from the binary search tree. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 * 
	 * @return the element with the least value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	public T findMin() throws EmptyCollectionException {
		T result = null;

		if (isEmpty())
			throw new EmptyCollectionException("binary search tree");
		else {
			BinaryTreeNode<T> current = root;

			while (current.left != null)
				current = current.left;

			result = current.element;
		}

		return result;
	}

	/**
	 * Returns the element with the highest value in the binary search tree. It
	 * does not remove the node from the binary search tree. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 * 
	 * @return the element with the highest value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	public T findMax() throws EmptyCollectionException {
		T result = null;

		if (isEmpty())
			throw new EmptyCollectionException("binary search tree");
		else {
			BinaryTreeNode<T> current = root;

			while (current.right != null)
				current = current.right;

			result = current.element;
		}

		return result;
	}

	/**
	 * Returns a reference to the specified target element if it is found in the
	 * binary tree. Throws a NoSuchElementException if the specified target
	 * element is not found in this tree.
	 * 
	 * @param targetElement
	 *            the element being sough in the binary tree
	 * @throws ElementNotFoundException
	 *             if an element not found exception occurs
	 */
	public T find(T targetElement) throws ElementNotFoundException {
		BinaryTreeNode<T> current = root;
//		BinaryTreeNode<T> temp = current;

		if (!(current.element.equals(targetElement))
				&& (current.left != null)
				&& (((Comparable) current.element).compareTo(targetElement) > 0))
			current = findAgain(targetElement, current.left);

		else if (!(current.element.equals(targetElement))
				&& (current.right != null))
			current = findAgain(targetElement, current.right);

		if (!(current.element.equals(targetElement)))
			throw new ElementNotFoundException("binary search tree");

		return current.element;
	}

	/**
	 * Returns a reference to the specified target element if it is found in
	 * this tree.
	 * 
	 * @param targetElement
	 *            the element being sought in the tree
	 * @param next
	 *            the tree node to being searching on
	 */
	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
//		BinaryTreeNode<T> current = next;

		if (!(next.element.equals(targetElement)) && (next.left != null)
				&& (((Comparable) next.element).compareTo(targetElement) > 0))
			next = findAgain(targetElement, next.left);

		else if (!(next.element.equals(targetElement)) && (next.right != null))
			next = findAgain(targetElement, next.right);

		return next;
	}

	/**
	 * Returns a reference to a node that will replace the one specified for
	 * removal. In the case where the removed node has
	 * 
	 * two children, the inorder successor is used as its replacement.
	 * 
	 * @param node
	 *            the node to be removeed
	 * @return a reference to the replacing node
	 */
	protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> result = null;

		if ((node.left == null) && (node.right == null))
			result = null;

		else if ((node.left != null) && (node.right == null))
			result = node.left;

		else if ((node.left == null) && (node.right != null))
			result = node.right;

		else {
			BinaryTreeNode<T> current = node.right;
			BinaryTreeNode<T> parent = node;

			while (current.left != null) {
				parent = current;
				current = current.left;
			}

			if (node.right == current)
				current.left = node.left;

			else {
				parent.left = current.right;
				current.right = node.right;
				current.left = node.left;
			}

			result = current;
		}

		return result;
	}
}
