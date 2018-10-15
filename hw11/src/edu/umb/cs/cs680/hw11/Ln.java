/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Karthik.Prasad001
 *
 */
public class Ln implements Command {

	public String path;
	private FileSystem fs;
	private String linkName;
	public ArrayList<String> fileElementsNames;
	
	public Ln(FileSystem fs, String linkName) 
	{
		// TODO Auto-generated constructor stub
		this.fs = fs;
		this.linkName = linkName;
		this.fileElementsNames = new ArrayList<String>();
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		Date date = new Date();
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				new Link(fs.getCurrent(), this.linkName, "", date, fs
						.getCurrent().getParent());
			}
			return;
		}
		if (this.path.equals("")) {
			new Link(fs.getCurrent(), this.linkName, "", date, fs.getRoot());
			return;
		}
		if (this.path.equals(".")) {
			new Link(fs.getCurrent(), this.linkName, "", date, fs.getCurrent());
			return;
		}
		Directory cur = fs.getCurrent();
		FSElement fe = null;
		if (path.startsWith("/"))
			cur = fs.getRoot();
		for (int i = 0; i < fileElementsNames.size(); i++) {
			String name = fileElementsNames.get(i);
			boolean isFind = false;
			for (FSElement child : cur.getChildren()) {
				if (isFind) {
					break;
				}
				if (child.getName().equals(name)) {
					if (i == fileElementsNames.size() - 1) {
						fe = child;
						isFind = true;
					} else {
						switch (child.getClass().getName()) {
						case "Directory": {
							cur = (Directory) child;
							isFind = true;
							break;
						}
						case "Link": {
							FSElement target = child.getTarget();
							if (target instanceof Directory) {
								cur = (Directory) target;
								isFind = true;
								break;
							} else {
								continue;
							}
						}
						default: {
							continue;
						}
						}
					}
				}
			}
			if (!isFind) {
				break;
			}
		}
		if (fe != null) {
			new Link(fs.getCurrent(), this.linkName, "", date, fe);
		} else {
			System.out.println("Cannot find the target address");
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ ln " + this.linkName + " " + this.path
				+ "\n\r");
		return buffer.toString();
	}
}
