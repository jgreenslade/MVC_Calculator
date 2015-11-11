package edu.elon.calculator;

import java.util.ArrayList;

public class CalculatorModel implements CalculatorModelInterface{
	
	private boolean changed;
	
	private ArrayList<Observer> observers;

	@Override
	public void notifyObservers() {
		if (changed) {
			for (Observer o: observers) {
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
	public double evaluate(double v1, double v2, String operator) {
		return 0.0;
	}

}
