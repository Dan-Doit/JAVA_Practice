package testPjt;

public class test1 {
	
	public String pen; 
	public String pencle;
	public int price;
	
public test1() {
	System.out.println("이것은 필통의 기능과 가격입니다.");
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
	System.out.printf("the price is %d 원" , price);
}	
}
