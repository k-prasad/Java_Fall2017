/**
 * 
 */
package edu.umb.cs.cs680.hw11;

/**
 * @author Karthik.Prasad001
 *
 */
public class History implements Command {

	private CommandHistory ch;
	/**
	 * 
	 */
	public History(CommandHistory ch) 
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
		System.out.println(ch);

	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Command line: History \n");
		return buffer.toString();
	}

}
