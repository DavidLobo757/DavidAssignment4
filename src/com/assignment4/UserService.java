package com.assignment4;

import java.util.Arrays;

public class UserService {
	
	private User[] users = null;
	
	public UserService() {
		users = new FileService().readUsersFromFile();
	}
	
	public User findUser(String userInputUserName, String userInputPassWord) {
		for (User user : users) {

			if (userInputUserName.equalsIgnoreCase(user.getUserName()) & userInputPassWord.equals(user.getPassWord())) {
				return user;
			} 

		}
		return null;
	}
	
	public User findUserNameAndSwitch(String switchToAnotherUser) {
		for (User user: users) {
			if(switchToAnotherUser.equalsIgnoreCase(user.getUserName())) {
				return user;
			}
		}
		return null;
	}

	
	public User[] printUsers() {
		Arrays.sort(users);
		for (User user : users) {
			System.out.println(user);
		} return users;
	}
	
	public String getUser(User user) {
		return user.getUserName() + "," + user.getPassWord() + "," + user.getName() + "," + user.getRole() + "\n";
	}
}
