package edu.elon.calculator;

public interface CalculatorModelInterface {
	
	public void notifyObservers();
	
	public void addObserver(Observer o);
	
	public void setChanged();
	
	public void clearChanged();
	
	public boolean hasChanged();
	
	public Double getValue1() ;
	
	public Double getValue2();

	public void setValue1(Double value1);

	public void setValue2(Double value2);

	public void setOperator(String operator);

	public String getOperator();
	
	public Double getCurrentValue();
	
	public void evaluate() ;
}
