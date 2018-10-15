
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Karthik.Prasad001
 *
 */
public class Directory extends FSElement {
	
	ArrayList<FSElement> children;

	public Directory(Directory p, String name, String owner, Date created) 
	{
		super(p, name, owner, created);
		// TODO Auto-generated constructor stub
		this.size = 0;
		children = new ArrayList<FSElement>();
	}
	
	public ArrayList<FSElement> getChildren()
	{
		return this.children;
	}
	
	public boolean isFile() 
	{
		if (this.children.isEmpty()) 
			return true;
		 else 
			return false;
	}

		
	
	public void appendChild(FSElement newChild) 
	{
		Date date = new Date();
		this.children.add(newChild);
		this.lastModified = date;
		if (this.p != null) 
			this.p.lastModified = date;
		
	}
	
	public FSElement getTarget()
	{
		return this;
	}
		
		public int getSize() 
		{

			this.size = 0;
			for(FSElement f:this.children){
				this.size+=f.getSize();
			}
			return this.size;
		}
		
		public String toString() {

			StringBuffer buffer = new StringBuffer();
			buffer.append("-----------------------------------------------  \n");
			buffer.append("Directory: " + this.name + " \n");
			String p = "null";
			if (this.p != null)

				p = this.p.name;
			//int i = 0;
			//buffer.append(++i);
			buffer.append("\t Parent  : " + p + " \n");
			buffer.append("\t Size    : " + this.getSize() + " \n");
			buffer.append("\t Owner   : " + this.owner + " \n");
			buffer.append("\t Created : " + this.created + "\n");
			for (FSElement f : this.children) {
				buffer.append(f);
			}
			return buffer.toString();

		}
}
