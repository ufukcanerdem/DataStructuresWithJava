/**
 * Driver and main of HW4-Q2
 *
 * @author UfukcanErdem
 * @version 1.0.0
 * @since  01.04.2022
 */


/**
     *	The class is solution of q2 in HW4.
     */
public class q2 {
	
	/**
     *   Finds the number of items between two integer in an array.
     * @param numbers
     * @param small
     * @param big
     * @param first
     * @param last
     * @param place1
     * @param place2
     * @return
     */
	public static int numOfItems( int[] numbers, int small, int big, int first, int last, int place1, int place2) {
		int middle = (first+last)/2;
		
		if( first > last || (last-first < 2) || (small > big) || numbers == null) {
			return -1;
		}
		
		if(small == numbers[middle] && place1 == -99) {
			place1=middle;
			first=0;
			last=numbers.length;
		}
		
		if(big == numbers[middle] && place2 == -99) {
			place2=middle;
		}
		
		
		if(small < numbers[middle] && place1 == -99) {
			return numOfItems(numbers,small,big,first,middle,place1,place2);
		}
		
		else if( small > numbers[middle] && place1 == -99) {
			return numOfItems(numbers,small,big,middle,last,place1,place2);
		}
		
		else if( big < numbers[middle] && place2 == -99) {
			return numOfItems(numbers,small,big,first,middle,place1,place2);
		}
		
		else if( big > numbers[middle] && place2 == -99) {
			return numOfItems(numbers,small,big,middle,last,place1,place2);
		}
		
		
		if( place1 != -99 && place2 != -99) {
			return (place2-place1-1);
		}
		else {
			return -1;
		}
	}
	
	/**  
     * @param args
     */
	public static void main(String args[]){
		int[] sortedArr = {1,3,7,11,13,14,17,19,22,23,24,27,45,48,88,93,111};
		
		int smallItem=7;
		int bigItem=88;
		
		System.out.println("Number of Items between "+ smallItem + " and " + bigItem + " is -> " + numOfItems(sortedArr,smallItem,bigItem,0,(sortedArr.length-1),-99,-99));
	}
}
