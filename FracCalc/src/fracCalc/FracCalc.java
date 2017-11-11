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
    	if(fraction1.length==2) {
    		 fracofmxnum1 = fraction1[1];
    		 fracofmxnum1.split("/");
    		 fomnnumt1 = fracofmxnum1.split("/")[0];
    		 fomndeno1 = fracofmxnum1.split("/")[1];
    	}else if (num1.contains("/")){//check to see if the first number is a fraction or a whole number?
    		fomnnumt1 = num1.split("/")[0];
    		fomndeno1 = num1.split("/")[1];
    	}
    	
    	String [] fraction2 = secondoperand.split("_");
    	String num2 = fraction2[0];
    	String fracofmxnum2 = "";
    	String fomnnumt2 = "";
    	String fomndeno2 = "";
    	if (fraction2.length == 2) {
    		fracofmxnum2 = fraction2[1];
    		fracofmxnum2.split("/");
    		fomnnumt2 = fracofmxnum2.split("/")[0];
    		fomndeno2 = fracofmxnum2.split("/")[1];
    	}else if (num2.contains("/")){//check to see if the first number is a fraction or a whole number?
    		fomnnumt2 = num2.split("/")[0];
    		fomndeno2 = num2.split("/")[1];
    	}
    	return "";
    	
    	
    	
    	
    	
    	
    	/*
        String [] strinputarr = new String [input.length()];
        for(int i = 0; i < strinputarr.length; i ++) {
        	strinputarr[i]= ""+ input.charAt(i);
        }
        
        
       // String firstoperand = input.substring(0, space); 
        int[] firstnumarr = new int [firstoperand.length()];
        
        return "";*/
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    /*
     * public static String toImproperFrac(int wholenumber, int numerator, int denominator) {
		int top;
		top = ((wholenumber*denominator) + numerator);
		return (top + "/" + denominator);
	}
	public static String toMixedNum (int numerator, int denominator) {
		int newnumerator = numerator%denominator;
		int wholenumber = (numerator - newnumerator) / denominator;
		return (wholenumber + "_" + newnumerator +  "/" + denominator);
	}
     */
    public static int toNumber(String numberstr) {
    	int i = 0;
    	while (i >= 0) {
    		String j = "" + i;
    		if (numberstr.equals(j)) {
    			return i;
    		}
    		i ++;
    	}
    	return 0;
    }
}
