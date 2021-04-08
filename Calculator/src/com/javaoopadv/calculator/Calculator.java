/**
 * 
 */
package com.javaoopadv.calculator;

import java.io.Serializable;

/**
 * @author ccomstock
 *
 */
public class Calculator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4649675006852228136L;
	private double operandOne = 0;
	private double operandTwo = 0;
	private String operation = "";
	private double result = 0;

	/**
	 * 
	 */
	public Calculator() {}

	/**
	 * @return the operandOne
	 */
	public double getOperandOne() {
		return operandOne;
	}

	/**
	 * @param operandOne the operandOne to set
	 */
	public void setOperandOne(double operandOne) {
		result = 0;
		this.operandOne = operandOne;
	}

	/**
	 * @return the operandTwo
	 */
	public double getOperandTwo() {
		return operandTwo;
	}

	/**
	 * @param operandTwo the operandTwo to set
	 */
	public void setOperandTwo(double operandTwo) {
		result = 0;
		this.operandTwo = operandTwo;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		result = 0;
		if(operation == "+" || operation == "-")
			this.operation = operation;
	}
	
	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	public void performOperation() {
		if(operation == "+")
			result = operandOne + operandTwo;
		else if(operation == "-")
			result = operandOne - operandTwo;
	}

}
