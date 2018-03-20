package textExcel;

public class PercentCell extends RealCell{
	public PercentCell(String userInput) {
		super(userInput);
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		String userinput = getUserInput();
		String[] parseDecimal = userinput.split(".");
		String abbrevStr = parseDecimal[0];
		abbrevStr += "%";
		//do this? super.abbreviatedCellText();
		// assume that the percent number will not go above 10 digits?
		abbrevStr += spaces(abbrevStr.length());
		return abbrevStr;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		String userinput = getUserInput();
		String noPercentNum = userinput.substring(0, userinput.length()-1);
		double number = getDoubleValue(noPercentNum);
		return (number * .01) + "";
	}
	public double getDoubleValue(String number) {
		//returns the value of the cell as a double (changes string into double)
		//overloaded(?) or overRidden(?) the superclass method for getDoubleValue
		double value = Double.parseDouble(number);
		return value;
	}


}
