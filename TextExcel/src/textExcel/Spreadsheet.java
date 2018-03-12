package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{

	@Override
	public String processCommand(String command)
	{
		// processes a user command, returns string to display, must be called in loop from main
		return null;
	}

	@Override
	public int getRows()
	{
		// returns number of rows in grid
		return 0;
	}

	@Override
	public int getCols()
	{
		// returns number of columns in grid
		return 0;
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
		return null;
	}

}
