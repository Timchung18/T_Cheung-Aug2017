package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;//represents the row#
	private int column;//represents the column letter
	public SpreadsheetLocation(String cellName)
    {
    	cellName = cellName.toLowerCase();
    	column = cellName.charAt(0) - 'a';
    	row = cellName.charAt(1) - 49;
    	if(cellName.length()==3) {
    		row = cellName.charAt(1) * 10 - 480;
    		row += cellName.charAt(2) - 49;
    	}
    }
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
    
    

}

