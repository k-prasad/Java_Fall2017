package edu.umb.cs.cs680.hw11;

import java.util.Date;

public class Link extends FSElement {

	private FSElement target;

	public Link(Directory p, String name, String owner, Date created, FSElement target) {
		super(p, name, owner, created);
		// TODO Auto-generated constructor stub
		this.size = 0;
		this.target=target;
	}

	@Override
	public boolean isFile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	@Override
	public FSElement getTarget()
	{
		return this.target.getTarget();
	}
	
	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("----------------------------------------------- \n");
		buffer.append("Link: " + this.name + "\n");
		buffer.append("\t Parent : " + this.p.name + "\n");
		buffer.append("\t Target : " + this.p.name + "\n");
		buffer.append("\t Size   : " + this.getSize() + "\n");
		buffer.append("\t Owner  : " + this.owner + "\n");
		buffer.append("\t Created: " + this.created + "\n");
		return buffer.toString();
	}




}
