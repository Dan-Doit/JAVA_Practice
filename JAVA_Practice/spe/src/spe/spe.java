package spe;

public class spe {
	
	public static void main(String[] args) {
		
		//Ư������ ����
		
		/*
		 * �̰Ŵ� �̷��� �ؾ�
		 * ������ ����
		 */
		
		//���� ��� ��, ����, ��������ǥ, ū����ǥ, ����������                           ln�޼ҵ�� �׳� ����ó����
		System.out.println("good\tmorning");
		System.out.println("good\n\nmorning");
		System.out.println("good \'morning\'");
		System.out.println("\"good\" morning");
		System.out.println("\\\\good \\morning");
		
		/*������ �Ϲݹ��ڰ� �ƴ� ���Ĺ��ڿ� ���� �˾ƺ�����
		 * printf("�ȿ�") f=format ��                                                           F�żҵ�� /n�� �����ָ� ���� ó�� ������
		 * %d 10���� %o 8���� %x 16���� %c ���� %s ���ڿ� %f �Ǽ� 
		 */
		
		// �̰� ���� ��縸�鶧 �ɸ��� �̸����� �ϸ� ��������
		
		//���� 10����
		System.out.printf("������ �µ��� %d�� �Դϴ�.\n",27);
		int num;
		num = 30;
		System.out.printf("������ �µ��� %d�� �Դϴ�.\n",num);
		//����
		char ch;
		ch = 'A';
		System.out.printf("���� ������ \'%c\' ����..\n",ch);
		//���ڿ�
		String str = "��������";
		System.out.printf("���� ������ %s ��..\n",str);
		
		//�Ǽ�
		float fl = 1.22f;
		double dou = 1.440003d;
		System.out.printf("���� �Ǽ��� %f �� %f �Դϴ�.\n",fl,dou);
		
		//�����ϱ� 10¥�� �� ĭ�� ���� ������ ��� ��������, �Ҽ��� ���ѵ� ����
		System.out.printf("%10f\n",dou);
		System.out.printf("%.2f\n",dou);
	
		//��� ������ �غ��� +,-,*,/,%(������)
		int x = 37;
		int y = 5;
		
		System.out.println("37 �� 5 �� ���� " +(x+y) +"�̰� ���� ���� ���� " +(x/y) +"�̰� ��������" +(x%y) +" �Դϴ�.");
		//���׿��� <,>,<=,>=,!=(�����ʴ�),==(����) �� �� ���� ���� ture or false �� ���̳��´� 
		System.out.println("x �� y�� ���ڴ� ���� �ʾƿ� ������ != ������ " +(x!=y) +" ���ϴ�?");
		
		int xx = 10;
		System.out.println("x ++�� = 37 ->"+ ++x); // x+1�� ���� --x �� x-1�� ����
		System.out.println("x =" + x++); // 1�� �������� ����� �״�� �޸𸮻󿡴� 1�� ������ ���������� ������ ���� ����
		System.out.println("x =" + x); //���Ѱ� ������ ����
	
		//�� ���� && || ! ������� AND OR NOT�̵�
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println("b1 b2 ��� ���̸� �� ������ �ٸ��Ƿ�" +(b1&&b2));
		System.out.println("b1 b2 ���߿� �ϳ��� ���̸� " +(b1||b2));
		System.out.println("b1 ���� b2 ���� ��Ŵ\t" +!b1 +"\t" +!b2); //������ ������ �� Ʈ��� Ʈ��� !b2 ������ ������ �׷� Ʈ��
		
		//���� ���� ���ǽ� ? ��1 : ��2 Ʈ��� ��1 �����̸� ��2 ���
		x=10;
		y=20;
		int result = 0;
		result = (x > y) ? 100 : 200;
		System.out.println("result = " +result); //x�� y���� ũ�� 100�����
		result = (x < y) ? 100 : 200;
		System.out.println("result = " +result);
		
		/* �߿�!!!! �迭!
		 * �迭�� ��ȣ�� []�̰� ������ int [] arr1 = new int[5]
		 * ��� �ϸ�    ������ ������ �迭 arr1 ���� = ���ο� ������ 5���̴� 0~4
		 */
		int [] arr1 = new int[3];
		arr1[0] = 100;
		arr1[1] = 200;
		arr1[2] = 300;
		
		System.out.println(arr1[0] +"\t" +arr1[1] +"\t" +arr1[2] +"\t");
		
		//������ �ʹ� ���� ������Ƿ� �ѹ濡 ����� ����� �ִ�.
		int[] arr2 = {10, 20, 30};
		System.out.println(arr2[0] +"\t" + arr2[1] +"\t" + arr2[2]);
		 
		
	}
}
