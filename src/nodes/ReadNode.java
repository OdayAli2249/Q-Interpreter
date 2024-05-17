package nodes;

import java.util.Scanner;

public class ReadNode extends AbstractTreeNode {

	
	@Override
	public String toString()
	{
		return "Read " + varName;
	}
	
	String varName;
	
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	@Override
	public Object execute(Context context) {
		Input in=new Input();
		String []args= {"efe"};
		in.main(args);
		Scanner s = new Scanner(varName);
		context.getVars().put(varName,Double.parseDouble(in.getTefi()) );
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
