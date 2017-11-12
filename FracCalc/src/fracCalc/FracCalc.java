package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	boolean done = false;
    	while (done==false) {
    	System.out.println("Enter the two operands that you want to add, subtract, multiply, or divide");
    	@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
    	String inputstr = userinput.nextLine();
    	System.out.println(produceAnswer(inputstr));
    	System.out.println("Type \"quit\" to stop or yes to keep going.");
    	String keepgoin = userinput.next();
    	if (keepgoin.equals("quit")) {
    		done = true;
    	}
    	}
    	
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
    	
    	String [] fraction1 = firstoperand.split("_");
    	String num1 = fraction1[0];
    	String fracofmxnum1 = "";
    	String fomnnumt1 = "";
    	String fomndeno1 = "";
    	int numerator1 = 0;
    	int denominator1 = 0;
    	if(fraction1.length==2) {
    		 fracofmxnum1 = fraction1[1];
    		 fracofmxnum1.split("/");
    		 fomnnumt1 = fracofmxnum1.split("/")[0];
    		 fomndeno1 = fracofmxnum1.split("/")[1];
    		 numerator1 = toNumber(fomnnumt1);
     		 denominator1 = toNumber(fomndeno1);    		
    	}else if (num1.contains("/")){//check to see if the first number is a fraction or a whole number?
    		fomnnumt1 = num1.split("/")[0];
    		fomndeno1 = num1.split("/")[1];
    		denominator1 = toNumber(fomndeno1);
    		numerator1 = toNumber(fomnnumt1);
    		
    	}
    	
    	String [] fraction2 = secondoperand.split("_");
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
}
