package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int column;
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	column = cellName.charAt(0) - 65;
    	row = cellName.charAt(1);
    	
    }

}
