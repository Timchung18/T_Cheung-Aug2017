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
	
	//This method determines whether or not 
	public static boolean isDivisibleBy(int operand1, int operand2) {
		if (operand2 == 0) {
			throw new IllegalArgumentException("Can't divide a number by 0");
		}
		return (operand1 % operand2) == 0;
	}
	
	//this method returns the absolute number of the number passed
	public static double absValue (double operand) { 
		if (operand < 0.0) {
			operand = operand * -1.0; 
		}
		return operand;
	}
	
	//this method returns the larger of the values passed 
	public static double max(double operandA, double operandB) {
		if (operandA < operandB) {
			operandA = operandB;
		}
		return operandA;
	}
	
	//This method overloads the previous method. This method accepts one more double than the other one
	public static double max(double operandA, double operandB, double operandC) {
		double answer = operandA;
		if (operandA >= operandB && operandA >= operandC) {
			answer = operandA;
		}else if (operandB >= operandC && operandB >= operandA) {
			answer = operandB;
		}else {
			answer = operandC;
		}
		return answer;
	}
	
	//This method returns the smaller of the values passed
	public static int min(int operandA, int operandB) {
		if (operandA < operandB) {
			operandB = operandA;
		}
		return operandB;
	}
	
	//This method rounds a double constantly to 2 decimal places and returns a double		
	public static double round2(double operand) {
		operand = operand * 1000;
		operand = (int) operand;
		int lastdigit = (int) (operand % 10);
		if (lastdigit >= 5) {
			operand = (operand + 10 - lastdigit) / 1000;
		}else {
			operand = (operand - lastdigit) / 1000;
		}
		return operand;
	}
	
	//This method raises a value to a positive integer power (assume that the integer is postitive
	public static double exponent(double base, int power) {
		if (power < 0) {
			throw new IllegalArgumentException("Invalid power: this method only accepts positive powers");
		}
		double k = base;
		double pretendbase = base;
		for (int i = 1; i != power; i ++) {
			k = pretendbase * k;
			base = k;
		}
		return base; 
	}
	
	//This method returns the factorial of the value passed
	public static int factorial(int operandx) {
		if (operandx < 0) {
			throw new IllegalArgumentException("Input is invalid. Can't find the factorial of a negative number");
		}
		int operand = operandx;
		for (int i = 1; i < operand; i++) {
			operandx = operandx * i;
		}
		return operandx;
	}
	
	//This method determines whether or not an integer is prime
	public static boolean isPrime(int operand) {
		boolean test = false;
		int denominator = operand - 1;
		boolean answer = false; 
		while (test == false) {
			test = isDivisibleBy(operand, denominator);
			denominator --;
			
		if (denominator == 0) {
			answer = true;
		}
		}
		return answer;
	}
	
	//This method finds the greatest common factor of two positive integers
	public static int gcf(int operandX, int operandY) {
		int operand2 = min(operandX, operandY);
		int operand1 = (int) max(operandX, operandY);
		if (isPrime(operand1)==true) {
			operand1 = 1;
		}
		while (operand2 > 0) {
			int modula = operand1 % operand2;
			operand1 = operand2;
			operand2 = modula;
		}
		return operand1;
	}
	
	//This method returns an approximation of the square root of the value passed (using Newton's method), 
	//rounded to two decimal places
	public static double sqrt(double operand) {
		if (operand < 0) {
			throw new IllegalArgumentException("The square root of a negative number is not accommodated");
		}
		double Aprox;
		for (Aprox = 1; absValue((Aprox * Aprox)-operand) >= 0.005;) {
			Aprox = 0.5*((operand/Aprox) + Aprox);
		}
		Aprox = round2(Aprox);
		return Aprox;
	}
	
	//This method uses the coefficients of a quadratic equation in standard form and uses the 
	//quadratic formula to approximate the real roots, if any
	public static String quadForm(int a, int b, int c) {
		if (discriminant(a,b,c) < 0) {
			return "no real roots";
		}else {
		return "ok";
		}
	}
	
}

