
package edu.umb.cs.cs680.hw10;

/**
 * @author Karthik.Prasad001
 *
 */
public class VirusCheckingVisitor extends FSVisitor
{

	private int quarantined= 0;
	Link rootDir;
	public void visit(Link link){

		return;
	}
	
	public VirusCheckingVisitor() 
	{
		// TODO Auto-generated constructor stub
	}

	public void visit(File file)
	{
		VirusCheckingVisitor visitor = new VirusCheckingVisitor();
		//rootDir.accept(visitor);
		visitor.getQuarantinedNum();

		return;
	}
	public void visit(Directory directory){

		return;
	}

	public int getQuarantinedNum(){
		return this.quarantined;

	}
}
