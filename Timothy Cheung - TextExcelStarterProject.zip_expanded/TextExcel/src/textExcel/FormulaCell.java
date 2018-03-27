package textExcel;

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
	

}
