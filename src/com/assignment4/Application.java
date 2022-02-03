package com.assignment4;

import java.io.IOException;
import java.util.Scanner;

public class Application {
	String userInputUserName = "";
	String userInputPassWord = "";
	String userOptionInput = "";
	
	public int loginAttempts = 0;
	Scanner scanner = new Scanner(System.in);
	
	public void login(User[] users, Application application, WritingFiles writingFiles,  UserService userService) throws IOException {
		 
			for (int i = 0; i < 5; i++)	{
			// Asking for users inputs	
			System.out.println("Enter your email: ");
			userInputUserName = scanner.next();
			System.out.println("Enter your password: ");
			userInputPassWord = scanner.next();
			
			// Method to validate users and give options
			User verifyUser = userService.findUser(userInputUserName, userInputPassWord);
			
			if (verifyUser != null) {
				System.out.println("Welcome: " + verifyUser.getName());
				
				User userLoggedIn = verifyUser;
				
				checkForRole(writingFiles, application, users, userLoggedIn, verifyUser, userService);
				
				break;
			} 
			if(verifyUser == null && i > 3){
				
				System.out.println("Too many failed login attempts, you are now locked out.");
				break;
			}
			if (verifyUser == null){
				System.out.println("Invalid login, please try again.");
				
			}
			
	}		
			
			
	}
	
// vvv This checks for the users role vvv
 
	public void checkForRole (WritingFiles writingFiles, Application application, User[] users, User userLoggedIn,User user, UserService userService) throws IOException{
	if (user != null && user.getRole().equals("super_user")) {
		optionsForSuperUser(writingFiles, application, users, userLoggedIn, user, userService);
	}
	
	if (user != null && user.getRole().equals("normal_user")) {
		optionsForNormalUser(writingFiles, application, users, userLoggedIn, user, userService);
	}
	
// vvv Options depending on the users role vvv
	
	}
	public void optionsForSuperUser(WritingFiles writingFiles, Application application, User[] users, User userLoggedIn, User user,UserService userService) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------");
		System.out.println("Super user: ");
		System.out.println("Please choose from the following options\n (0) Log in as another user\n (1) Update username\n (2) Update password\n (3) Update name\n (4) Exit");
		userOptionInput = scanner.next();
		
		if (userOptionInput.equals("0")) {
			new Application().optionZero(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("1")) {
			new Application().optionOne(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("2")) {
			new Application().optionTwo(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("3")) {
			new Application().optionThree(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("4")) {
			new Application().optionFour();
		}
		scanner.close();
	}
	
	public void optionsForNormalUser(WritingFiles writingFiles, Application application, User[] users, User userLoggedIn, User user, UserService userService) throws IOException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----------------------");
		System.out.println("Normal user: ");
		System.out.println("Please choose from the following options\n (1) Update username\n (2) Update password\n (3) Update name\n (4) Exit");
		userOptionInput = scanner.next();
		
		if (userOptionInput.equals("1")) {
			new Application().optionOne(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("2")) {
			new Application().optionTwo(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("3")) {
			new Application().optionThree(writingFiles, application, users, userLoggedIn, user, userService);
		}
		if (userOptionInput.equals("4")) {
			new Application().optionFour();
		}
		
// vvv All of the four options once logged in vvv 		
		
	}
	public void optionZero(WritingFiles writingFiles, Application application, User[] users, User userLoggedIn, User user, UserService userService) throws IOException {
		String switchToAnotherUser = "";
		System.out.println("Which user would you like to login as?(Type in a valid username)");
		switchToAnotherUser = scanner.next();
		User switchedUser = userService.findUserNameAndSwitch(switchToAnotherUser);
		user = switchedUser;
		System.out.println("Switched to: " + user.getUserName());
		checkForRole(writingFiles, application, users, userLoggedIn, user, userService);
	}
	
	public void optionOne(WritingFiles writingFiles, Application application, User[] users, User userLoggedIn, User user, UserService userService) throws IOException {
		String newUserName = "";
		System.out.println("Please type in your new username: ");
		newUserName = scanner.next();
		user.setUserName(newUserName);
		System.out.println("Your new username is: " + newUserName);
		writingFiles.fileWrite(users, userService);
		checkForRole(writingFiles, application, users, userLoggedIn, user, userService);
	}
	
	public void optionTwo(WritingFiles writingFiles, Application application, User[] users, User userLoggedIn, User user, UserService userService) throws IOException {
		String newPassWord = "";
		System.out.println("Please type in your new password: ");
		newPassWord = scanner.next();
		user.setPassWord(newPassWord);
		System.out.println("Your new passoword is: " + user.getPassWord());
		writingFiles.fileWrite(users, userService); 
		checkForRole(writingFiles, application, users, userLoggedIn, user, userService);
	}
	
	public void optionThree(WritingFiles writingFiles, Application application, User[] users, User userLoggedIn, User user, UserService userService) throws IOException {
		
		String newName = "";
		System.out.println("Please type in your new name: ");
		newName = scanner.next();
		user.setName(newName);
		System.out.println("Welcome: " + newName);
		checkForRole(writingFiles, application, users, userLoggedIn, user, userService);
	}
	
	public void optionFour() {
		System.out.println("Exited");
		
	}
}
		
	

	

