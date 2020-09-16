package operator.calculator;

import operator.calculator.Operator;
public class Controler {

   public static void main(String[] args) {
      Operator op = new Operator();
      System.out.println("결과값 : " + op.plus(2, 5));
      System.out.println("결과값 : " + op.minus(2, 5));
      System.out.println("결과값 : " + op.product(2, 5));
      System.out.println("결과값 : " + op.divide(2, 5));

   }
}


// operation op; //Declation(선언)
// op = new operation; // Allocation(할당)