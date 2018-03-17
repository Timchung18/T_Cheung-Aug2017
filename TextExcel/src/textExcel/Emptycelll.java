package textExcel;

public class Emptycelll implements Cell{
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		return "          ";
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return "";
	}
}