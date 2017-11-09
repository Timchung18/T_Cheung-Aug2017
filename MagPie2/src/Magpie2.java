
public class Magpie2 {

	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String check = statement.trim();
		if (check.length() <= 0) {
			System.out.println("Please say something");
		}
		
		String response = "";
		if (statement.indexOf("no") >= 0) {
			response = "Yes";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0) {
			response = "Tell me more about your family.";
		} else if (statement.indexOf("brother") >= 0) {
			response = "Is that an older or younger brother?";
		}else if (statement.indexOf("sister") >= 0) {
			response = "Sisters can be annoying sometimes";
		}
		else if(statement.indexOf("Mr.Lamont")>=0
				|| statement.indexOf("Ms. Dreyer")>=0
				||  statement.indexOf("Mr. Knox")>=0
				|| statement.indexOf("Mr. Millstein")>=0
				|| statement.indexOf("Mr. Cancilla")>=0) {
			response = "If only all teachers can be like that...";
			
		} else if (statement.indexOf("asdfghjkl")>=0) {
			response = "English, please";
		}else if (check.length() == 1) {
			response = "Care to elaborate?";
		}
		else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}
}
