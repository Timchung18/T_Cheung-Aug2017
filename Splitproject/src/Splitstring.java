import java.util.*;
public class Splitstring {

	public static void main(String[] args) {
		// Example: "I like apples!".split(" "); 
//			it will split at spaces and return an array of ["I","like","apples!"]
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		// Example 2: "I really like really red apples".split("really")
//			it will split at the word "really" and return an array of ["I "," like "," red apples!"]
		System.out.println(Arrays.toString("I really like really red apples!".split("really")));
		//play around with String.split! 
		//What happens if you "I reallyreally likeapples".split("really") ?
		System.out.println(Arrays.toString("I reallyreally like apples!".split("really")));
		//output: [I , , like apples!]
		System.out.println(Arrays.toString("applesapplesapples".split("apples")));
		//output: []
		System.out.println(Arrays.toString("I like apples".split("s")));
		//output:[I like apple]
		System.out.println(Arrays.toString("I like apples!".split("I")));
		//output:[,  like apples!]
		System.out.println(Arrays.toString("ii iIi ii i".split("i")));
		//output:[, ,  , , ,  , ,  ]
		System.out.println(Arrays.toString("I like apples!".split("k")));
		//[I li, e apples!]
		System.out.println(Arrays.toString("Hello, my name is Tim".split(",")));
		//[Hello,  my name is Tim]
		System.out.println(Arrays.toString("I like apples!".split("b")));
		//[I like apples!]
		String something = "I like apples!".split("I")[0];
		System.out.println(something);
		
		System.out.println(splitPart1("applespineapplesbreadlettucetomatobaconmayohambreadcheese"));
		System.out.println(splitPart1("applesbreadlettucetomatobaconmayohambreadcheese"));
		System.out.println(splitPart1("applespineapplesbreadlettucetomatobaconmayohambreadcheese"));
	}

		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettucetomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
	public static String splitPart1(String sandwitchstring) {
		sandwitchstring.split("bread");
		String answer = "";
		for (int i = 1; i < sandwitchstring.split("bread").length - 1; i++) {
			answer += sandwitchstring.split("bread")[i];
		}
		
		return answer;
	}


		//Your task Part 2:
		/*Write a method that take in a string like "apples pineapples bread lettuce tomato bacon mayo ham bread cheese" describing a sandwich
		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		* Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/

	

}
