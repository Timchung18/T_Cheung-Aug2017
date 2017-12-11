package fracCalc;

public class Fraction {
	//checkpoint two: return components of the second operand
	private String wholenumstr;
	private String numeratorstr;
	private String denomstr;
	public Fraction (String operand) {
		String [] operandarr = operand.split("_");
		wholenumstr = operandarr[0];
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

}
