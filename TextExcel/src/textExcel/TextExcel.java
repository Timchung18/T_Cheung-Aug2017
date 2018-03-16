package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		String firstRow = "";
		for (int i = 0; i < 12; i++) {
			char currLetter = (char)(i + 65);
			firstRow += "|" + currLetter + "         ";
		}
		System.out.println(firstRow);
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
