package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		 // Add your command loop here
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
