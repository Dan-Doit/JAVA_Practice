import java.util.Scanner;

public class rifit {
	public static void main(String[] args) {
		
		
System.out.println("점수를 입력해 주세요.");
Scanner point = new Scanner(System.in);
int po = point.nextInt();

switch (po) {
case 90:
case 100:  //케이스 문을 2번 사용하여 90이거나 100일경우 둘다 나타냄
System.out.println("수");
break;
case 80:
System.out.println("우");
break;
case 70:
System.out.println("미");
break;
case 60:
break;

default:
System.out.println("다시 시도하세요");
break;
}

point.close();
		
	}

}
