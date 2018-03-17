package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell [][] sheet;
	
	public Spreadsheet () {
		sheet = new EmptyCell [20][12];
		for(int r = 0; r < 20; r++) {
			for(int c = 0; c < 12; c++) {
				Cell temp = new EmptyCell();
				sheet[r][c] = temp;
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		// processes a user command, returns string to display, must be called in loop from main
		return "";
	}

	@Override
	public int getRows()
	{
		// returns number of rows in grid
		return 20;
	}

	@Override
	public int getCols()
	{
		// returns number of columns in grid
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// returns cell at loc
		int row = loc.getRow();
		int column = loc.getCol();
		Cell answer = sheet[row][column];
		return answer;
	}

	@Override
	public String getGridText()
	{
		//  returns entire grid, formatted as text for display
		String firstRow = "";
		for (int i = 0; i < 12; i++) {
			char currLetter = (char)(i + 65);
			firstRow += "|" + currLetter + "         ";
		}
		firstRow += "|\n";
		String theRest = "";
		for (int row = 0; row < 20; row++) {
			theRest += (row+1) + " ";
			if (row<10) {
				theRest += " ";
			}
			for(int column = 0; column < 12; column ++) {
				theRest += sheet[row][column].abbreviatedCellText();
				theRest += "|";
			}
			theRest += "\n";
			
		}
		return (firstRow + theRest);
	}

}
