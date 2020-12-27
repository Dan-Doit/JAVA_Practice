package tttttt;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int star = 0;
		while(true) {
			System.out.println("홀수를 입력해주세요");
			System.out.print("입력숫자 >> ");
			star = sc.nextInt();
			if(star%2 == 1) break;
		}
		
		for (int i = star; i > 0; i=i-2) {
			// 공백
			for (int j = (i-1)/2; j > 0; j--) {
				System.out.print(" ");
			}
			// 별
			for (int j = star - (i-1); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i = 2; i < star; i=i+2) {
			// 공백
			for (int j = (i/2); j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = star-i; j > 0; j--) {
				System.out.print("*");
			}
			// 별

			System.out.println();
		}
		
	}

}
