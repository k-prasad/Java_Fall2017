/**
 * 
 */
package edu.umb.cs.cs680.hw11;

/**
 * @author Karthik.Prasad001
 *
 */
public class Rmdir implements Command {

	private String dir_file_name;
	private FileSystem fs;

	public Rmdir(FileSystem fs,String name) 
	{
		// TODO Auto-generated constructor stub
		this.fs = fs;
		this.dir_file_name=name;
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		fs.deleteChild(this.dir_file_name);

	}
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ rmdir "+this.dir_file_name+"\n");
		return buffer.toString();
	}

}
