import java.security.PrivateKey;

public class Method1 {
	

	public String name;
	public int classes;
	public int score;
	
public void Method1() {
	System.out.println("----------Method1 test1----------");
}

	public void setInfo(String a, int b, int c) {
		name = a;
		classes = b;
		score = c;
	}

	public void getInfo() {
	System.out.println("-----setting now------");	
	
	System.out.println("name = " + name);
	System.out.println("classes = " + classes);
	System.out.println("score = " + score);
	}
	
	private void mma(){
	System.out.println("this is secret only can use this method");
	}
}
		