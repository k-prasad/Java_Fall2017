/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class Cd implements Command
{
	public String path;
	private FileSystem fs;
	public ArrayList<String> fileElementsNames;

	public Cd(FileSystem fs) {
		this.fileElementsNames = new ArrayList<String>();
		this.fs = fs;
	}

	public void execute() {
		if (this.path.equals("..")) {
			//if (isFind) {
			//	break;
			if (fs.getCurrent().getParent() != null) {
				fs.setCurrent(fs.getCurrent().getParent());
					//System.out.println("Reached here before");
			}
			return;
		}
		if (this.path.equals("")) {
			fs.setCurrent(fs.getRoot());
			return;
		}
		
	//	for (String name : fileElementsNames) {
		//	boolean isFind = false;
		//	for (FSElement child : cur.getChildren()) {
		//System.out.println("Reached here 1");

		
		
		if (this.path.equals(".")) {
			return;			
		}
		Directory cur = fs.getCurrent();
		if (path.startsWith("/"))
			cur = fs.getRoot();
		//isFind = true;
		for (String name : fileElementsNames) {
			boolean isFind = false;
			//System.out.println("Reached here 1");
			for (FSElement child : cur.getChildren()) {
				//isFind = true;
				if (isFind) {
					break;
				}
				if (child.getName().equals(name)) {
					switch (child.getClass().getName()) {
					case "Directory": {
						cur = (Directory) child;
						//isFind = true;
						isFind = true;
						//System.out.println("Reached here 2");
						break;
					}
					case "Link": {
						FSElement target = child.getTarget();
						if (target instanceof Directory) {
							//cur = (Directory) target;
							cur = (Directory) target;
							isFind = true;
							break;
						} else {
							continue;
						}
						
					//case "Link": {
						//FSElement target = child.getTarget();
						//if (target instanceof Directory) {
							//cur = (Directory) target;
							//isFind = true;
							//break;
					}
					default: {
						continue;
					}
					}
				} else {
					continue;
				}
			}
			if (!isFind) {
				System.out.println("Directory does not exist.");
				//System.out.println("Reached here 3");
			}
		}
		fs.setCurrent(cur);
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ cd "+this.path+"\n\r");
		return buffer.toString();
	}

}
