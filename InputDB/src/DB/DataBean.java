package DB;

public class DataBean {
	
	private String id;
	private String pw;
	private String result;
	private boolean aaa;
	
	public boolean isAaa() {
		return aaa;
	}
	public void setAaa(boolean aaa) {
		this.aaa = aaa;
	}
	public String getId() {
		return id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	

}
