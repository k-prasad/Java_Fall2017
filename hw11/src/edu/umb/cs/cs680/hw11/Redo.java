/**
 * 
 */
package edu.umb.cs.cs680.hw11;

/**
 * @author Karthik.Prasad001
 *
 */
public class Redo implements Command {

	private CommandHistory ch;
	private Command lastCommand;
	
	public Redo(CommandHistory ch) 
	{
		// TODO Auto-generated constructor stub
		this.ch = ch;
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		lastCommand=ch.pop();
		lastCommand.execute();

	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ redo "+lastCommand.getClass().getName()+"\n\r");
		return buffer.toString();
	}

}
