package com.assignment4;

import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException  {
		
		
		User[] users = null;
		
		WritingFiles writingFiles = new WritingFiles();
		UserService userService = new UserService();
		Application application = new Application();
		users = userService.printUsers();
		application.login(users, application, writingFiles, userService);
		
	}
}
