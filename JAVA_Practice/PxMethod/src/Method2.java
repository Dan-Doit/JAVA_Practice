import java.util.Scanner;

public class Method2 {
	
	public int cool;
	public int hot;
	public String okay;
	
	public void Method2() {
		System.out.println("this method2 welcome");
		}
	
	public void setinfo() {
		System.out.println("we need simple info from you");
		
		Scanner sca = new Scanner(System.in);
		System.out.println("cool temperature ");
		cool = sca.nextInt();
		System.out.println("hot temperature ");
		hot = sca.nextInt();
		System.out.println("do you yes? or no? ");
		okay = sca.next();
		
	}
	
	public void getinfo() {
		
		System.out.println("this is what I got");
		
		System.out.println("cool temperature is " +cool);
		System.out.println("hot temperature is " +hot);
		System.out.println("your answer was " +okay);
	}
}
