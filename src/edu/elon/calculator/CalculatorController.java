package edu.elon.calculator;

public class CalculatorController implements CalculatorControllerInterface{
	
	private CalculatorGui view;
	private CalculatorModelInterface model;
	
	private Double value1;
	private Double value2;
	private String operator; // This way they can be null
	private boolean decimal = false;
	
	public CalculatorController(CalculatorModelInterface calculator) {
		view = new CalculatorGui(this, model);
	}
	
	@Override
	public void buttonPressed(String value) {
		System.out.println(value);
		try {
			// Digit
			Double tempVal = Double.parseDouble(value);
			if (value1 != null) {
				if (value2 != null) {
					//model.evaluate(value1, value2, operator);
					
				}
			}
		} catch (NumberFormatException e) {
			if (value.equals(".")) {
				decimal = true;
			} else {
				operator = value;
			}
		}
	}

}
