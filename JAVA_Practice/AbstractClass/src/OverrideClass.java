
public class OverrideClass extends AabstractClass {


	public OverrideClass(String n , String b, int w, int d) {
	super(n,b,w,d);	
	}
			
	
	@Override
	public void wiInfo() {
		System.out.printf("ã���� ���� %d �Դϴ�.\n" , super.w);
		}

	@Override
	public void diInfo() {
		System.out.printf("������ %d �����ֽ��ϴ�.\n" , super.d);
		
	}
	
	
	
}
