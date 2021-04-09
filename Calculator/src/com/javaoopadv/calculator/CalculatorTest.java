/**
 * 
 */
package com.javaoopadv.calculator;

/**
 * @author ccomstock
 *
 */
public class CalculatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator calc1 = new Calculator();
		calc1.setDebugState(true);
		calc1.performOperation(10.5);
		calc1.performOperation("+");
		calc1.performOperation(5.2);
		calc1.performOperation("*");
		calc1.performOperation(10);
		calc1.performOperation("=");
		System.out.println(calc1.getResult());

		calc1.performOperation(5.1);
		calc1.performOperation("+");
		calc1.performOperation(2.5);
		calc1.performOperation("*");
		calc1.performOperation(10);
		calc1.performOperation("-");
		calc1.performOperation(5);
		calc1.performOperation("/");
		calc1.performOperation(2);
		calc1.performOperation("=");
		System.out.println(calc1.getResult());
		
	}

}
