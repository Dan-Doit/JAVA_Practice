package testPjt;

public class test1 {
	
	public String pen; 
	public String pencle;
	public int price;
	
public test1() {
	System.out.println("�̰��� ������ ��ɰ� �����Դϴ�.");
	}

public void run() {
	System.out.println("---run---");	
}
public void stop() {
	System.out.println("---stop---");
}	
public void info() {
	System.out.println("---information---");
	System.out.println("the pen color is " + pen);
	System.out.println("the pencle color is " + pencle);
	System.out.printf("the price is %d ��" , price);
}	
}
