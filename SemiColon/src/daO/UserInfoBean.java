package daO;

public class UserInfoBean {
	
	@Override
	public String toString() {
		return "UserInfoBean [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userLevel=" + userLevel + ", userAdd=" + userAdd + ", userPhone=" + userPhone + ", userDate="
				+ userDate + ", state=" + state + "]";
	}
	private String userId;
	private String userPassword;
	private String userName;
	private String userLevel;
	private String userAdd;
	private String userPhone;
	private String userDate;
	private boolean state;
	
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	
	
	
}
