package frontend;

import java.util.Scanner;

public class FrontEnd {

	private String title;
	
	public FrontEnd() {
		this.title = title();
		this.entrance();
	}
	
	private void entrance() {
		print(this.title);
		print("___________________________________________________");
		print("\n\t\t       �Է����ּ���\n\n                0.���               1.����");
		print("___________________________________________________");
		String text;
		text = input();
		
		if (text.equals("1")) {
			System.out.println("����Ǿ����ϴ�.");	
		}else if(text.equals("0")){
			System.out.println("����Ǿ����ϴ�.");
		}else {
			System.out.println("�߸��Է��Ͽ����ϴ�.");
		}
	}
	
	private String input() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
		
	}
	
	private String title() {
		
		StringBuilder title = new StringBuilder();
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
}
