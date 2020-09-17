package controllor.calculator;

import java.util.Scanner;

import operator.calculator.Operation;
import frontend.calculator.FrontEnd;
public class controller {

	public static void main(String[] args) {
		
		/*Class Call
		 * [DataType] [StackVariable] = new [Constructor]
		 */
		Operation op = new Operation(10, 10000);
		FrontEnd fe = new FrontEnd();
		
		fe.sum();

//		System.out.print("결과값 : " + op.plus(2, 5) +"\n");
//		System.out.print("결과값 : " + op.minus(2, 5) +"\n");
//		System.out.print("결과값 : " + op.product(2, 5) +"\n");
//		System.out.print("결과값 : " + op.devide(2, 5) +"\n");
	}
}
  