package edu.elon.calculator;

public class CalculatorController implements CalculatorControllerInterface{
	
	private CalculatorGui view;
	private CalculatorModelInterface model;
	
	//private Double value1;
	//private Double value2;
	//private String operator; // This way they can be null
	private boolean decimal = false;
	private boolean onFirstValue = true;
	
	public CalculatorController(CalculatorModelInterface model) {
		this.model = model;
		view = new CalculatorGui(this, model);
	}
	
	@Override
	public void buttonPressed(String value) {
		System.out.println(value);
		try {
			// Digit
			Double digit = Double.parseDouble(value);
			if (model.getValue1() == null) {
				model.setValue1(digit);
			} else if (model.getValue1() != null && onFirstValue) {
				model.setValue1(model.getValue1()*10 + digit);
			}
		} catch (NumberFormatException e) {
			// Non-digit
			if (value.equals(".")) {
				decimal = true;
			}else if (value.equals("=")) {
				model.evaluate();
			} else {
				//operator = value;
				onFirstValue = false;
			}
		}
	}

}
