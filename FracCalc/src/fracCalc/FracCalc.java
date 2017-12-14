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
	
}
