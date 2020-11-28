package daO;

public class BoardInfoBean {
	
	private String Bo_Userid;
	private int Bo_Num;
	private String Bo_Title;
	private String Bo_Writer;
	private String Bo_Date;
	private String Bo_Content;
	private String Bo_FileName;
	private int Bo_Hits;
	private int Bo_OrderNum;
	
	
	
	@Override
	public String toString() {
		return "BoardInfoBean [Bo_Userid=" + Bo_Userid + ", Bo_Num=" + Bo_Num + ", Bo_Title=" + Bo_Title
				+ ", Bo_Writer=" + Bo_Writer + ", Bo_Date=" + Bo_Date + ", Bo_Content=" + Bo_Content + ", Bo_FileName="
				+ Bo_FileName + ", Bo_Hits=" + Bo_Hits + ", Bo_OrderNum=" + Bo_OrderNum + "]";
	}
	
	public int getBo_Hits() {
		return Bo_Hits;
	}
	public void setBo_Hits(int bo_Hits) {
		Bo_Hits = bo_Hits;
	}
	public String getBo_Userid() {
		return Bo_Userid;
	}
	public void setBo_Userid(String bo_Userid) {
		Bo_Userid = bo_Userid;
	}
	public String getBo_Title() {
		return Bo_Title;
	}
	public void setBo_Title(String bo_Title) {
		Bo_Title = bo_Title;
	}
	public String getBo_Writer() {
		return Bo_Writer;
	}
	public void setBo_Writer(String bo_Writer) {
		Bo_Writer = bo_Writer;
	}
	public String getBo_Date() {
		return Bo_Date;
	}
	public void setBo_Date(String bo_Date) {
		Bo_Date = bo_Date;
	}
	public String getBo_Content() {
		return Bo_Content;
	}
	public void setBo_Content(String bo_Content) {
		Bo_Content = bo_Content;
	}
	public String getBo_FileName() {
		return Bo_FileName;
	}
	public void setBo_FileName(String bo_FimeName) {
		Bo_FileName = bo_FimeName;
	}
	public int getBo_Num() {
		return Bo_Num;
	}
	public void setBo_Num(int bo_Num) {
		Bo_Num = bo_Num;
	}
	public int getBo_OrderNum() {
		return Bo_OrderNum;
	}
	public void setBo_OrderNum(int bo_OrderNum) {
		Bo_OrderNum = bo_OrderNum;
	}


}
