package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell (String word) {
		text = word;
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		if(text.length() > 10) {
			return text.substring(0,10);
		}
		return text;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return ("\"" + text + "\"");
	}

}
