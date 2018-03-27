package textExcel;

public class PercentCell extends ValueCell{
	public PercentCell(String userInput) {
		super(userInput);
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		String userinput = getUserInput();
		//String[] parseDecimal = userinput.split(".",2);
		//String abbrevStr = parseDecimal[0];
		//abbrevStr += "%";
		//abbrevStr += super.spaces(abbrevStr.length());
		int index = userinput.indexOf(".");
		//return abbrevStr;
		String answer = userinput.substring(0, index);
		answer += "%";
		return answer;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return (getDoubleValue()) + "";
	}
	public double getDoubleValue() {
		//returns the value of the cell as a double (changes string into double)
		//overloaded(?) or overRidden(?) the superclass method for getDoubleValue
		String userinput = getUserInput();
		String noPercentNum = userinput.substring(0, userinput.length()-1);
		double value = Double.parseDouble(noPercentNum);
		return value * 0.01;
	}
	

}
