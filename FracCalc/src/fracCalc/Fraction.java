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
		splitOperand(operand);
		wholenum = toNumber(wholenumstr);
		numerator = toNumber(numeratorstr);
		denom = toNumber(denomstr);
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
    	if (numerator<0||wholenum<0) {
    		multiplier = -1;
    	}
		int top = ((absValue(wholenum) * denom) + numerator);
		top *= multiplier;
		numerator = top;
	}
	public int absValue(int number) {
		if (number < 0) {
			number = number * -1; 
		}
		return number;
	}
	
	public void addOrsubtract(int numerator, int denominator, String operator) {
		commonDenom(numerator,denominator);
    	if (operator.equals("-")) {
    		numerator = numerator * (-1);
    	}
    	this.numerator = this.numerator + this.numerator;
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
}
