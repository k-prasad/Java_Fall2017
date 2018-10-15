/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class Chown implements Command {

	public String path;
	private FileSystem fs;
	private String ownName;
	public ArrayList<String> fileElementsNames;
	
	public Chown(FileSystem fs, String ownName) 
	{
		// TODO Auto-generated constructor stub
		this.fs = fs;
		this.ownName = ownName;
		this.fileElementsNames = new ArrayList<String>();
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				fs.getCurrent().getParent().setOwner(this.ownName);
			}
			return;
		}
		if (this.path.equals(".")||this.path.equals("")) {
			fs.getCurrent().setOwner(this.ownName);
			return;
		}
		Directory cur = fs.getCurrent();
		FSElement fe = null;
		if (path.startsWith("/"))
//			boolean isFind = false;
			//	for (FSElement child : cur.getChildren()) {
			cur = fs.getRoot();
		for (int i = 0; i < fileElementsNames.size(); i++) {
			String name = fileElementsNames.get(i);
			boolean isFind = false;
			//for (int i = 0; i < fileElementsNames.size(); i++) {
			for (FSElement child : cur.getChildren()) {
				if (isFind) {
					//Directory cur = fs.getCurrent();
					break;
				}
				if (child.getName().equals(name)) {
					//System.out.println("Reached here 1");
					if (i == fileElementsNames.size() - 1) {
						fe = child;
						isFind = true;
						//fe = child;
						//isFind = true;
					} else {
						switch (child.getClass().getName()) {
						case "Directory": {
							cur = (Directory) child;
							//System.out.println("Reached here 2");
							isFind = true;
							//System.out.println("Reached here 3");
							break;
						}
						case "Link": {
							FSElement target = child.getTarget();
							//System.out.println("Reached here 4");
							if (target instanceof Directory) {
								//System.out.println("Reached here 5");
								cur = (Directory) target;
								isFind = true;
								//System.out.println("Reached here 6");
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
				System.out.println("Cannot find the target address");
				//System.out.println("Reached here after Traget failed");
			}
		}
		fe.setOwner(this.ownName);
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("$ chown "+this.ownName+" "+this.path+"\n");
		return buffer.toString();
	}
}
