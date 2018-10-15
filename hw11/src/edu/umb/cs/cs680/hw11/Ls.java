/**
 * 
 */
package edu.umb.cs.cs680.hw11;

/**
 * @author Karthik.Prasad001
 *
 */
public class Ls implements Command {

	private FileSystem fs;

	/**
	 * 
	 */
	public Ls(FileSystem fs) 
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
		for (FSElement fe : fs.getChildren())
			System.out.println(fe.getName()+"-----------"+fe.getClass().getName());

	}
	
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		//System.out.println("Reached here 1");
		buffer.append("$ ls "+this.fs.getCurrent().getName()+"\n\r");
		//System.out.println("Reached here after");
		return buffer.toString();
	}

}
