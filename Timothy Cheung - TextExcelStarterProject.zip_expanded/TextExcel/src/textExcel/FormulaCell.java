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
		String answer = "answer";
		answer += super.spaces(answer.length());
		return answer;
	}
	// ( 6 + 3 - 8 * 8 / 2 )
	public void parseInput() {
		String userInput = super.getUserInput();
		userInput = userInput.substring(1, userInput.length() - 1);
		String [] inputArr = userInput.split(" ");
		//6,+,3,-,8
		//0,1,2,3,4
		ArrayList<Double> operands = makeIntoNum(inputArr);
		ArrayList<String> operators = new ArrayList<String>();
		for(int i = 1; i < inputArr.length; i += 2) {
			operators.add(inputArr[i]);
		}
		
	}
	public ArrayList<Double> makeIntoNum(String[] inputArr) { 
		//makes string numbers into doubles and puts them in an Array list
		ArrayList<Double> operands = new ArrayList<Double>();
		for(int i = 0; i < inputArr.length;i+=2) {
			operands.add(getDoubleValue(inputArr[i]));
		}
		return operands;
	}
	public double getDoubleValue(String number) {
		//returns the value of the cell as a double (changes string into double)
		double value = Double.parseDouble(number);
		return value;
	}
	public void doMath(ArrayList<String> operators, ArrayList<Double> operands) {
		for(String currOptr : operators) {
			if(currOptr.equals("+")) {
				
			}else if(currOptr.equals("-")) {
				
			}else if(currOptr.equals("*")) {
				
			}else if(currOptr.equals("/")) {
				
			}
		}
		
		
	}

}
