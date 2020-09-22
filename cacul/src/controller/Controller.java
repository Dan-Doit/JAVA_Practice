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
		print("\n\t\t       �Է����ּ���\n\n                0.���               1.����");
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
										(arr[1].equals("3"))?" �� ":" �� " )+ arr[2] + " = " + result);
			
			print("�ٽ� ����Ͻ÷��� y�� �����ּ���.");
			isContinue = (input().equals("n")) ? false : true;
		} 
	}

	private String[] menus() {
		String[] menus = new String[3];
		menus[0] = "\n���ڸ� �Է��ϼ��� : ";
		menus[1] = "\n1. ���ϱ�    2. ����\n3.���ϱ�   4.������\n �Է� : ";
		menus[2] = "\n���ڸ� �Է��ϼ��� : ";

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
