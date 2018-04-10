package textExcel;
import java.util.*;
public class FormulaCell extends RealCell{
	public FormulaCell(String userInput) {
		super(userInput);
	}
	//for cell inspection/fullCellText, make sure to include the parenthesis 
	//when it prints to console
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		String answer = parseInput() + "";
		answer += super.spaces(answer.length());
		if(answer.length() > 10) {
			answer = answer.substring(0,10);
		}
		return answer;
	}
	// ( 6 + 3 - 8 * 8 / 2 )
	public double parseInput() {
		String userInput = super.getUserInput();
		userInput = userInput.substring(1, userInput.length() - 1);
		String [] inputArr = userInput.split(" ");
		//6,+,3,-,8
		//0,1,2,3,4
		ArrayList<Double> operands = makeIntoNum(inputArr);
		ArrayList<String> operators = new ArrayList<String>();
		for(int i = 2; i < inputArr.length; i += 2) {
			operators.add(inputArr[i]);
		}
		for(String currOptr : operators) {
			operands.set(0, calculate(currOptr, operands.get(0), operands.get(1)));
			operands.remove(1);
		}
		return operands.get(0);
	}
	
	public ArrayList<Double> makeIntoNum(String[] inputArr) { 
		//makes string numbers into doubles and puts them in an Array list
		ArrayList<Double> operands = new ArrayList<Double>();
		for(int i = 1; i < inputArr.length;i+=2) {//A=65, Z=90, a = 97, z = 122,
			String str = inputArr[i].toLowerCase();
			if((str.charAt(0)>=97)&&(str.charAt(0)<=122)) {
				
			}
			operands.add(getDoubleValue(inputArr[i]));
		}
		return operands;
	}
	
	public double getDoubleValue(String number) {
		//returns the value of the cell as a double (changes string into double)
		double value = Double.parseDouble(number);
		return value;
	}
	
	public double calculate(String operator, Double operand1, Double operand2) {
		double answer = 0;
		if(operator.equals("+")) {
			answer = operand1 + operand2;
		}else if(operator.equals("-")) {
			answer = operand1 - operand2;
		}else if(operator.equals("*")) {
			answer = operand1 * operand2;
		}else  { //(operator.equals("/"))
			answer = operand1 / operand2;
		}
		return answer;
	}
	
	public void sum() {
		
	}

}
