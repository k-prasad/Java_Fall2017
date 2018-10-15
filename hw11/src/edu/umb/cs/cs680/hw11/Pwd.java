/**
 * 
 */
package edu.umb.cs.cs680.hw11;

/**
 * @author Karthik.Prasad001
 *
 */
public class Pwd implements Command {

	private FileSystem fs;

	public Pwd(FileSystem fs) 
	{
		// TODO Auto-generated constructor stub
		this.fs = fs;
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		System.out.println(fs.getCurrent().toString());

	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ pwd "+this.fs.getCurrent().getName()+"\n\r");
		return buffer.toString();
	}

}
