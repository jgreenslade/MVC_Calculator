package edu.elon.calculator;

public interface CalculatorModelInterface {
	
	public void notifyObservers();
	
	public void addObserver(Observer o);
	
	public void setChanged();
	
	public void clearChanged();
	
	public boolean hasChanged();
	
	public void evaluate() ;
	
	public Double getValue1() ;

	public void setValue1(Double value1);

	public Double getValue2();

	public void setValue2(Double value2);

	public String getOperator() ;

	public void setOperator(String operator);

	public Double getResult();
	
	public Double getCurrentValue();
	
}
