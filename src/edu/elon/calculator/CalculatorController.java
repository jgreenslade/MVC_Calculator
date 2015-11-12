package edu.elon.calculator;

public class CalculatorController implements CalculatorControllerInterface {

	private CalculatorGui view;
	private CalculatorModelInterface model;

	private boolean decimal = false;
	private boolean onFirstValue = true;

	public CalculatorController(CalculatorModelInterface model) {
		this.model = model;
		view = new CalculatorGui(this, model);
		view.setScreenText("0");
	}

	@Override
	public void buttonPressed(String value) {
		// System.out.println(value);
		try {
			// Digit
			int digit = Integer.parseInt(value);
			if (decimal) {
				if (onFirstValue) {
					model.setValue1(addDecimal(digit));
				} else if (!onFirstValue) {
					model.setValue2(addDecimal(digit));
				}
			} else {
				if (model.getValue1() == null) {
					model.setValue1(digit + 0.0);
				} else if (model.getValue1() != null && onFirstValue) {
					model.setValue1(model.getValue1() * 10 + digit);
				} else if (model.getValue2() == null) {
					model.setValue2(digit + 0.0);
				} else if (model.getValue2() != null) {
					model.setValue2(model.getValue2() * 10 + digit);
				}
			}
		} catch (NumberFormatException e) {
			// Non-digit
			if (value.equals(".") && !decimal) {
				decimal = true;
			} else if (value.equals(".") && decimal) {
				enteredInvalidInput();
			} else if (value.equals("=")) {
				model.evaluate();
				onFirstValue = true;
				decimal = false;
			} else if (onFirstValue) {
				if (model.getValue1() != null) {
					model.setOperator(value);
				} else {
					enteredInvalidInput();
				}
				onFirstValue = false;
				decimal = false;
			}
		}
	}

	private Double addDecimal(int digit) {
		if (model.getCurrentValue() == null) {
			return digit / 10.0;
		} else if ((model.getCurrentValue() % 1) == 0) {
			return model.getCurrentValue() + digit / 10.0;
		}
		String sTemp = model.getCurrentValue() + "" + digit;
		return Double.parseDouble(sTemp);
	}

	private void enteredInvalidInput() {
		view.setScreenText("INVALID");
	}

}
