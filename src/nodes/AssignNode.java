package nodes;

public class AssignNode extends AbstractTreeNode {

	@Override
	public String toString()
	{
		return "Assign " + varName;
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
		if(context.getVars().containsKey(varName))
		{try
			{
			//CASE INTEGER
			if(((String)context.getVars().get(varName)).equals("int"))
		{context.getVars().put(varName, (Integer)children.get(0).execute(context));
		System.out.println("int");
		return null;}
			//CASE FLOAT
		if(((String)context.getVars().get(varName)).equals("float"))
		{System.out.println("floatassign");
		context.getVars().put(varName, (Float)children.get(0).execute(context));
		return null;}
		//CASE STRING
		if(((String)context.getVars().get(varName)).equals("String"))
		{System.out.println("string");
			context.getVars().put(varName, (String)children.get(0).execute(context));
			return null;}
		//CASE CHAR
		if(((String)context.getVars().get(varName)).equals("char"))
		{System.out.println("char");
			context.getVars().put(varName, (Character)children.get(0).execute(context));
			return null;}
		/*else
		{throw new RuntimeException("type param not same type value");
		}*/}
		catch(Exception e)
		{System.out.println(e);}
			}
		else {
			
			if(children.get(0).execute(context)instanceof Integer)
			{context.getVars().put(varName, (Integer)children.get(0).execute(context));
			System.out.println(varName);
			System.out.println("int");
			return null;}
			//try and catch for type not same value
			if(children.get(0).execute(context)instanceof Float)
			{System.out.println("floatassign");
			context.getVars().put(varName, (Float)children.get(0).execute(context));
			return null;}
			
			if(children.get(0).execute(context)instanceof String)
			{System.out.println("string");
				context.getVars().put(varName, (String)children.get(0).execute(context));
				return null;}
			if(children.get(0).execute(context)instanceof Character)
			{System.out.println("char");
				context.getVars().put(varName, (Character)children.get(0).execute(context));
				return null;}
		}
		return null;
	}

	@Override
	public Object convert(Context context) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
