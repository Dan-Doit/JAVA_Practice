
public class OverrideClass extends AabstractClass {


	public OverrideClass(String n , String b, int w, int d) {
	super(n,b,w,d);	
	}
			
	
	@Override
	public void wiInfo() {
		System.out.printf("찾으실 돈은 %d 입니다.\n" , super.w);
		}

	@Override
	public void diInfo() {
		System.out.printf("예금은 %d 남아있습니다.\n" , super.d);
		
	}
	
	
	
}
