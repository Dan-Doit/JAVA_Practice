import java.util.Scanner;

public class ifdetail {
	public static void main(String[] args) {
		// if ���� ����̾簡 ���α׷��� �԰���!!!!! �׸��� scanner�� �� close �������
		int[] num = new int[2];
				Scanner scan = new Scanner(System.in);
				System.out.println("����1�� �Է��� �ּ���");
				num[0] = scan.nextInt();
				
				System.out.println("����2�� �Է��� �ּ���");
				num[1] = scan.nextInt();
				
				if (num[0] > num[1]) {
					System.out.printf("%d�� %d ���� Ů�ϴ�.\n",num[0],num[1]);
			     	}
					else if (num[0] < num[1]) {
						System.out.printf("%d�� %d ���� �۽��ϴ�.\n",num[0],num[1]);
					}
						else {
							System.out.printf("%d �� %d�� �����ϴ�.\n",num[0],num[1]);
}			
					scan.close(); 
					//�̰� ��ĵ���� �� �ݾ����� ����������

							
	}
}
