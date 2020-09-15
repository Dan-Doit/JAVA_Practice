
public class MainClass {
	public static void main(String[] args) {
		
		Method1 mt1 = new Method1();
		
		mt1.setInfo("조단", 3, 100);
		
		mt1.getInfo();
		
		mt1.name = "조단";
		mt1.classes = 2;
		mt1.score = 10;
		
		mt1.getInfo();
		
		Method2 mt2 = new Method2();
		
		mt2.setinfo();
		
		mt2.getinfo();
	}
}
