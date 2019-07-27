package com.rosspatil;

public class UserInfo {
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String dob;
	private String mobile;
	private String password;
	private byte[] image=new byte[500000];
	
	
	
	
	public UserInfo(String firstName, String lastName, String emailId, String dob, String mobile, String password,
			byte[] image) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.mobile = mobile;
		this.password = password;
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserInfo [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", mobile="
				+ mobile + ", password=" + password + "]";
	}
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String firstName, String lastName, String emailId, String dob, String mobile, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.mobile = mobile;
		this.password = password;
	}
	
	

}
