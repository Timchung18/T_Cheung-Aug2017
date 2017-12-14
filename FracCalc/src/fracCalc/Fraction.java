//Tim Cheung, APCS1
// 12/14/17
// This is an object class for Fractions. It contains methods to construct, calculate, and reduce fractions.
package fracCalc;

public class Fraction {
	//checkpoint two: return components of the second operand
	private int wholenum;
	private int numerator;
	private int denom;
	private String wholenumstr;
	private String numeratorstr;
	private String denomstr;
	//Constructor
	public Fraction (String operand) {
		createNewFraction(operand);
	}

	public String check2String() {
		String answer = "whole:" + wholenum + " numerator:" + numerator + " denominator:" + denom;
		return answer;
	}

	public void splitOperand(String operand) {

		String [] operandarr = operand.split("_");
		wholenumstr = operandarr[0];
		numeratorstr = "0";
		denomstr = "1";
		String fracofmxnum = "";
		if(operandarr.length==2) {
			fracofmxnum = operandarr[1];
			fracofmxnum.split("/");
			numeratorstr = fracofmxnum.split("/")[0];
			denomstr = fracofmxnum.split("/")[1];   		
		}else if (wholenumstr.contains("/")){//check to see if the first number is a fraction or a whole number?
			numeratorstr = wholenumstr.split("/")[0];
			denomstr = wholenumstr.split("/")[1];
			wholenumstr = "0";
		}
	}

	private int toNumber(String numberstr) {
		int negmultiplier = 1;
		if (numberstr.contains("-")) {
			numberstr = numberstr.substring(1);
			negmultiplier = -1;
		}
		int i = 0;
		while (i >= 0) {
			String j = "" + i;
			if (numberstr.equals(j)) {
				return i* negmultiplier;
			}
			i ++;
		}
		return 0;
	}
	public void toImproperFrac() {
		int multiplier = 1;
		if (wholenum<0) {
			multiplier = -1;
		}
		int top = ((absValue(wholenum) * denom) + numerator);
		top *= multiplier;
		numerator = top;
		wholenum = 0;
	}
	public int absValue(int number) {
		if (number < 0) {
			number = number * -1; 
		}
		return number;
	}

	public void addOrsubtract(int numerator, int denominator, String operator) {
		this.numerator = denominator * this.numerator;
		numerator = this.denom * numerator;
		this.denom = this.denom * denominator;
		denominator = this.denom; 
		if (operator.equals("-")) {
			numerator = numerator * (-1);
		}
		this.numerator = this.numerator + numerator;
	}
	public void commonDenom(int numerator, int denominator) {
		this.numerator = denominator * this.numerator;
		numerator = this.denom * numerator;
		this.denom = this.denom * denominator;
		denominator = this.denom; 
	}
	public void multiplyOrdivide(int numerator, int denominator, String operator) {
		if (operator.equals("/")) {
			int save = numerator;
			if (numerator<0) {
				save*= (-1);
				denominator *= (-1);
			}
			numerator = denominator;
			denominator = save;
		}
		this.numerator = this.numerator * numerator;
		this.denom = this.denom * denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denom;
	}

	public String toString() {
		simplify();
		String answer = wholenum + "_" + numerator + "/" + denom;
		if (wholenum == 0) {
			answer = numerator + "/" + denom;
		}else if (numerator % denom == 0) {
			answer = "" + wholenum;
		}
		if (numerator == 0) {
			answer = "0";
		}
		return answer;
	}

	private void simplify(){
		if (numerator % denom == 0) {
			wholenum = numerator/denom;
		}else if(absValue(numerator) > denom) {
			toMixedNum();
			reduce();
		}else if (absValue(numerator) < denom) {
			int tempvalue = numerator;
			reduce();
			if(tempvalue < 0) {
				numerator *= -1;
			}
		}
	}
	 /*public static String simplifyAndToString(int[] answer) {
	    	if (answer[0] % answer[1] == 0) {
	    		return "" + answer[0]/answer[1];
	    	}else if(absValue(answer[0]) > answer[1]) {
	    		return toMixedNum(answer);
	    	}else if (absValue(answer[0]) < answer[1]) {
	    		int tempvalue = answer[0];
	    		reduce(answer);
	    		if(tempvalue < 0) {
	    			answer[0] *= -1;
	    		}
	    		return  answer[0] + "/" + answer[1];
	    	}
	    	return "";
	    }*/
	private int findGCF(int numerator, int denominator) {
		if (isPrime(denominator)==true) {
			return 1;
		}
		while (numerator > 0) {
			int modula = denominator % numerator;
			denominator = numerator;
			numerator = modula;
		}
		return denominator;
	}

	private boolean isPrime(int operand) {
		boolean test = false;
		int denominator = operand - 1;
		while (test == false) {
			test = ((operand%denominator)==0);
			denominator --;
			if (denominator == 0) {
				return true;
			}
		}
		return false;
	}

	private void reduce() {
		numerator = absValue(numerator);
		int gcf = findGCF(numerator,denom);
		numerator = numerator / gcf;
		denom = denom / gcf;
	}

	private void toMixedNum () {
		wholenum = numerator / denom;
		numerator = numerator % denom;
		if (numerator<0) {
			numerator *= (-1);
		}
	}
	
	public void createNewFraction(String operand) {
		splitOperand(operand);
		wholenum = toNumber(wholenumstr);
		numerator = toNumber(numeratorstr);
		denom = toNumber(denomstr);
	}
}
