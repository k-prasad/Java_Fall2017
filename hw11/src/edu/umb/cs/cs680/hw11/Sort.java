/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author Karthik.Prasad001
 *
 */
public class Sort implements Command {

	private FileSystem fs;
	private Comparator<FSElement> comparator;
	
	public Sort(FileSystem fs,Comparator<FSElement> comparator) 
	{
		// TODO Auto-generated constructor stub
		this.fs=fs;
		this.comparator = comparator;
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		Collections.sort(fs.getChildren(), this.comparator);
		for(FSElement fe : fs.getChildren())
			System.out.println(fe.getName());

	}

}
