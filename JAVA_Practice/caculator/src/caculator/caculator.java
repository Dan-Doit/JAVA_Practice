package caculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class caculator {

		public static void main(String[] args) {
		
			String[] name = {"����", "����", "ģ��", "����", "ģ��"};
			int[] score = new int[5];
			Scanner scanner = new Scanner(System.in); 
			
			System.out.printf("%s�� �ٳѱ� ���ڸ� �Է��Ͻÿ�\n",name[0]);
			score[0] = scanner.nextInt();
			
			System.out.printf("%s�� �ٳѱ� ���ڸ� �Է��Ͻÿ�\n",name[1]);
			score[1] = scanner.nextInt();
			
			System.out.printf("%s�� �ٳѱ� ���ڸ� �Է��Ͻÿ�\n",name[2]);
			score[2] = scanner.nextInt();
			
			System.out.printf("%s�� �ٳѱ� ���ڸ� �Է��Ͻÿ�\n",name[3]);
			score[3] = scanner.nextInt();
			
			System.out.printf("%s�� �ٳѱ� ���ڸ� �Է��Ͻÿ�\n",name[4]);
			score[4] = scanner.nextInt();
			 
			System.out.printf("%s�� ������ = %.2f\n",name[0], (double)score[0]);
			System.out.printf("%s�� ������ = %.2f\n",name[1], (double)score[1]);
			System.out.printf("%s�� ������ = %.2f\n",name[2], (double)score[2]);
			System.out.printf("%s�� ������ = %.2f\n",name[3], (double)score[3]);
			System.out.printf("%s�� ������ = %.2f\n",name[4], (double)score[4]);
		    int x = 0 ;
		    int ev = 0;
		    ev = (score[0] > 0) ? (ev+1) : ev;
		    ev = (score[1] > 0) ? (ev+1) : ev;
		    ev = (score[2] > 0) ? (ev+1) : ev;
		    ev = (score[3] > 0) ? (ev+1) : ev;
		    ev = (score[4] > 0) ? (ev+1) : ev;
		    
			double eva = (score[0] + score[1] + score[2] + score[3] + score[4])/ev;
			System.out.printf("����� = %.2f", eva);
			
			
			int arr1[] = { 10, 20, 30, 40, 50 };
			int arr2[] = null;
			int arr3[] = null;
			//�迭�� ����(length) ���(array.tostring) ��� ����(array.copyof(���,����)) �׸��� �ּ����̸� �߿��ϰ� ����!!
			System.out.println("arr1 �迭�� ���� length��? \t" + arr1.length);
			System.out.println("arr1 �迭�� ��Ҵ�? \t" + Arrays.toString(arr1));  //tostring(int[])�̰ŷ� �ؾ� ���ڶ�
			arr2 = Arrays.copyOf(arr1, arr1.length);
			arr3 = arr1;
			
			System.out.println(arr1);
			System.out.println(arr2);
			System.out.println(arr3);
			
		}
		
}