package entity;

public class User {
	private String userName;
	private String password;
	private String topImage;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTopImage() {
		return topImage;
	}
	public void setTopImage(String topImage) {
		this.topImage = topImage;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", topImage=" + topImage + "]";
	}
	
}
