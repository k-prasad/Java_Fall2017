
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

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
	public Directory current;
	
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
	
	public Directory getRoot() {
		return this.root;
	}
	
	public void deleteChild(String filelementName) {
		FSElement fe = null;
		for (FSElement element : this.current.getChildren()) {
			if (element.getName().equals(filelementName)) {
				fe = element;
				break;
			}
		}
		if (fe != null) {
			this.current.getChildren().remove(fe);
		}
	}

	public void setRoot(Directory dir) {
		this.root = dir;
	}

	public Directory getCurrent() {
		return this.current;
	}

	public void setCurrent(Directory dir) {
		this.current = dir;
	}

	public ArrayList<FSElement> getChildren() {
		return this.current.getChildren();
	}

}
