package edu.umb.cs.cs680.hw10;

import java.util.Date;

public class File extends FSElement {

	public File(Directory p, String name, String owner, Date created, int size) {
		super(p, name, owner, created);
		// TODO Auto-generated constructor stub
		this.size = size;
	}
	
	@Override
	public boolean isFile() {
		return true;
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public void accept (FSVisitor v) {
		v.visit(this);
	}

	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("----------------------------------------------- \n");
		//String i = "a";
		//buffer.append(i+1);
		buffer.append("File: " + this.name + " \n");
		buffer.append("\t Parent  : " + this.p.name + " \n");
		buffer.append("\t Size    : " + this.getSize() + " \n");
		buffer.append("\t Owner   : " + this.owner + " \n");
		buffer.append("\t Created : " + this.created + " \n");
		return buffer.toString();
	}
	

}
