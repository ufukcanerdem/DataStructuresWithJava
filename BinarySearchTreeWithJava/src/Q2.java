/**
 * Driver and main of HW7-Q2
 *
 * @author UfukcanErdem
 * @version 1.0.0
 * @since  15.05.2022
 */

/**
     *	The class is solution of Q2 in HW7.
     */
public class Q2 {

	/**
     *   Finds and returns right-side height of a node
     * @param temp
     * @return
     */
	static int RightHeightOfNode(BinarySearchTreeWithRotate.Node<Integer> temp) {
	     
	    if (temp == null) {
	        return -1;
	    }
	 
	    int rightHeight = RightHeightOfNode(temp.right);

	    int retval = rightHeight + 1;

	    return retval;
	}
	
	/**
     *   Finds and returns left-side height of a node
     * @param temp
     * @return
     */
	static int LeftHeightOfNode(BinarySearchTreeWithRotate.Node<Integer> temp) {

	    if (temp == null)
	    {
	        return -1;
	    }
	 
	    int leftHeight = LeftHeightOfNode(temp.right);

	    int retval = leftHeight + 1;

	    return retval;
	}
	
	/**
     *   Calculates and returns Balance-Factor of a node
     * @param temp
     * @return
     */
	static int BalanceFactorOfNode(BinarySearchTreeWithRotate.Node<Integer> temp) {
		int retval = RightHeightOfNode(temp)-LeftHeightOfNode(temp);
		
		return retval;
	}
	
	public static void main(String args[]){
		BinarySearchTreeWithRotate<Integer> BST1 = new BinarySearchTreeWithRotate<Integer>();
		
		BST1.root = new BinarySearchTreeWithRotate.Node(null);
		BST1.root.right = new BinarySearchTreeWithRotate.Node(null);
		BST1.root.left = new BinarySearchTreeWithRotate.Node(null);
		BST1.root.left.right = new BinarySearchTreeWithRotate.Node(null);
		BST1.root.left.right.right = new BinarySearchTreeWithRotate.Node(null);
		BST1.root.left.right.right.right = new BinarySearchTreeWithRotate.Node(null);
		BST1.root.left.left = new BinarySearchTreeWithRotate.Node(null);
		
		System.out.println("Balance of root->" + BalanceFactorOfNode(BST1.root));
		System.out.println("Balance of right->" + BalanceFactorOfNode(BST1.root.right));
		System.out.println("Balance of left->" + BalanceFactorOfNode(BST1.root.left.right.right));
		//BST1.root.left.left.left = new BinarySearchTreeWithRotate.Node(null);
		//BST1.root.left.left.right = new BinarySearchTreeWithRotate.Node(null);
		//BST1.root.left.left.right.left = new BinarySearchTreeWithRotate.Node(null);
		//BST1.root.right.left = new BinarySearchTreeWithRotate.Node(null);
		//BST1.root.right.right = new BinarySearchTreeWithRotate.Node(null);
		//BST1.root.right.left.right = new BinarySearchTreeWithRotate.Node(null);

		
		System.out.println("LEFTheight of root->" + LeftHeightOfNode(BST1.root));
		System.out.println("height of right->" + LeftHeightOfNode(BST1.root.right));
		System.out.println("height of left->" + LeftHeightOfNode(BST1.root.left));
		
		System.out.println("RIGHTheight of root->" + RightHeightOfNode(BST1.root));
		System.out.println("height of right->" + RightHeightOfNode(BST1.root.right));
		System.out.println("height of left->" + RightHeightOfNode(BST1.root.left));
		System.out.println("height of left->" + RightHeightOfNode(BST1.root.left.right));
		
		
		
		
	}
}
