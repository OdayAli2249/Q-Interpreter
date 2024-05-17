

import nodes.AbstractTreeNode;
import nodes.Context;

public class WriteNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Write";
	}
	
	@Override
	public Object execute(Context context) {
		System.out.println(children.get(0).execute(context));
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
