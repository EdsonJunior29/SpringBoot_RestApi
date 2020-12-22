package br.com.LearningRestAPI.RestApiWithSpring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.LearningRestAPI.RestApiWithSpring.exception.ExceptionCustomizada;
import br.com.LearningRestAPI.RestApiWithSpring.math.MathCalc;
import br.com.LearningRestAPI.RestApiWithSpring.request.converters.NumberConverter;

@RestController
public class MathController {
	
	MathCalc mathCalc = new MathCalc();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne ,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		//realização de um verificação
		//Quando o numero1 ou  o numero2 nao for numérico será lancada a excecao;
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		return mathCalc.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/decrease/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double decrease(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		 return mathCalc.subtraction(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
		
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply(@PathVariable("numberOne") String numberOne ,
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		return mathCalc.multiplication(NumberConverter.convertToDouble(numberOne) ,NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}" ,method = RequestMethod.GET)
	public Double divi(@PathVariable("numberOne") String numberOne , 
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		return mathCalc.division(NumberConverter.convertToDouble(numberOne) ,NumberConverter.convertToDouble(numberTwo));
	}
	
	//Média
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}" , method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		return mathCalc.avg(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/sqrt/{numberOne}" ,  method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne) throws Exception{
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new ExceptionCustomizada("Please set a numeric value!");
		}
		return mathCalc.squareRoot(NumberConverter.convertToDouble(numberOne)); 
	}
	
}
