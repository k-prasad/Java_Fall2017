/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.umb.cs.cs680.hw11.Directory;
import edu.umb.cs.cs680.hw11.File;
import edu.umb.cs.cs680.hw11.Link;

import static org.hamcrest.CoreMatchers.*;

/**
 * @author Karthik.Prasad001
 *
 */
public class FacadeTest 
{
	private FileSystem fs;
	private CommandHistory history ;
	private String path;
	private Shell shell;
	
	@Before
	public void CommandTest()
	{
		fs = FileSystem.getFileSystem();
		Date date = new Date();
		fs.setRoot(new Directory(null, "/", "SysAdmin", date));
		fs.setCurrent(fs.getRoot());
		Directory home = new Directory(fs.root, "usr", "home", date);
		Directory sys = new Directory(fs.getRoot(), "system", "Sue", date);
		File f1 = new File(sys, "oneDrive", "prasad", date, 310);
		File f2 = new File(sys, "cache.log", "system32", date, 54);
		File f3 = new File(sys, "cdRom", "dev", date, 605);
		Directory pictures = new Directory(home, "pictures", "karthik", date);
		File f4 = new File(home, "videos", "sysAdmin", date, 81);
		Link l1 = new Link(home, "relative link", "Karthik", date,sys);
		File f5 = new File(pictures, "WinLogo", "windows10", date, 500);
		File f6 = new File(pictures, "Welcome", "Ubuntu", date, 230);
		Link l2 = new Link(home, "absolute link", "prasad", date,l1);
		this.path = "/home/pictures";
		this.shell = new Shell();
	}
/*	@Test
	public void testCdExecute() 
	{
		Cd cd = new Cd(fs);
		cd.path=this.path;
		cd.fileElementsNames = shell.parse(cd.path,"/");
		cd.execute();
		cd.path="";
		cd.fileElementsNames = shell.parse(cd.path,"/");
	//	this.history.push(cd);
		assertThat(fs.getCurrent().getName(), is("pictures"));
	} */
	@Test
	public void testCdRootExecute() 
	{
		Cd cd = new Cd(fs);
		//System.out.println("Reached here 5");
		cd.path="";
		cd.fileElementsNames = shell.parse(cd.path,"/");
		cd.execute();
	//	this.history.push(cd);
		//System.out.println("Reached here 6");
		assertThat(fs.getCurrent().getName(), is("/"));
	}
	@Test
	public void testMkdirExecute() 
	{
		int c = fs.getChildren().size();
		Mkdir mkdir = new Mkdir(fs,"test1");
		//System.out.println("Reached here 7");
		mkdir.execute();
	//	this.history.push(mkdir);
		//System.out.println("Reached here 8");
		assertThat(fs.getChildren().size(), is(c+1));
	}

	
/*	public void testRmdirExecute() {
		int c = fs.getChildren().size();
		Rmdir rmdir = new Rmdir(fs,"home");
		rmdir.execute();
		cd.path="";
		cd.fileElementsNames = shell.parse(cd.path,"/");
	//	this.history.push(rmdir);
		assertThat(fs.getChildren().size(), is(c-2));
	}  */
/*	@Test
	public void testLnExecute() {
		int c = fs.getChildren().size();
		Ln ln = new Ln(fs,"testLink1");
		cd.path="";
		cd.fileElementsNames = shell.parse(cd.path,"/");cd.path="";
		cd.fileElementsNames = shell.parse(cd.path,"/");
		ln.path = "/home";
		ln.fileElementsNames = shell.parse(ln.path,"/");
		ln.execute();
	//	this.history.push(ln);
		assertThat(fs.getChildren().size(), is(c+1));
	} */
	@Test
	public void testChownExecute() 
	{
		Chown chown = new Chown(fs,"XYZ");
		//System.out.println("Reached here 9");
		chown.path = "";
		chown.fileElementsNames = shell.parse(chown.path,"/");
		chown.execute();
		//System.out.println("Reached here 10");
	//	this.history.push(chown);
		assertThat(fs.getCurrent().getOwner(), is("XYZ"));
	}
}
