package edu.umb.cs.cs680.hw11;

import java.util.Date;

/**
 * @author Karthik.Prasad001
 *
 */
public abstract class FSElement {

	public String name;
	public String owner;
	public Date created;
	public Date lastModified;
	public int size;
	public Directory p;
	
	
	public FSElement(Directory p, String name, String owner, Date created) 
	{
		// TODO Auto-generated constructor stub
		
		this.p=p;
		if (p != null)
		{
			this.p.appendChild(this);
		}
		this.name = name;
		this.owner = owner;
		this.created = created;
		this.lastModified = created;
		
	}
	
	public String getName() 
	{
		return this.name;
	}
	public Directory getParent() 
	{
		return this.p;
	}

	abstract public FSElement getTarget();
	
	public String getOwner()
	{
		return this.owner;
	}
	
	public String getPath() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.name);
		FSElement fe = this.p;
		while(fe!=null)
		{
			buffer.insert(0, fe.getName()+"/");
			fe=fe.p;
		}
		return buffer.toString().substring(1);
	}
	
	public void setOwner(String name)
	{
		this.owner=name;
	}
	
	public abstract boolean isFile();

	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

}
