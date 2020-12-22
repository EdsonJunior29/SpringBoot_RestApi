package br.com.LearningRestAPI.RestApiWithSpring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.LearningRestAPI.RestApiWithSpring.exception.ExceptionCustomizada;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne ,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		//realização de um verificação
		//Quando o numero1 ou  o numero2 nao for numérico será lancada a excecao;
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value = "/decrease/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double decrease(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		Double decre = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return decre;
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply(@PathVariable("numberOne") String numberOne ,
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		Double multi = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multi;
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
	public Double divi(@PathVariable("numberOne") String numberOne , 
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return div;
	}
	
	//Média
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		Double avg = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		return avg;
	}
	
	@RequestMapping(value = "/sqrt/{numberOne}" ,  method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne) throws Exception{
		if(!isNumeric(numberOne)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		Double raiz = Math.sqrt(convertToDouble(numberOne)); 
		return raiz;
	}
	
	//Metodo de verificação se o número passado e Númerico.
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		//substituição de vírgula por ponto usando replaceAll
		String number = strNumber.replaceAll(",", "."); 
		//Regex que verifica se e um número.
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	//metodo para converter String em double.
	private double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	
}
