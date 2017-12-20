//Tim Cheung, APCS Period 1
// 12/19/17
//Description: This class is a calculator for fractions, mixed numbers, and integers. It uses objects. This is the client code.
package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	boolean done = false;
    	while (done==false) {
    	System.out.println("Enter the two or more operands that you want to add, subtract, multiply, or divide and the operators:");
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
    	String [] operands = new String[(inputarray.length +1) /2];
    	for (int i=0; i < operands.length; i++) {
    		operands[i] = inputarray[i*2];
    	}
    	String [] operators = new String[inputarray.length/2];
    	for (int i = 0; i<operators.length; i++) {
    		operators[i] = inputarray[i*2 + 1];
    		if(operators[i].length() > 1){
    			return "ERROR: cannot do that";
    		}
    	}
    	Fraction operand1 = new Fraction(operands[0]);
    	Fraction operand2 = new Fraction(operands[1]);
    	calculate(operators[0],operand1, operand2);
    	Fraction answer = new Fraction(operand1.getWholeNum(), operand1.getNumerator(), operand1.getDenominator());
    	for (int i = 1; i<operators.length; i++) {
    		operand2.createNewFraction(operands[i+1]);
    		calculate(operators[i], answer, operand2);
    		answer.createNewFraction(answer.getWholeNum(), answer.getNumerator(), answer.getDenominator());
    	}
    	return answer.toString();
    }
    
    public static void calculate(String operator, Fraction fraction1, Fraction fraction2){ 
    	if (operator.equals("+")||operator.equals("-")) {
    		fraction1.addOrsubtract(fraction2.getNumerator(), fraction2.getDenominator(), operator);
    	}else {
    		fraction1.multiplyOrdivide(fraction2.getNumerator(), fraction2.getDenominator(), operator);
    	}
   }
	
}
