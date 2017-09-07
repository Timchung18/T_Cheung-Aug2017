/* Tim Cheung
 * September 5, 2017
 * this library contains several mathematical methods and calculations
 */
public class Calculate {
	//This method takes an integer and returns its square
	public static int square (int operand) {
	return operand * operand;
	}
			
	//This method takes an integer and returns its cube
	public static int cube (int operand) {
			return operand * operand * operand;
	}
	
	//This method averages two numbers 
	public static double average(double value1, double value2) {
		return (value1 + value2) / 2;
	}
	
	//This method averages three numbers (overloading)
	public static double average(double value1, double value2, double value3) {
		return (value1 + value2 + value3) / 3;
	}
	
	//This method converts an angle measure given in degrees into an angle in radians
	public static double toRadians(double angle) {
		return angle * (3.14159 / 180);
	}
	
	//This method converts an angle measure given in radians into degrees
	public static double toDegrees(double angle) {
		return angle*(180/3.14159);
	}
	
	// This method provides the coefficients of a quadratic equation in standard form (a, b, c,) and returns 
	//the value of the discriminant 
	public static double discriminant(double a, double b, double c) {
		return (b*b)- 4*a*c;
	}
	
	//This method converts mixed number into an improper fraction; exceptions: negative numbers
	public static String toImproperFrac(int wholenumber, int numerator, int denominator) {
		int top;
		top = ((wholenumber*denominator) + numerator);
		return (top + "/" + denominator);
	}
	
	//This method converts an improper fraction into a mixed number 
	public static String toMixedNum (int numerator, int denominator) {
		int newnumerator = numerator%denominator;
		int wholenumber = (numerator - newnumerator) / denominator;
		return (wholenumber + "_" + newnumerator +  "/" + denominator);
	}
	
	//This method converts a binomial multiplication of the from (ax+b)(cx+d) into a quadratic equation of the form
	//ax^2 + bx + c
	public static String foil(int a, int b, int c, int d,String variable) {
		int first = a*c;
		int opposite = a * d;
		int inside = b * c;
		int last = b * d;
		return (first + variable + "^2" + "+" + (opposite + inside) + variable + "+" + last);
	}//negative numbers do weird things in "foil" method and toMIxedNum and toImproperFrac
}
