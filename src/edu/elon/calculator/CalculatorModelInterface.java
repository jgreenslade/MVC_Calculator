package edu.elon.calculator;

public interface CalculatorModelInterface {
	
	public void notifyObservers();
	
	public void addObserver(Observer o);
	
	public void setChanged();
	
	public void clearChanged();
	
	public boolean hasChanged();
	
	public double evaluate(double v1, double v2, String operator) ;

}
