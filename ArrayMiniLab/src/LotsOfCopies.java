//Tim Cheung, APCS Period 1
//November 1, 2017
//Description: Array Mini-Lab: This class explores the scope and semantics of variables, primitive values, strings, and arrays
import java.util.*;
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1,2,3,4,5};
		changeMe (num, strMain, arrMain);
		System.out.println("The main method does not keep track of the changes made to the int and string variables, "
				+ "but it does keep track of the changes made to the array");
		System.out.println("The mainmethod still thinks that \"num\" is: " + num);
		System.out.println("Main method still thinks that \"strMain\" is: " + strMain);
		System.out.println(Arrays.toString(arrMain));
		num = 900;
		int othernum = num;
		num = 89;
		strMain = "is a hard math class";
		String words = strMain;
		strMain = "*&#%";
		for (int i = 0; i< arrMain.length; i++) {
			arrMain [i] = 1 + 2*i;
		}
		int [] otherarr = arrMain;
		for (int i = arrMain.length - 1; i >= 0; i--) {
			arrMain[i]= i*10;
		}
		System.out.println("\nVariable \"num\" contains the new value: " + num);
		System.out.println("Variable \"othernum\" did not change to the new value, and still contains the old value: " + othernum);
		System.out.println("The string variable \"strMain\" holds the new value: \"" + strMain +"\"");
		System.out.println("The string variable \"words\" still holds the old value: \"" + words+"\"");
		System.out.println("Both Arrays with the same references to the same array will have the same value:\n" + Arrays.toString(arrMain));
		System.out.println(Arrays.toString(otherarr));
	}
	public static void changeMe (int x, String str, int[] arr) {
		x = x + 2;
		str = str + " first period";
		for (int i = 0; i < arr.length; i++) {
			arr [i]= arr[i] - 1;
		}
		System.out.println("These are the results of passing num, strMain, and arrMain through the method changeMe:");
		System.out.println(x);
		System.out.println(str);
		System.out.println(Arrays.toString(arr) + "\n");
		
	}

}
