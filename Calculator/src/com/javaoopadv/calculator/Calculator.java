/**
 * 
 */
package com.javaoopadv.calculator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

/**
 * @author ccomstock
 *
 */
public class Calculator implements Serializable {

	private static final long serialVersionUID = 4649675006852228136L;
	private ArrayList<String> operations;
	private double result = 0;
	private boolean operandSet = false;

	public Calculator() {
		operations = new ArrayList<String>();
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the operations
	 */
	public ArrayList<String> getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(ArrayList<String> operations) {
		this.operations = operations;
	}

	/**
	 * @return the operandSet
	 */
	  public boolean isOperandSet() { 
		  return operandSet;
	  }
	 

	/**
	 * @param operandSet the operandSet to set
	 */
	  public void setOperandSet(boolean operandSet) { 
		  this.operandSet = operandSet;
	  }
	
	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}

	/**
	 * executes all calculations
	 */
	private void performOperations() {
		//System.out.println("operations: " + 
		//		Arrays.toString(operations.toArray(new String[0])));
		
		if(operations.isEmpty()) return;
		else if(operations.size() == 1) {
			result = Double.parseDouble(operations.get(0));
			return;
		}
		
		ListIterator<String> iterator = operations.listIterator();
		result = 0;
		while(iterator.hasNext()) {
			double operand1 = 0;
			double operand2 = 0;
			String temp = iterator.next();
			if(temp == "*" || temp == "/") {
				iterator.remove();
				operand1 = Double.parseDouble(iterator.previous());
				iterator.remove();
				operand2 = Double.parseDouble(iterator.next());
				iterator.remove();
				iterator.add(Double.toString(performOperation(operand1, operand2, temp)));
			}
		}
		
		//System.out.println("operations: " + 
		//		Arrays.toString(operations.toArray(new String[0])));
		
		while(iterator.hasPrevious())
			iterator.previous();
		
		while(iterator.hasNext()) {
			double operand1 = 0;
			double operand2 = 0;
			String temp = iterator.next();
			if(temp == "+" || temp == "-") {
				iterator.remove();
				operand1 = Double.parseDouble(iterator.previous());
				iterator.remove();
				operand2 = Double.parseDouble(iterator.next());
				iterator.remove();
				iterator.add(Double.toString(performOperation(operand1, operand2, temp)));
			}
		}
		
		//System.out.println("operations: " + 
		//		Arrays.toString(operations.toArray(new String[0])));
		
		result = Double.parseDouble(iterator.previous());
		iterator.remove();
	}

	/**
	 * executes calculation
	 */
	private Double performOperation(double operand1, double operand2, String operation) {
		if(operation == "+")
			return operand1 + operand2;
		else if(operation == "-")
			return operand1 - operand2;
		else if(operation == "*")
			return operand1 * operand2;
		else
			return operand1 / operand2;
	}
	
	public void performOperation(double operand) {
		if(operandSet)
			operations.set(operations.size()-1, Double.toString(operand));
		else
			operations.add(Double.toString(operand));
		operandSet = true;
	}
	
	public void performOperation(String operation) {
		if(!operandSet) {
			if(!operations.isEmpty())
				operations.set(operations.size()-1, operation);
			return;
		}
		
		if(!(operation == "="))
			operations.add(operation);
		else
			performOperations();
		operandSet = false;
	}

}
