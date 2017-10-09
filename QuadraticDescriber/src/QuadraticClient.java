/*Tim Cheung
 * October 9, 2017
 * Description: this class contains a method that takes the user's input of any coefficients for a quadratic equation
 * and print useful information about the equation.
 */
import java.util.*;
public class QuadraticClient {

	public static void main(String [] args) {
		@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
		System.out.println("Welcome to Tim's Quadratic Describer");
		String done = "no";
		while (done.equals("no")) {
			System.out.println("Provide values for coefficients a, b, and c\n");
			System.out.print("a: ");
			double a = userinput.nextDouble();
			System.out.print("b: ");
			double b = userinput.nextDouble();
			System.out.print("c: ");
			double c = userinput.nextDouble();
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("\nDo you want to keep going? (Type \"no\" to end or \"yes\" to keep going;)");
			String keepgoin = userinput.next();
			if (keepgoin.equals("no")) {
				done = "yes";
			}
			System.out.println("");
		}
		
	}

}
