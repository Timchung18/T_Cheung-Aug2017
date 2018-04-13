/*Tim Cheung
 * AP CS, Pd. 1
 * 4/13/18 */
package textExcel;

public class RealCell implements Cell{
	private String userinput;
	public RealCell (String userInput) {
		userinput = userInput;
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		//may not need this code?
		String abbrev = userinput;
		if(userinput.length() > 10) {
			abbrev = userinput.substring(0,10);
		}
		abbrev += spaces(userinput.length());
		return userinput;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return userinput;
	}
	public double getDoubleValue() {
		//returns the value of the cell as a double (changes string into double)
		double value = Double.parseDouble(userinput);
		return value;
	}
	public String spaces(int length) { 
		//adds spaces to the abbreviated text so that it is exactly ten indexes long
		String space = "";
		for (int i = length; i < 10; i ++) {
			space += " ";
		}
		return space;
	}
	public String getUserInput(){
		return userinput;
	}
	

}
