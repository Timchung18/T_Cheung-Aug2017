import java.util.*;
public class ProcessingNumbers {
	
	public static void main(String[] args) {
		int number;
		int sum = 0;
		int greatestnum = 0;
		int leastnum = 0;
		String yes = "yes";
		@SuppressWarnings("resource")
		Scanner userinput = new Scanner(System.in);
		System.out.println("Enter an integer");
		number = userinput.nextInt();
		if (number%2 == 0) {
			sum = number + sum;
		}
		greatestnum = number;
		leastnum = number;
		System.out.println("Do you want to enter another number?");
		String keepgoing = userinput.next();
		while (keepgoing.equals(yes)) {
			System.out.println("Enter an integer");
			number = userinput.nextInt();
			if (number%2 == 0) {
				sum = number + sum;
			}
			if (number >= greatestnum) {
				greatestnum = number;
			}
			if (number <= leastnum) {
				leastnum = number;
			}
			System.out.println("Do you want to enter another number?");
			keepgoing = userinput.next();
		}
		System.out.println("the greatest number is: " + greatestnum + ".");
		System.out.println("the least number is: " + leastnum + ".");
		System.out.println("the sum of the even numbers is: " + sum + ".");
		
	}

}

