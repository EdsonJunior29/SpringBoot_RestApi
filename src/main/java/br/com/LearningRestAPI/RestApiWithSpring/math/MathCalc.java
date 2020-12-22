package br.com.LearningRestAPI.RestApiWithSpring.math;

public class MathCalc {
	
	public Double sum(Double firstNumber , Double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public Double subtraction(Double firstNumber , Double secondNumber) {
		return firstNumber - secondNumber;
	}
	
	public Double multiplication(Double firstNumber , Double secondNumber) {
		return firstNumber * secondNumber;
	}
	
	public Double division(Double firstNumber , Double secondNumber ) {
		return firstNumber / secondNumber;
	}
	
	public Double avg (Double firstNumber , Double secondNumber ) {
		return (firstNumber  + secondNumber) / 2;
	}
	public Double squareRoot(Double Number) {
		return (Double) Math.sqrt(Number);
	}

}
