import java.util.jar.Attributes.Name;

public abstract class AabstractClass{
	
	String n;
	String b;
	int w;
	int d;
	
	public AabstractClass(String n, String b, int w, int d) {
		System.out.println("aabstractClass Contractor");
	}
	
	public void setInfo(String n, String b, int w, int d) {
		this.n = n;
		this.b = b;
		this.w = w;
		this.d = d;
	}
	public void nameInfo() {
		System.out.printf("������ �̸��� %s �Դϴ�.\n" ,this.n);
	}
	public void bankInfo() {
		System.out.printf("������ ������ %s �Դϴ�.\n" , this.b);
	}
	public abstract void wiInfo();
	
	public abstract void diInfo();
	
	
	
	
	
	
}
