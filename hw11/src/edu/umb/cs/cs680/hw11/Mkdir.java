/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.Date;

/**
 * @author Karthik.Prasad001
 *
 */
public class Mkdir implements Command {

	private FileSystem fs;
	private String dir_file_name;
	
	public Mkdir(FileSystem fs, String name) 
	{
		// TODO Auto-generated constructor stub
		this.fs = fs;
		this.dir_file_name = name;
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		Date date = new Date();
		new Directory(fs.getCurrent(), this.dir_file_name, "", date);

	}
	
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ mkdir "+this.dir_file_name+"\n\r");
		return buffer.toString();
	}

}
