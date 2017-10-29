import java.util.*;
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1,2,3,4,5};
		changeMe (num, strMain, arrMain);
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
	}
	public static void changeMe (int x, String str, int[] arr) {
		/*x = x + 2;
		str = str + " first period";
		for (int i = 0; i < arr.length; i++) {
			arr [i]= arr[i] - 1;
		}
		System.out.println(x);
		System.out.println(str);*/
		x = 900;
		int b = x;
		x = 89;
		str = "is a hard math class";
		String words = str;
		str = "*&#%";
		for (int i = 0; i< arr.length; i++) {
			arr [i] = 1 + 2*i;
		}
		int [] arr2 = arr;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i]= i*10;
		}
		System.out.println(x);
		System.out.println(b);
		System.out.println(str);
		System.out.println(words);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(x + str);
	}

}
