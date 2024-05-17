package nodes;

public class WriteNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Write";
	}
	
	@Override
	public Object execute(Context context) {
		context.getList().add(children.get(0).execute(context).toString()+"\n");
		System.out.println(children.get(0).execute(context));
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
