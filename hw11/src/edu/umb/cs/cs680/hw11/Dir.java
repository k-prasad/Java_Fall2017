/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

/**
 * @author Karthik.Prasad001
 *
 */
public class Dir implements Command {

	public String path;
	private FileSystem fs;
	public ArrayList<String> fileElementsNames;
	
	public Dir(FileSystem fs) 
	{
		// TODO Auto-generated constructor stub
		this.fileElementsNames = new ArrayList<String>();
		this.fs = fs;
	}

	/* (non-Javadoc)
	 * @see edu.umb.cs.cs680.hw11.Command#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (this.path.equals("..")) {
			if (fs.getCurrent().getParent() != null) {
				for (FSElement fe : fs.getCurrent().getParent().getChildren())
					System.out.println(fe.toString());
			}
			return;
		}
		if (this.path.equals(".")||this.path.equals("")) {
			for (FSElement fe : fs.getChildren())
				System.out.println(fe.toString());
			//System.out.println("No files in this directory");
			return;
		}
		Directory cur = fs.getCurrent();
		FSElement fe = null;
		if (path.startsWith("/"))
			cur = fs.getRoot();
		//System.out.println("No files in this directory");
		for (int i = 0; i < fileElementsNames.size(); i++) {
			String name = fileElementsNames.get(i);
			boolean isFind = false;
			for (FSElement child : cur.getChildren()) {
				if (isFind) {
					//System.out.println("No files in this directory");
					break;
				}
				if (child.getName().equals(name)) {
					if (i == fileElementsNames.size() - 1) {
						fe = child;
						isFind = true;
						//System.out.println("No files in this directory");
					} else {
						switch (child.getClass().getName()) {
						case "Directory": {
							cur = (Directory) child;
							isFind = true;
							break;
						}
						//case Link: 
						//ls.execute();
						//shell.history.push(ls);
						//break;
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
						//case Link: 
						//ls.execute();
						//shell.history.push(ls);
						//break;
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
			if (fe instanceof Directory) {
				if(((Directory) fe).getChildren().size()>0)
				{
					for (FSElement f : ((Directory) fe).getChildren())
						System.out.println(f.toString());
				}
				//if(((Directory) fe).getChildren().size()>0)
				//{
				else{
					System.out.println("No files in this directory");
				}
			} else {
				System.out.println(fe.toString());
			}
		}
		else{
			//System.out.println("Found the file or directory");
			System.out.println("Cannot find the file or directory");
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		//System.out.println("No files in this directory");
		buffer.append("$ dir " + this.path + "\n\r");
		return buffer.toString();
	}
}