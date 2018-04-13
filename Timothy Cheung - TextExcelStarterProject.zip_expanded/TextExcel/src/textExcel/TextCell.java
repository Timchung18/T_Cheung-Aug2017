/*Tim Cheung
 * AP CS, Pd. 1
 * 4/13/18 */
package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell (String word) {
		text = word;
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		String abbrev = text;
		if(text.length() > 10) {
			abbrev = text.substring(0,10);
		}
		abbrev += spaces(text.length());
		return abbrev;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return ("\"" + text + "\"");
	}
	public String spaces(int length) {
		//adds spaces to the abbreviated text so that it is exactly ten indexes long
		String space = "";
		for (int i = length; i < 10; i ++) {
			space += " ";
		}
		return space;
	}

}
