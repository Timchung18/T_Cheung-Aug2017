package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(th.getText());
		//Spreadsheet abc = new Spreadsheet();
		//System.out.println(abc.getGridText());
	
		Scanner userinput = new Scanner (System.in);
		Spreadsheet sheet = new Spreadsheet();
		boolean done = true;
		while (done) {
			String command = userinput.nextLine();
			if (command.equals("quit")) {
				done = false;
			}
			System.out.println(sheet.processCommand(command));
		}
		
	}
}

