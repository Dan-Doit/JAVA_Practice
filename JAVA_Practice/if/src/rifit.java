import java.util.Scanner;

public class rifit {
	public static void main(String[] args) {
		
		
System.out.println("������ �Է��� �ּ���.");
Scanner point = new Scanner(System.in);
int po = point.nextInt();

switch (po) {
case 90:
case 100:  //���̽� ���� 2�� ����Ͽ� 90�̰ų� 100�ϰ�� �Ѵ� ��Ÿ��
System.out.println("��");
break;
case 80:
System.out.println("��");
break;
case 70:
System.out.println("��");
break;
case 60:
break;

default:
System.out.println("�ٽ� �õ��ϼ���");
break;
}

point.close();
		
	}

}
