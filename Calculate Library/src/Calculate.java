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
	public static double toRadians(double angle_in_degrees) {
		return angle_in_degrees * (3.14159 / 180);
	}
//THis method  
	//
	
}
