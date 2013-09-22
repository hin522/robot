package com.hin.robot.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hin.robot.model.Command;

public class FileCommandReader implements CommandReader {

	private String fileName;

	public FileCommandReader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public List<Command> readCommands() {
		BufferedReader reader = null;
		List<Command> commands = new ArrayList<Command>();
		
		try {
			String input;
			reader = new BufferedReader(new FileReader(fileName));

			while ((input = reader.readLine()) != null) {
				commands.add(new Command(input));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return commands;
	}

}
