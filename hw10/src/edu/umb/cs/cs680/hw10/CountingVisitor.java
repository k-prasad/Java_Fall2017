
package edu.umb.cs.cs680.hw10;

/**
 * @author Karthik.Prasad001
 *
 */
public class CountingVisitor extends FSVisitor 
{

	private int dirNum=0;
	private int fileNum=0;
	private int linkNum=0;
	
	public CountingVisitor() 
	{
		// TODO Auto-generated constructor stub
	}
	public void visit(Link link)
	{
		this.linkNum++;
	}

	public void visit(File file)
	{
		this.fileNum++;
	}
	public void visit(Directory directory)
	{
		this.dirNum++;
	}

	public int getDirNum()
	{
		return this.dirNum;

	}

	public int getFileNum()
	{
		return this.fileNum;

	}

	public int getLinkNum()
	{
		return this.linkNum;
	}


}
