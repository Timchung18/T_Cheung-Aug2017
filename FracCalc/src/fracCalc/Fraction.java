package fracCalc;

public class Fraction {
	//checkpoint two: return components of the second operand
	private String wholenumstr;
	private String numeratorstr;
	private String denomstr;
	private int wholenum;
	private int numerator;
	private int denom;
	
	public Fraction (String operand) {
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
	public String check2String() {
		String answer = "whole:" + toNumber(wholenumstr) + " numerator:" + toNumber(numeratorstr) + " denominator:" + toNumber(denomstr);
		return answer;
	}
	public void toInt() {
		wholenum = toNumber(wholenumstr);
		numerator = toNumber(numeratorstr);
		denom = toNumber(denomstr);
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

}
