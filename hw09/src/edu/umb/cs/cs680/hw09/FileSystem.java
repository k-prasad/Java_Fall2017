
package edu.umb.cs.cs680.hw09;

/**
 * @author Karthik.Prasad001
 *
 */
public class FileSystem {

	
	public FileSystem() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private static FileSystem i = null;
	public Directory root;
	
	public static FileSystem getFileSystem()
	{
		if(i == null)
		{
			i = new FileSystem();
			return i;
		}
		return i;
	}
	
	public void showAllElements()
	{
		if(this.root!=null)
			System.out.println(this.root);
		else
			System.out.println("File system is Empty");
	}

}
