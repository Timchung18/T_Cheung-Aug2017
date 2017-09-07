/* Tim Cheung
 * September 5, 2017
 * This is the runner class for my Calculate Library methods
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(-2));
		System.out.println(Calculate.cube(3));
		System.out.println(Calculate.average(2.6,2.7));
		System.out.println(Calculate.average(2.0,3.0,4.0));
		System.out.println(Calculate.toRadians(45.0));
		System.out.println(Calculate.toDegrees(0.7853975));
		System.out.println(Calculate.discriminant(1.0, -5.0, 6.0));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(5, 2));
		System.out.println(Calculate.foil(2,3,4,-2,"x"));
		System.out.println(Calculate.isDivisibleBy(5, -9));
}
}