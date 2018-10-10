package com.revature.Connection.Bank;

public class UserInfo {
	private String fname;
	private String lname;
	private String uname;
	private int age;
	private String email;
	private int phone;	
	private String password;
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(String fname, String lname, String uname, int age, String email, int phone, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfo [fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", age=" + age + ", email="
				+ email + ", phone=" + phone + ", password=" + password + "]";
	}



}
