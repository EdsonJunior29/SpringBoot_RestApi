package br.com.LearningRestAPI.RestApiWithSpring.request.converters;

public class NumberConverter {
	
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		//substituição de vírgula por ponto usando replaceAll
		String number = strNumber.replaceAll(",", "."); 
		//Regex que verifica se e um número.
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static double convertToDouble(String strNumber) {
			if(strNumber == null) return 0D;
			String number = strNumber.replaceAll(",", ".");
			if(isNumeric(number)) return Double.parseDouble(number);
			return 0D;
		}
	

}
