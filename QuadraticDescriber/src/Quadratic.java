//Tim Cheung
//October 8, 2017
//This class contains methods that help give useful information about a parabola
public class Quadratic {
	//This method returns the number rounded to the nearest hundreth's place
	public static double round2(double operand) {
		operand = operand * 1000;
		operand = (int) operand;
		int lastdigit = (int) (operand % 10);
		if (lastdigit <= -5) {
			operand = (operand - 10 - lastdigit) / 1000;
		}else if (lastdigit > -5 && operand < 0){
			operand = (operand - lastdigit) / 1000;
		}
		if (lastdigit >= 5) {
			operand = (operand + 10 - lastdigit) / 1000;
		}else if (lastdigit < 5 && operand >= 0){
			operand = (operand - lastdigit) / 1000;
		}
		return operand;
	}
	
	//This method returns the discriminant of the coefficients and constant of a quadratic equation
	public static double discriminant(double a, double b, double c) {
		return (b*b)- 4*a*c;
	}
	
	/*//This method uses the coefficients of a quadratic equation in standard 
	 * form and uses the quadratic formula to approximate the
	 * real roots, if any */
	public static String quadForm(double a, double b, double c) {
		String roundedroot1 = "0";
		String roundedroot2 = "0";
		double discrim = discriminant(a,b,c);
		if (discrim < 0) {
			return "none";
		}else if(discrim == 0) {
			double root1 = (-b) / (2.0 * a);
			roundedroot1 = "" + round2(root1);
			return roundedroot1;
		}else {
			double root1 = ((-b) + sqrt(discrim)) / (2 * a);
			double root2 = ((-b) - sqrt(discrim)) / (2 * a);
			roundedroot1 = "" + round2(root1);
			roundedroot2 = "" + round2(root2);
			return roundedroot1 + " and " + roundedroot2;
		}
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
		
		//this method returns the absolute number of the number passed
		public static double absValue (double operand) { 
			if (operand < 0.0) {
				operand = operand * -1.0; 
			}
			return operand;
		}
		
		//This method returns information about the quadratic equation that the user creates
	public static String quadrDescriber (double a, double b, double c) {
		String equation = "Description of the graph of :\ny = " + a + " x^2 + " + b + " x + " + c;
		String opens = "Opens: up\n";
		if (a < 0) {
			opens = "Opens: down\n";
		}
		double axis = -1 * b/(2*a);
		double yofvertex = (a * axis * axis) + (b * axis) + c;
		String axisofsym = "Axis of Symmetry: " + axis + "\n";
		String vertex =  "Vertex: (" + axis + ", " + yofvertex + ")\n";
		String xintercept = "x-intercept(s): " + quadForm(a,b,c) + "\n";
		String yintercept = "y-intercept: " + c;
		return equation + "\n\n" + opens + axisofsym + vertex + xintercept + yintercept;
		
	}

}
