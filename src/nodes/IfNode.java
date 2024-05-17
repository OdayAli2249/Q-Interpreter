package nodes;

public class IfNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "If";
	}
	
	
	@Override
	public Object execute(Context context) {
		if ((Boolean)children.get(0).execute(context))
			children.get(1).execute(context);
		else if (children.size() > 2)
			{
			((BlockNode)children.get(2)).setYes(true);
			children.get(2).execute(context);}
		return null;
		
		
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
