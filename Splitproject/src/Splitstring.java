import java.util.*;
public class Splitstring {

	public static void main(String[] args) {
		/*// Example: "I like apples!".split(" "); 
//			it will split at spaces and return an array of ["I","like","apples!"]
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		// Example 2: "I really like really red apples".split("really")
//			it will split at the word "really" and return an array of ["I "," like "," red apples!"]
		System.out.println(Arrays.toString("I really like really red apples!".split("really")));
		//play around with String.split! 
		//What happens if you "I reallyreally likeapples".split("really") ?
		System.out.println(Arrays.toString("Ireallyreallylikeapples!".split("really")));
		//output: [I , , like apples!]
		System.out.println(Arrays.toString("applesapplesapples".split("apples")));
		//output: []
		System.out.println(Arrays.toString("I like apples".split("s")));
		//output:[I like apple]
		System.out.println(Arrays.toString("I like apples!".split("I")));
		//output:[,  like apples!]
		System.out.println(Arrays.toString("I like apples!".split("k")));
		//[I li, e apples!]
		System.out.println(Arrays.toString("Hello, my name is Tim".split(",")));
		//[Hello,  my name is Tim]
		System.out.println(Arrays.toString("I like apples!".split("b")));
		//[I like apples!]
		String something = "I like apples!".split("I")[0];
		System.out.println(something);
		*/
		System.out.println(Arrays.toString("applespineapplesbreadlettucetomatobaconmayohambreadcheese".split("bread")));
		System.out.println(Arrays.toString("breadlettucetomatobaconmayohambreadcheese".split("bread")));
		System.out.println(Arrays.toString("applespineapplesbreadlettucetomatobaconmayohamcheesebread".split("bread")));
		System.out.println(Arrays.toString("breadlettucetomatobaconmayohambread".split("bread")));
		System.out.println(Arrays.toString("breadlettucetomatobreadbaconmayohambread".split("bread")));

		System.out.println(Arrays.toString("apples pineapples bread lettuce tomato bacon mayo ham bread cheese".split("bread")));
		System.out.println(Arrays.toString("apples pineapples bread lettuce tomato bread bacon mayo ham bread cheese".split(" ")));
		System.out.println("applespineapplesbreadlettucetomatobaconmayohambreadcheese".split("bread")[0]);
		
		System.out.println();
		System.out.println(splitPart1("applesbreadlettucemayohambreadcheese")); 
		//stuff1, bread, stuff2, bread, stuff3 = stuff2 lettucemayoham
		System.out.println(splitPart1("applesbreadpineapplesbreadmayohambreadcheese"));
		//stuff1, bread, stuff2, bread,stuff3, bread, stuff4 = stuff2, stuff3
		System.out.println(splitPart1("breadlettucetomatobaconmayohambread"));
		//bread, stuff1, bread = stuff1
		System.out.println(splitPart1("breadlettucebreadhambread"));
		//bred, stuff1, bread, stuff2, bread = stuff1, stuff2
		System.out.println(splitPart1("breadlettucebreadhambreadjambread"));
		
		//System.out.println(splitPart1(""));
		//System.out.println("no");
		//System.out.println(splitPart1("apples pineapples bread lettuce tomato bacon mayo ham bread cheese"));
		System.out.println();
		
		System.out.println(splitPart2("apples bread pineapples bread lettuce tomato bacon mayo ham bread cheese"));
		System.out.println(splitPart2("apples pineapples bread lettuce tomato bacon mayo ham bread cheese"));
		System.out.println(splitPart2("bread pineapples bread lettuce ham bread"));
		
	}

		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettucetomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
	public static String splitPart1(String sandwitchstring) {
		if (!sandwitchstring.contains("bread")) {
			return "this is not a sandwitch";
		}
		sandwitchstring.split("bread");
		String answer = "";
		int length = sandwitchstring.split("bread").length - 1;
		if (sandwitchstring.endsWith("bread")) {
			length = sandwitchstring.split("bread").length;
		}
		for (int i = 1; i < length; i++) {
			answer += sandwitchstring.split("bread")[i];
		}
		
		return answer;
	}
			//Your task Part 2:
		/*Write a method that take in a string like "apples pineapples bread lettuce tomato bacon mayo ham bread cheese" describing a sandwich
		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		* Again, what if it's a fancy sandwich with multiple pieces of bread?
		* if it takes in the string: "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"
		* it will return the string: lettucetomatobaconmayoham 
		*/
	public static String splitPart2(String sandwitchstring) {
		String sandwitchwithspaces = splitPart1(sandwitchstring);
		sandwitchwithspaces.split(" ");
		String answer = "";
		for (int i = 1; i < sandwitchwithspaces.split(" ").length; i++) {
			answer += sandwitchwithspaces.split(" ")[i];
		}
		return answer;
	}
	

}
