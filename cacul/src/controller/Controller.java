package controller;

import java.util.Scanner;
import operator.Operator;

public class Controller {

	public Controller() {
		entrance(title(),menus());
	}

	private void entrance(String title, String[] menus) {
		boolean isContinue = true;
		String[] arr = new String[3];
		String temp = "";
		int result;
		
		print(title);
		print("___________________________________________________");
		print("\n\t\t       입력해주세요\n\n                0.취소               1.실행");
		print("___________________________________________________");
		isContinue = (input().equals("1"))? true:false;
		
		while(isContinue) {
			for (int i = 0; i < menus.length; i++) {
				print(title);
				print(menus[i]);
				arr[i] = input();
			}
			Operator op = new Operator();
			result = op.Judgment(arr);
			print("\n" + arr[0] + ((arr[1].equals(" 1 "))?"+":
									(arr[1].equals("2"))?" - ":
										(arr[1].equals("3"))?" × ":" ÷ " )+ arr[2] + " = " + result);
			
			print("다시 계산하시려면 y를 눌러주세요.");
			isContinue = (input().equals("n")) ? false : true;
		} 
	}

	private String[] menus() {
		String[] menus = new String[3];
		menus[0] = "\n숫자를 입력하세요 : ";
		menus[1] = "\n1. 더하기    2. 빼기\n3.곱하기   4.나누기\n 입력 : ";
		menus[2] = "\n숫자를 입력하세요 : ";

		return menus;
	}

	private String title() {

		StringBuilder title = new StringBuilder();
		title.append("\n\n\n");
		title.append("***************************************************\n");
		title.append("\n");
		title.append("\n");
		title.append("  Project to make Caculator At the first time\n");
		title.append("\n");
		title.append("               projected by Dan\n");
		title.append("");
		title.append("                                 now on Version 1.0\n");
		title.append("\n");
		title.append("\n");
		title.append("***************************************************\n");
		return title.toString();
	}

	private void print(String text) {
		System.out.println(text);

	}

	private String input() {
		Scanner sc = new Scanner(System.in);
		return sc.next();

	}
}
