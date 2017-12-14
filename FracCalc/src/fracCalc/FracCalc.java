//Tim Cheung, APCS Period 1
// 12/14/17
//Description: This class is a calculator for fractions, mixed numbers, and integers. It uses objects. This is the client code.
package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	boolean done = false;
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
    	}
    }
    
    public static String produceAnswer(String input) {
    	if (input.contains("/0")) {
    		return "ERROR: cannot divide by zero";
    	}
    	String [] inputarray = input.split(" ");
    	Fraction operand1 = new Fraction(inputarray[0]);
    	Fraction operand2 = new Fraction(inputarray[2]);
    	operand1.toImproperFrac();
    	operand2.toImproperFrac();
    	String operator = inputarray[1];
    	String result = calculate(operator,operand1, operand2);
    
    	return result;
    	//Fraction thesecondoperand = new Fraction(inputarray[2]);
    	//return thesecondoperand.check2String();
 
    	//String result = calculate(operators[0], operands[0], operands[1], operand1, operand2);
    	//for(int i =1; i<operators.length; i++) {
    	//	result = calculate(operators[i], result, operands[i+1]);
    	//}
    	
    	//return "";
    }
    public static String calculate(String operator, Fraction fraction1, Fraction fraction2){ 
    	
    	if (operator.equals("+")||operator.equals("-")) {
    		fraction1.addOrsubtract(fraction2.getNumerator(), fraction2.getDenominator(), operator);
    		//addOrsubtract(operand1,operand2,answer,operator);
    	}else {
    		fraction1.multiplyOrdivide(fraction2.getNumerator(), fraction2.getDenominator(), operator);
    		//multiplyOrdivide(operand1,operand2, answer, operator);
    	}
    	return fraction1.toString();
    	
    }
    
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
    
    public static int[] toImproperFrac(int[] mixednum) {
    	int multiplier = 1;
    	if (mixednum[0]<0) {
    		multiplier = -1;
    	}
		int top = ((absValue(mixednum[0]) * mixednum[2]) + mixednum[1]);
		top *= multiplier;
		int [] impropfrac = {top, mixednum[2]};
		return impropfrac;
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
    
    public static void commonDenom(int operand1[], int operand2[]) {
    	operand1[0] = operand2[1] * operand1[0];
    	operand2[0] = operand1[1] * operand2[0];
    	operand1[1] = operand1[1] * operand2[1];
    	operand2[1] = operand1[1]; 
    }
    
    public static void addOrsubtract(int[]operand1, int[]operand2, int[]answer, String operator) {
    	commonDenom(operand1,operand2);
    	if (operator.equals("-")) {
    		operand2[0] = operand2[0] * (-1);
    	}
    	answer[0] = operand1[0] + operand2[0];
    	answer[1] = operand1[1];    
    }
    
    public static void multiplyOrdivide(int[]operand1, int[]operand2, int[] answer, String operator) {
    	if (operator.equals("/")) {
    		int save = operand2[0];
    		if (operand2[0]<0) {
    			save*= (-1);
    			operand2[1] *= (-1);
    		}
    		operand2[0]= operand2[1];
    		operand2[1]= save;
    	}
    	answer[0]= operand1[0] * operand2[0];
    	answer[1]= operand1[1] * operand2[1];
    }
    
    public static int absValue (int numerator) { 
		if (numerator < 0) {
			numerator = numerator * -1; 
		}
		return numerator;
	}
    
    public static String simplifyAndToString(int[] answer) {
    	if (answer[0]>0) {
    		return "" + answer[0]/answer[1];
    	}else if(absValue(answer[0]) > answer[1]) {
    		return toMixedNum(answer);
    	}else if (absValue(answer[0]) < answer[1]) {
    		int tempvalue = answer[0];
    		reduce(answer);
    		if(tempvalue < 0) {
    			answer[0] *= -1;
    		}
    		return  answer[0] + "/" + answer[1];
    	}
    	return "";
    }
    //this method returns the greatest common factor between the numerator and the denominator
    public static int findGCF(int numerator, int denominator) {
		if (isPrime(denominator)==true) {
			return 1;
		}
		while (numerator > 0) {
			int modula = denominator % numerator;
			denominator = numerator;
			numerator = modula;
		}
		return denominator;
	}
	
	public static boolean isPrime(int operand) {
		boolean test = false;
		int denominator = operand - 1;
		while (test == false) {
			test = ((operand%denominator)==0);
			denominator --;
			if (denominator == 0) {
			return true;
		}
		}
		return false;
	}
	
	public static void reduce(int[]fraction) {
		fraction[0] = absValue(fraction[0]);
		int gcf = findGCF(fraction[0], fraction[1]);
		fraction[0] = fraction[0] / gcf;
		fraction[1] = fraction[1] / gcf;
	}
	
	public static String toMixedNum (int[] improperfrac) {
		int newnumerator = improperfrac[0] % improperfrac[1];
		int wholenumber = improperfrac[0] / improperfrac[1];
		improperfrac[0]= newnumerator;
		reduce(improperfrac);
		return ""+ wholenumber + "_" + improperfrac[0] + "/" + improperfrac[1];
	}
	
}
