package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
    	/*boolean done = false;
    	while (done==false) {
    	System.out.println("Enter the two operands that you want to add, subtract, multiply, or divide");
    	@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
    	String inputstr = userinput.nextLine();
    	System.out.println(produceAnswer(inputstr));
    	System.out.println("Type \"quit\" to stop or \"yes\" to keep going.");
    	String keepgoin = userinput.next();
    	if (keepgoin.equals("quit")) {
    		done = true;
    	}
    	}*/
    	Scanner userinput = new Scanner(System.in);
    	String inputstr = userinput.nextLine();
    	System.out.println(produceAnswer(inputstr));
    	
    	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        
    	// TODO: Implement this function to produce the solution to the input
    	String [] inputarray = input.split(" ");
    	String firstoperand = inputarray[0];
    	String operator = inputarray[1];
    	String secondoperand = inputarray[2];
    	String [] split1 = splitOperand(firstoperand);//[whole num, numerator, denominator] strings
    	String [] split2 = splitOperand(secondoperand); // negative cases: -3_1/3, -4, -3/5 numerator or whole number is always negative
    	int [] operand1 = new int[3];
    	for (int i = 0; i< split1.length; i++) {
    		operand1[i]= toNumber(split1[i]);
    	}
    	int []operand2 = new int[3];
    	for (int i = 0; i < split2.length; i++) {
    		operand2[i] = toNumber(split2[i]);
    	}//possible cases: [-3, 1, 3]; [-4, 0, 1]; [0, -3, 5]
    	
    	
    	
    	String checktwo = "whole:" + split2[0] + " numerator:" + split2[1] + " denominator:" + split2[2];
    	return checktwo;
    	
    	
    	/*String [] fraction2 = secondoperand.split("_");
    	String num2 = fraction2[0];
    	String fracofmxnum2 = "";
    	String fomnnumt2 = "";
    	String fomndeno2 = "";
    	int denominator2 = 0;
    	int numerator2 = 0;
    	if (fraction2.length == 2) {
    		fracofmxnum2 = fraction2[1];
    		fracofmxnum2.split("/");
    		fomnnumt2 = fracofmxnum2.split("/")[0];
    		fomndeno2 = fracofmxnum2.split("/")[1];
    		numerator2 = toNumber(fomnnumt2);
    		denominator2 = toNumber(fomndeno2);
    	}else if (num2.contains("/")){//check to see if the first number is a fraction or a whole number?
    		fomnnumt2 = num2.split("/")[0];
    		fomndeno2 = num2.split("/")[1];
    		denominator2 = toNumber(fomndeno2);
    		numerator2 = toNumber(fomnnumt2);	
    	}
    	int number1 = 0;
    	if (!num1.contains("/")){
    		number1 = toNumber(num1);
    	}
    	int number2 = 0;
    	if (!num2.contains("/")) {
    	number2 = toNumber(num2);
    	}
    	String thing = "";
    	
    	if (firstoperand.contains("_")) {
    	thing = toImproperFrac(number1,numerator1,denominator1);
    	thing.split("/");
    	numerator1 = toNumber(thing.split("/")[0]);
    	denominator1 = toNumber(thing.split("/")[1]);
    	}
    	
    	number2 = number2 + number1;
    	return "";
    	*/
       	
    	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    /*
     *
	}
	public static String toMixedNum (int numerator, int denominator) {
		int newnumerator = numerator%denominator;
		int wholenumber = (numerator - newnumerator) / denominator;
		return (wholenumber + "_" + newnumerator +  "/" + denominator);
	}
     */
    public static int toNumber(String numberstr) {
    	int negsign = 1;
    	if (numberstr.contains("-")) {
    		numberstr = numberstr.substring(1);
    		negsign = -1;
    	}
    	int i = 0;
    	while (i >= 0) {
    		String j = "" + i;
    		if (numberstr.equals(j)) {
    			return i* negsign;
    		}
    		i ++;
    	}
    	return 0;
    }
    public static String toImproperFrac(int wholenumber, int numerator, int denominator) {
    	int multiplier = 1;
    	if (wholenumber<0) {
    		wholenumber*= -1;
    		multiplier = -1;
    	}
		int top;
		top = multiplier * ((wholenumber*denominator) + numerator);
		
		return (top + "/" + denominator);
		}
    public static String[] splitOperand(String operand) {
    	String wholenum = "0";
    	String numerator = "0";
    	String denominator = "1";
    	String [] fraction = operand.split("_");
    	wholenum = fraction[0];
    	String fracofmxnum = "";
    	if(fraction.length==2) {
    		 fracofmxnum = fraction[1];
    		 fracofmxnum.split("/");
    		 numerator = fracofmxnum.split("/")[0];
    		 denominator = fracofmxnum.split("/")[1];   		
    	}else if (wholenum.contains("/")){//check to see if the first number is a fraction or a whole number?
    		numerator = wholenum.split("/")[0];
    		denominator = wholenum.split("/")[1];
    		wholenum = "0";
    	}
    	String [] splitted = new String[3];
    	splitted [0]= wholenum;
    	splitted [1]= numerator;
    	splitted [2]= denominator;
    	return splitted;
    }
    public static void commonDenom(int arr1[], int arr2[]) {
    	arr1[0] = arr2[1] * arr1[0];
    	arr2[0] = arr1[1]*arr2[0];
    	int denom = arr1[1];
    	arr1[1] = arr1[1]*arr2[1];
    	arr2[1] = denom * arr2[1]; //Should I return a new array?
    }
    
}
