package com.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;


public class FileService {
	
	public User[] readUsersFromFile() {
		
		
		String line = "";
		User[] users = new User[20];
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("users.txt"));
			int i = 0;
			while((line = fileReader.readLine())!= null) {
				
			//This also prints users -->	System.out.println(line);
				String[] array = line.split(",");
				users[i] = new User(array[0], array[1], array[2], array[3]);
			//This prints users in a nice form -->	System.out.println(users[i]);
				i++;
			}
		//	System.out.println("Users printed");
		} catch (FileNotFoundException e) {
			System.out.println("oops");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	
	
}