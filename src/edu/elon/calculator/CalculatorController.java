package edu.elon.calculator;

public class CalculatorController implements CalculatorControllerInterface{
	
	private CalculatorGui view;
	
	public CalculatorController(CalculatorModelInterface calculator, CalculatorGui view) {
		this.view = view;
	}
	

	@Override
	public void buttonPressed(String value) {
		System.out.println(value);
	}


	

}
