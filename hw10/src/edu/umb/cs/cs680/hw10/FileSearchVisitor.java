
package edu.umb.cs.cs680.hw10;

import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class FileSearchVisitor extends FSVisitor {

	private String extension;
	private ArrayList<File> foundFiles;
	
	public FileSearchVisitor (String extension) 
	{
		// TODO Auto-generated constructor stub
		this.extension=extension;
		foundFiles =new ArrayList<File>();
	}

	
	public void visit(Link link)
	{
		return;
	}

	public void visit(File file) 
	{
		if(file.getName().contains(this.extension)){
			this.foundFiles.add(file);
		}
	}
	
	public void visit(Directory directory)
	{
		return;
	}
	
	public ArrayList<File> getFoundFiles()
	{
		return this.foundFiles;

	}

}
