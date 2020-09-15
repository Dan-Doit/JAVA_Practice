package Test2;

public class infoPP {
	
	private String ID;
	private int Password;
	private static int repass;
	
	public void infoPP(String i, int p) {
	System.out.println("-----information of people");
	this.ID = i;
	this.Password = p;
	repass = Password;
	}
	
	public void getinfo() {
		System.out.println("your ID is " + ID);
		System.out.println("your Password is  "+Password);
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		if (repass == password) {
			this.Password = repass; 
			System.out.println("비밀번호가 같습니다. 다시 해주세요.");
								}  
		else {
		Password = password;	
			 } 
		
	}
	
	
}
