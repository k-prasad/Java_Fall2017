/**
 * 
 */
package edu.umb.cs.cs680.hw11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 * @author Karthik.Prasad001
 *
 */
public class Shell 
{
	public ArrayList<String> parse(String input,String sign) {
		ArrayList<String> res = new ArrayList<>();
		if (input.startsWith(sign)) {
			input = input.substring(1);
		}
		res.addAll(Arrays.asList(input.split(sign)));
		return res;
	}

	private CommandHistory history = new CommandHistory();
	public CommandHistory getCommandHistory()
	{
		return this.history;
	}

	public static void main(String[] args) throws IOException {
		Shell shell = new Shell();
		FileSystem fs = FileSystem.getFileSystem();
		Date date = new Date();
		fs.setRoot(new Directory(null, "/", "CS680", date));
		fs.setCurrent(fs.getRoot());
		Directory sys = new Directory(fs.getRoot(), "system", "Sue", date);
		Directory home = new Directory(fs.root, "usr", "home", date);
		File f1 = new File(sys, "oneDrive", "prasad", date, 310);
		File f2 = new File(sys, "cache.log", "system32", date, 54);
		File f3 = new File(sys, "cdRom", "dev", date, 605);
		Directory pictures = new Directory(home, "pictures", "karthik", date);
		File f4 = new File(home, "videos", "sysAdmin", date, 81);
		Link l1 = new Link(home, "relative link", "Karthik", date,sys);
		File f5 = new File(pictures, "WinLogo", "windows10", date, 500);
		File f6 = new File(pictures, "Welcome", "Ubuntu", date, 230);
		Link l2 = new Link(home, "absolute link", "prasad", date,l1);



		
		System.out.println("\n\n WELCOME TO THE SHELL!");
		
		System.out.print(fs.getCurrent().getPath() + ">");
		while (true) {
			BufferedReader bf = new BufferedReader(new InputStreamReader (System.in)) ;
			String commandLine = bf.readLine();
			ArrayList<String> commands =shell.parse( commandLine," ");
			if (commands.size() == 0) {
				return;
			}
			switch (CommandName.valueOf(commands.get(0).toUpperCase(Locale.ENGLISH))) {

			case CD: {
				Cd cd = new Cd(fs);
				if (commands.size() >= 2) {
					cd.path = commands.get(1);
				} else {
					cd.path = "";
					//System.out.println("Reached here");
				}
				cd.fileElementsNames = shell.parse(cd.path,"/");
				cd.execute();
				shell.history.push(cd);
				break;

			}
			case PWD: {
				Pwd pwd = new Pwd(fs);
				pwd.execute();
				shell.history.push(pwd);
				//System.out.println("Reached here");
				break;
				//case LS: {	//Ls ls = new Ls(fs);
				//ls.execute();
				//shell.history.push(ls);
				//break;
			}
			case LS: {
				Ls ls = new Ls(fs);
				ls.execute();
				shell.history.push(ls);
				//System.out.println("Reached here");
				break;
			}
			case DIR: {
				Dir dir = new Dir(fs);
				if (commands.size()  >= 2) {
					dir.path = commands.get(1);
				} else {
					dir.path = "";
					//case LS: {	//Ls ls = new Ls(fs);
					//ls.execute();
					//shell.history.push(ls);
					//break;
					//case LS: {	//Ls ls = new Ls(fs);
					//ls.execute();
					//shell.history.push(ls);
					//break;
				}
				dir.fileElementsNames = shell.parse(dir.path,"/");
				dir.execute();
				shell.history.push(dir);
				break;
			}
			case MKDIR: {
				if (commands.size() < 2) {
					break;
				} 
				Mkdir mk = new Mkdir(fs,commands.get(1));
				mk.execute();
				shell.history.push(mk);
				//System.out.println("Reached here");
				break;
			}
			case RMDIR: {
				if (commands.size() < 2) {
					break;
				} 
				//case LS: {	//Ls ls = new Ls(fs);
				//ls.execute();
				//shell.history.push(ls);
				//break;
				Rmdir rm = new Rmdir(fs,commands.get(1));
				rm.execute();
				shell.history.push(rm);
				break;
			}
			case LN: {
				if (commands.size() < 2) {
					break;
				} 
				Ln ln = new Ln(fs,commands.get(1));
				//System.out.println("Reached here");
				if (commands.size() > 2) {
					ln.path = commands.get(2);
				} else {
					ln.path = "";
					//System.out.println("Reached here");
				}
				ln.fileElementsNames = shell.parse(ln.path,"/");
				ln.execute();
				shell.history.push(ln);
				break;
			}
			case HISTORY: {
				History h = new History(shell.getCommandHistory());
				h.execute();
				//System.out.println("Reached here");
				shell.history.push(h);
				//System.out.println("Reached here before break");
				break;
			}
			case REDO: {
				Redo redo = new Redo(shell.getCommandHistory());
				redo.execute();
				break;
			}
			case SORT: {
				Comparator cmparator =new AlphabeticalComparator();;
				if (commands.size()>= 2) {
					switch(commands.get(1)){
					case "-a":
						
					{//System.out.println("Reached here");
						cmparator = new AlphabeticalComparator();
						break;
					}
					//case LS: {	//Ls ls = new Ls(fs);
					//ls.execute();
					//shell.history.push(ls);
					//break;
					case "-r":
					{
						cmparator = new ReverseAlphabeticalComparator();
						break;
					}
					default:
					{
						cmparator = new AlphabeticalComparator();
						break;
					}
					}					
				}
				Sort sort = new Sort(fs,cmparator);
				sort.execute();
				//System.out.println("Reached here3");
				shell.history.push(sort);
				break;
			}
			case CHOWN: {
				if (commands.size() < 2) {
					break;
				} 
				//case LS: {	//Ls ls = new Ls(fs);
				//ls.execute();
				//shell.history.push(ls);
				//break;
				Chown chown = new Chown(fs,commands.get(1));
				if (commands.size() > 2) {
					chown.path = commands.get(2);
				} else {
					chown.path = "";
				}
				chown.fileElementsNames = shell.parse(chown.path,"/");
				chown.execute();
				shell.history.push(chown);
				//System.out.println("Reached here7");
				break;
			}
			default: {
				break;
			}
			}
			System.out.print(fs.getCurrent().getPath() + ">");
			//System.out.println("Reached here DONE");
		}
	}

}



