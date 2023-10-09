/**
 * Driver and main of HW7-Q1
 *
 * @author UfukcanErdem
 * @version 1.0.0
 * @since  15.05.2022
 */

import java.util.Arrays;

/**
     *	The class is solution of Q1 in HW7.
     */
public class Q1 {
	
	static int count;
	
	/**
     *   Converts empty BinaryTree to BST based on array elements
     * @param BT
     * @param arr
     * @return
     */
	public static BinaryTree<Integer> BTtoBST (BinaryTree<Integer> BT, int [] arr) {
		Arrays.sort(arr);
		fillBinarySearchTree(BT.root, arr);
		return BT;	
	}
	
	/**
     *   Takes the sorted Array and fills the nodes of BinaryTree as BST.
     * @param temp
     * @param arr
     */
	static void fillBinarySearchTree (BinaryTree.Node<Integer> temp, int[] arr)
    {
        if (temp == null){
            return;
        }
        fillBinarySearchTree(temp.left, arr);
 
        temp.data = arr[count];
        count++;
        
        fillBinarySearchTree(temp.right, arr);
    }
	
	/**  
     * @param args
     */
	public static void main(String args[]){
		
		//Driver Function of Q1-HW7
		
		System.out.println("-----TEST1-----");
		
		int [] arr = {14,4,5,9,11,7,16};
		BinaryTree<Integer> test = new BinaryTree<Integer>();

		//CREATING STRUCTURE OF EMPTY BINARY TREE
		test.root = new BinaryTree.Node<Integer>(null);
		
		test.root.left = new BinaryTree.Node<>(null);
		test.root.right = new BinaryTree.Node<Integer>(null);
		
		test.root.right.right = new BinaryTree.Node<Integer>(null);
		test.root.right.left = new BinaryTree.Node<Integer>(null);
		
		test.root.left.right = new BinaryTree.Node<Integer>(null);
		test.root.left.right.left = new BinaryTree.Node<Integer>(null);
		
		count=0;
		BTtoBST(test,arr);
		
		System.out.println("Root->"+ test.root.data);
		
		System.out.println("Root-left->" + test.root.left.data);
		System.out.println("Root-left-right->" + test.root.left.right.data);
		System.out.println("Root-left-right-left->" + test.root.left.right.left.data);
		
		System.out.println("Root-right->" + test.root.right.data);
		System.out.println("Root-right-right->" + test.root.right.right.data);
		System.out.println("Root-right-left->" + test.root.right.left.data);

	
		//test = BTtoBST(test, arr);
		
		System.out.println("-----TEST2-----");
		
		int [] arr2 = {13,11,87,2,99,113,25,186,4,12};
		BinaryTree<Integer> test2 = new BinaryTree<Integer>();
		
		//CREATING STRUCTURE OF EMPTY BINARY TREE
		test2.root = new BinaryTree.Node<Integer>(null);
		
		test2.root.right = new BinaryTree.Node<Integer>(null);
		test2.root.right.right = new BinaryTree.Node<Integer>(null);
		test2.root.right.right.right = new BinaryTree.Node<Integer>(null);
		test2.root.right.right.right.right = new BinaryTree.Node<Integer>(null);
		test2.root.right.right.right.left = new BinaryTree.Node<Integer>(null);
		test2.root.right.left = new BinaryTree.Node<Integer>(null);
		test2.root.right.left.left = new BinaryTree.Node<Integer>(null);
		test2.root.right.left.left.right = new BinaryTree.Node<Integer>(null);
		
		test2.root.left = new BinaryTree.Node<Integer>(null);
		
		count=0;
		BTtoBST(test2,arr2);
		
		System.out.println("Root->"+ test2.root.data);
		
		System.out.println("Root-right->"+ test2.root.right.data);
		System.out.println("Root-right-right->"+ test2.root.right.right.data);
		System.out.println("Root-right-right-right->"+ test2.root.right.right.right.data);
		System.out.println("Root-right-right-right-right->"+ test2.root.right.right.right.right.data);
		System.out.println("Root-right-right-right-left->"+ test2.root.right.right.right.left.data);
		System.out.println("Root-right-left->"+ test2.root.right.left.data);
		System.out.println("Root-right-left-left->"+ test2.root.right.left.left.data);
		System.out.println("Root-right-left-left-right->"+ test2.root.right.left.left.right.data);
		
		System.out.println("Root-left->"+ test2.root.left.data);
		
	}
}
