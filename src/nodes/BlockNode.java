package nodes;

public class BlockNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Block";
	}
	boolean yes=false;
	public boolean isYes() {
		return yes;
	}

	public void setYes(boolean yes) {
		this.yes = yes;
	}

	@Override
	public Object execute(Context context) {
		if(yes)
		{
			for(AbstractTreeNode n : children)
			n.execute(context);}
		else {
		context.stratScop();
		for(AbstractTreeNode n : children)
			n.execute(context);
		context.endScop();}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
