
package edu.umb.cs.cs680.hw09;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Karthik.Prasad001
 *
 */
public class FileSystemTest {
	@Before
	public void beforeTest()
	{
		System.out.println("\n UPDATED Homework 09 - Ignore previous submission\n");
		System.out.println("\n INODE TABLE of the File System");
		
	}

	@Test
	public void test() {
		FileSystem fs = FileSystem.getFileSystem();
		Date date = new Date();
		//System.out.println();
		//File e = new File(pictures, "WinLogo", "windows10", date, 500);
		//File f = new File(pictures, "Welcome", "Ubuntu", date, 230);
		//fs.showAllElements();
		//System.out.println();
		fs.root = new Directory(null, "root /", "Kernel", date);
		Directory sys = new Directory(fs.root, "/bin ", "root /", date);
		//Directory home = new Directory(fs.root, "/usr", "home", date);
		Directory home = new Directory(fs.root, "/usr", "home", date);
		File a = new File(sys, "oneDrive", "prasad", date, 310);
		//System.out.println();
		File b = new File(sys, "cache.log", "system32", date, 54);
		File c = new File(sys, "cdRom", "/dev", date, 605);
		//System.out.println();
		//File e = new File(pictures, "WinLogo", "windows10", date, 500);
		//File f = new File(pictures, "Welcome", "Ubuntu", date, 230);
		//fs.showAllElements();
		//System.out.println();
		Directory pictures = new Directory(home, "/pictures", "karthik", date);
		File d = new File(home, "videos", "sysAdmin", date, 81);
		Link x = new Link(home, "relative link", "Karthik", date,sys);
		//fs.showAllElements();
		File e = new File(pictures, "WinLogo", "windows10", date, 500);
		File f = new File(pictures, "Welcome", "Ubuntu", date, 230);
		Link y = new Link(home, "absolute link", "prasad", date,e);
		fs.showAllElements();

	}

}

