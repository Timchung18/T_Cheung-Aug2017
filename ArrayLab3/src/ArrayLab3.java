//Tim Cheung
//APCS Period 1
//11/6/17
//Assignment: Array Lab 3. This class practices manipulating arrays
import java.util.*;
public class ArrayLab3 {
	
	public static void main(String[] args) {
		int [] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int [] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int [] sumArr = sum(a1,a2);
		int appendNum = 200;
		int [] appendArr = append(a1,appendNum);
		int removeIdx = 5;
		int [] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));

	}
	
	/*This method returns an array of integers, in which every 
	 * element is the sum of the elements at that index for the arrays arr1 and arr2. 
	 * 
 	pseudocode: make an array to return later
	the array is same length as arr1 and arr2
	fill the array by adding corresponding elements and put in array
	use for loop to traverse 
	return the array*/
	public static int[] sum(int[] arr1, int[] arr2) {
		int [] sumarray = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			sumarray [i]= arr1[i] + arr2[i];
		}
		return sumarray;
	}

	/*This method returns an array of integers that is a longer by one element and consists 
	 * of the elements of arr with the num appended to the end.
	pseudocode: make a new array, with length of arr plus 1
	use for loop to copy arr into new array (newarray [i] = arr [i])
	stop at second to last index (don’t fill in the last one)
	put num in the last index
	return the newarray
	*/
	public static int[] append(int[] arr, int num) {
		int[] newarray = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newarray[i]= arr[i];
		}
		newarray [arr.length]= num;
		return newarray;
	}
	
	/* This method removes an element from an array at a specific index and returns the array
	 * without that element but with everything else there and one less index
	pseudocode: create new array with length of one less than arr
	use for loop and put contents of the array before the element at idx into the corresponding index (stopping at the index before the one at idx)
	use for loop: start at the index of idx and put the element in the array after it into the index of idx(shift everything after idx to the left)

	return the newarray
	*/
	public static int[] remove(int[] arr, int idx) {
		int[] shorterarr = new int[arr.length-1];
		for (int i = 0; i < idx; i++) {
			shorterarr [i]= arr[i];
		}
		for (int i = idx; i < shorterarr.length; i++) {
			shorterarr[i]= arr[i+1];
		}
		return shorterarr;
	}
	
	/*This method returns an integer containing the sum of the elements at the even indices of arr.
	pseudocode: make variable for sum
	use for loop: start at index 0, stop at last index, increment by two each time 
	each time, add the element at the index to the sum
	return the sum*/
	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i+=2) {
			sum += arr[i];
		}
		return sum;
	}
	
	/* This method changes the array by moving all of the elements one index to the right and 
	 * the last element will go to the front
	pseudocode: store the last element in a variable
	use for loop: start at the last index, stop at 1, go backwards (decrement i by one)
		put the element before at index i-1 and put it in index i
	put last element in index 0*/
	public static void rotateRight(int[] arr) {
		int lastnum = arr[arr.length-1];
		for (int i = arr.length-1;i>0; i--) {
			arr[i]= arr [i-1];			
		}
		arr[0]=lastnum;
	}


}
