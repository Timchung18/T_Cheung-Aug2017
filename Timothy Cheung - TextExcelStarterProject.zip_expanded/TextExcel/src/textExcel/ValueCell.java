package textExcel;

public class ValueCell extends RealCell{
	//inherited: string userinput field; abreviated method; fulltext method; getdouble method
	
	public ValueCell(String userInput) {
		super(userInput);
		
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		//may not need this code?
		String userinput = super.getUserInput();
		double inputValue = super.getDoubleValue();
		userinput = inputValue + "";
		String truncated = "";
		if(userinput.length() > 10) {
			truncated = userinput.substring(0,10);
			return truncated;
		}
		userinput += super.spaces(userinput.length());
		return userinput;
	}


}
