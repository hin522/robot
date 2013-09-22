package com.hin.robot.io;

import java.util.List;

import com.hin.robot.model.Command;


public interface CommandReader {

	List<Command> readCommands();
}
