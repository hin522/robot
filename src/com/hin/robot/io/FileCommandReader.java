package com.hin.robot.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hin.robot.model.Command;

public class FileCommandReader implements CommandReader {

	private String fileName;
	private List<Command> commands;

	public FileCommandReader(String fileName) {
		this.fileName = fileName;
		commands = new ArrayList<Command>();
	}
	
	@Override
	public void readCommands() {
		BufferedReader reader = null;
		
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
	}

	public List<Command> getCommands() {
		return commands;
	}

}
