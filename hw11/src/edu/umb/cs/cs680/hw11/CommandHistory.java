/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class CommandHistory 
{
	ArrayList<Command> commands;

	public CommandHistory() {
		this.commands = new ArrayList<Command>();
	}

	public void push(Command command) {
		commands.add(command);
	}

	public Command pop() {
		if (commands.size() > 0) {
			return commands.get(commands.size()-1);
		}
		return null;
	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("------------------------\n");
		for(Command c : this.commands)
		{
			buffer.append(c);
		}
		buffer.append("------------------------\n");
		return buffer.toString();
	}
	

}
