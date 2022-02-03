package com.assignment4;

public class User implements Comparable<User>{
	private String userName;
	private String passWord;
	private String name;
	private String role;
	
	public User(String username, String password, String name, String role) {
		this.userName = username;
		this.passWord = password;
		this.name = name;
		this.role = role;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", name=" + name + ", role=" + role + "]";
	}

	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

		
		@Override
		public int compareTo(User that) {
			int compareIntC = that.getRole().compareTo(this.getRole());
			if (compareIntC == 0) {
				compareIntC = this.getUserName().compareTo(that.getUserName());
			
		} return compareIntC;	
		
		}
}
