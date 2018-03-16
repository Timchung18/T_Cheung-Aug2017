package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell [][] sheet;
	public Spreadsheet () {
		sheet = new Emptycell [20][12];
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
		return null;
	}

	@Override
	public String getGridText()
	{
		//  returns entire grid, formatted as text for display
		return "";
	}

}
