package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell [][] sheet;
	
	public Spreadsheet () {
		sheet = new Cell [20][12];
		clearAll();
	}
	@Override
	public String processCommand(String command)
	{
		// processes a user command, returns string to display, must be called in loop from main
		if (command.equals("")||command.equals("quit")) {
			return "";
		}
		String[] splittedComm = command.split(" ");
		if(splittedComm.length < 3) {
			command = command.toLowerCase();
			if (command.contains("clear")) {
				if (command.equals("clear")) {
					clearAll();
					return getGridText(); //clears the whole thing
				}else {
					Location cell = new SpreadsheetLocation(splittedComm[1]);
					sheet [cell.getRow()][cell.getCol()] = new EmptyCell();
					return getGridText();//clears a cell
				}
			}else {
				return cellInspc(command);//passes it to cell inspection 
			}
		}else {
			//send it to another method for assignment (which type of cell?) which sends it to the real thing
			return stringAssign(command); //assigning a string to a cell
		}
		
	}
	public void assignment(String command) {
		String [] splitCommand = command.split(" ", 2);
		if (splitCommand[1].contains("\"")) {
			stringAssign(command);
		} else if (splitCommand[1].contains("( ")) {
			//send to formula
			assignFormula(command);
		} else if (splitCommand[1].contains("%")) {
			//send to percent
			assignPercent(command);
		}else { //value cell
			
			
		}
			
		}
	
	public String stringAssign(String command) {
		String [] splitCommand = command.split(" ", 2);
		Location location = new SpreadsheetLocation (splitCommand[0]);
		//String [] strWithQuotes = splitCommand[1].split("=",2);
		String str = splitCommand[1].substring(2);
		str = str.substring(1, str.length() - 1);
		Cell strAssignment = new TextCell(str); //to reduce lines of code maybe combine this and next line 
		sheet[location.getRow()][location.getCol()] = strAssignment;
		return getGridText();
	}
	
	public String assignPercent(String command) {
		String[] splitCommand = command.split(" ");
		String cellLocation = splitCommand[0];
		Location location = new SpreadsheetLocation (cellLocation);
		Cell assignment = new PercentCell(splitCommand[2]);
		sheet[location.getRow()][location.getCol()] = assignment;
		return getGridText();
	}
	public String assignFormula(String command) {
		String[] splitCommand = command.split(" ", 3);
		//A2 = (A5 - A6)
		String cellLocation = splitCommand[0];
		Location location = new SpreadsheetLocation (cellLocation);
		Cell assignment = new FormulaCell(splitCommand[2]);
		sheet[location.getRow()][location.getCol()] = assignment;
		return getGridText();
	}
	public void assignValue(String command) {
		String[] splitCommand = command.split(" ", 3);
		String cellLocation = splitCommand[0];
		
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
		String firstRow = "   ";
		for (int i = 0; i < 12; i++) {
			char currLetter = (char)(i + 65);
			firstRow += "|" + currLetter + "         ";
		}
		firstRow += "|\n";
		String theRest = "";
		for (int row = 0; row < 20; row++) {
			String wholeRow = (row+1) + " ";
			if (row<9) {
				wholeRow += " ";
			}
			wholeRow += "|";
			for(int column = 0; column < 12; column ++) {
				wholeRow += sheet[row][column].abbreviatedCellText();
				wholeRow += "|";
			}
			theRest += wholeRow + "\n";
			
		}
		return (firstRow + theRest);
	}
	
	
	
	public String cellInspc(String command) {
		Location cellLoc = new SpreadsheetLocation(command);
		String insideValue = sheet[cellLoc.getRow()][cellLoc.getCol()].fullCellText();
		return insideValue;
	}
	
	public void clearAll() {
		
		for(int r = 0; r < 20; r++) {
			for(int c = 0; c < 12; c++) {
				sheet[r][c] = new EmptyCell();
			}
		}
	}
}

