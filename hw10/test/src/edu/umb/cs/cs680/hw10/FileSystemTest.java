
package edu.umb.cs.cs680.hw10;

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
		System.out.println("\n Welcome to the FILE SYSTEM! (HomeWork-10)");
		
	}

	@Test
	public void test() {
		FileSystem fs = FileSystem.getFileSystem();
		Date date = new Date();
		fs.root = new Directory(null, "root /", "Kernel", date);
		Directory sys = new Directory(fs.root, "/bin ", "root /", date);
		Directory home = new Directory(fs.root, "/usr", "home", date);
		File a = new File(sys, "oneDrive", "prasad", date, 310);
		File b = new File(sys, "cache.log", "system32", date, 54);
		File c = new File(sys, "cdRom", "/dev", date, 605);
		Directory pictures = new Directory(home, "/pictures", "karthik", date);
		File d = new File(home, "videos", "sysAdmin", date, 81);
		Link x = new Link(home, "relative link", "Karthik", date,sys);
		File e = new File(pictures, "WinLogo", "windows10", date, 500);
		File f = new File(pictures, "Welcome", "Ubuntu", date, 230);
		Link y = new Link(home, "absolute link", "prasad", date,e);
		fs.showAllElements();
		
		CountingVisitor cv = new CountingVisitor();
		fs.root.accept(cv);
		
		System.out.println("----------------------------------------------- \n");
		System.out.println("FILE SYSTEM DETAILS:"+"\n");

		System.out.println(cv.getDirNum()+ " Directory(s)" + "\n");
		System.out.println(cv.getFileNum()+" File(s)" + "\n");
		System.out.println(cv.getLinkNum()+" Link(s)" + "\n");


		VirusCheckingVisitor scv = new VirusCheckingVisitor();
		fs.root.accept(scv);
		System.out.println("----------------------------------------------- \n");
		System.out.println("Number of Virus filed Quartined: " + scv.getQuarantinedNum()+"\n");
		
		FileSearchVisitor fsv = new FileSearchVisitor (".txt");
		fs.root.accept(fsv);
		fsv.getFoundFiles().size();
		System.out.println("----------------------------------------------- \n");
		System.out.println("Number of files with the extension \".txt\": " + fsv.getFoundFiles().size());
		System.out.println("\n\n-----------------END--- HOMEWORK 10--------------------------- \n");

	}

}

