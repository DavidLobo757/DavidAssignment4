package com.assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WritingFiles {
	
	
	public User fileWrite(User[] users, UserService userService) throws IOException {
		BufferedWriter writer = null;
		
		
		try {
			writer = new BufferedWriter(new FileWriter("users.txt"));
			
			Arrays.sort(users);
			for (User user: users) {
			
				writer.write(userService.getUser(user));
				System.out.println(user);	
				
			} 
			
			} catch(IOException e) {
				e.printStackTrace();
				
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}
		return null;
	}
}
