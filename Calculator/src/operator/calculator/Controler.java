package operator.calculator;

import operator.calculator.Operator;
public class Controler {

   public static void main(String[] args) {
      Operator op = new Operator();
      System.out.println("����� : " + op.plus(2, 5));
      System.out.println("����� : " + op.minus(2, 5));
      System.out.println("����� : " + op.product(2, 5));
      System.out.println("����� : " + op.divide(2, 5));

   }
}


// operation op; //Declation(����)
// op = new operation; // Allocation(�Ҵ�)