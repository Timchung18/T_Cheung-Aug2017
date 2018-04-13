/*Tim Cheung
 * AP CS, Pd. 1
 * 4/13/18 */
package textExcel;
import java.util.*;
public class FormulaCell extends RealCell{
	private Cell [][] sheet;
	public FormulaCell(String userInput, Cell[][] sheet) {
		super(userInput);
		this.sheet = sheet;
	}
	//for cell inspection/fullCellText, make sure to include the parenthesis 
	//when it prints to console
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		String answer = getDoubleValue() + "";
		answer += super.spaces(answer.length());
		if(answer.length() > 10) {
			answer = answer.substring(0,10);
		}
		return answer;
	}
	public double getDoubleValue() { //calculates the formula with the given numbers or cell assignment, or calculates sum or avg of a cell range
		String userInput = super.getUserInput();
		userInput = userInput.substring(1, userInput.length() - 1);//gets rid of the parenthesis
		String [] inputArr = userInput.split(" ");//gets rid of the spaces 
		userInput = userInput.toLowerCase();
		if (userInput.contains("sum")) {
			return (sum(inputArr[2]));
		}else if(userInput.contains("avg")) {
			return (avg(inputArr[2]));
		}else {
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
	}
	
	public ArrayList<Double> makeIntoNum(String[] inputArr) { 
		//makes string numbers into doubles and puts them in an Array list
		ArrayList<Double> operands = new ArrayList<Double>();
		for(int i = 1; i < inputArr.length;i+=2) {
			String str = inputArr[i].toLowerCase();
			if((str.charAt(0)>=97)&&(str.charAt(0)<=122)) {
				SpreadsheetLocation loc = new SpreadsheetLocation(str);
				RealCell cell = (RealCell)(sheet[loc.getRow()][loc.getCol()]);
				Double number = cell.getDoubleValue();
				operands.add(number);
			}else {
				operands.add(Double.parseDouble(inputArr[i]));
			}
		}
		return operands;
	}
	
	
	public double calculate(String operator, Double operand1, Double operand2) {//does the calculation between two operands
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
	
	public double sum(String cellRange) { //calculates the sum of a cell range
		double sum = 0;
		String[] rangeArr = cellRange.split("-");
		SpreadsheetLocation startCell = new SpreadsheetLocation(rangeArr[0]);
		SpreadsheetLocation endCell = new SpreadsheetLocation(rangeArr[1]);
		for(int row = startCell.getRow(); row <= endCell.getRow(); row++) {
			for(int col = startCell.getCol();col <= endCell.getCol(); col++) {
				RealCell cell = (RealCell)(sheet[row][col]);
				sum+= cell.getDoubleValue();
			}
		}
		return sum;
	}
	
	public double avg(String cellRange) {//will call the sum method and then divide by the number of cells
		double sum = sum(cellRange);
		String[] rangeArr = cellRange.split("-");
		SpreadsheetLocation startCell = new SpreadsheetLocation(rangeArr[0]);
		SpreadsheetLocation endCell = new SpreadsheetLocation(rangeArr[1]);
		int row = endCell.getRow() - startCell.getRow() + 1;
		int col = endCell.getCol() - startCell.getCol() + 1;
		return (sum / (row * col));
	}

}
