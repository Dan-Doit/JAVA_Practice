import java.util.Scanner;

public class ifdetail {
	public static void main(String[] args) {
		// if 절로 수우미양가 프로그램도 쌉가능!!!!! 그리고 scanner는 꼭 close 해줘야함
		int[] num = new int[2];
				Scanner scan = new Scanner(System.in);
				System.out.println("숫자1을 입력해 주세요");
				num[0] = scan.nextInt();
				
				System.out.println("숫자2를 입력해 주세요");
				num[1] = scan.nextInt();
				
				if (num[0] > num[1]) {
					System.out.printf("%d가 %d 보다 큽니다.\n",num[0],num[1]);
			     	}
					else if (num[0] < num[1]) {
						System.out.printf("%d가 %d 보다 작습니다.\n",num[0],num[1]);
					}
						else {
							System.out.printf("%d 는 %d와 같습니다.\n",num[0],num[1]);
}			
					scan.close(); 
					//이거 스캔쓰면 꼭 닫아주자 습관들이자

							
	}
}
