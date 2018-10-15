package edu.umb.cs.cs680.hw09;

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
	
	public Directory getParent() {
		return this.p;
	}

	public abstract boolean isFile();

	abstract public int getSize();

}
