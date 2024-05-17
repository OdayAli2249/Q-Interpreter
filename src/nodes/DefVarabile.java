package nodes;

public class DefVarabile extends AbstractTreeNode{
	@Override
	public String toString()
	{
		return "type " + nametype;
	}
	
	@Override
	public Object execute(Context context) {
		if(context.getVars().containsKey(namevar))
			throw new RuntimeException("Exist before");
		context.getVars().put(namevar, nametype);
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}
	String nametype;
	String namevar;
	public String getNamevar() {
		return namevar;
	}

	public void setNamevar(String namevar) {
		this.namevar = namevar;
	}

	public String getNametype() {
		return nametype;
	}

	public void setNametype(String nametype) {
		this.nametype = nametype;
	}
	
}
