package edu.elon.calculator;

import java.util.ArrayList;

public class CalculatorModel implements CalculatorModelInterface {

	private boolean changed;

	private Double value1;
	private Double value2;
	private String operator; // This way they can be null

	private Double result;
	private Double currentValue;

	public Double getValue1() {
		return value1;
	}

	public void setValue1(Double value1) {
		this.value1 = value1;
		currentValue = this.value1;
		setChanged();
		notifyObservers();
	}

	public Double getValue2() {
		return value2;
	}

	public void setValue2(Double value2) {
		this.value2 = value2;
		currentValue = this.value2;
		setChanged();
		notifyObservers();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	private ArrayList<Observer> observers;

	@Override
	public void notifyObservers() {
		if (changed) {
			for (Observer o : observers) {
				o.update(this);
			}
		}

	}

	@Override
	public void addObserver(Observer o) {
		if (observers == null) {
			observers = new ArrayList<Observer>();
		}
		observers.add(o);
	}

	@Override
	public void setChanged() {
		changed = true;
	}

	@Override
	public void clearChanged() {
		changed = false;
	}

	@Override
	public boolean hasChanged() {
		return changed;
	}

	@Override
	public void evaluate() {
		if (value1 != null && value2 != null && operator != null) {
			if (operator.equals("+")) {
				result = value1 + value2;
			} else if (operator.equals("-")) {
				result = value1 - value2;
			} else if (operator.equals("*")) {
				result = value1 * value2;
			} else if (operator.equals("/")) {
				result = value1 / value2;
			}
		}
		currentValue = result;
		setChanged();
		notifyObservers();
		value1 = null;
		value2 = null;
		currentValue = null;
	}

	@Override
	public Double getResult() {
		return result;
	}

	@Override
	public Double getCurrentValue() {
		return currentValue;
	}

}
