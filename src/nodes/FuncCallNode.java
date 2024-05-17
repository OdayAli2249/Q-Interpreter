package nodes;

import java.util.HashMap;

public class FuncCallNode extends ExpressionNode {

	String functionName;
	
	HashMap<String, FunctionDef> functions = new HashMap<String, FunctionDef>();
	
	
	
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public HashMap<String, FunctionDef> getFunctions() {
		return functions;
	}

	public void setFunctions(HashMap<String, FunctionDef> functions) {
		this.functions = functions;
	}

	@Override
	public Object execute(Context context) {
		
		if (!functions.containsKey(functionName))
			throw new RuntimeException("function not found");
		FunctionDef f = functions.get(functionName);
		if (f.getParams().size() != this.children.size())
			throw new RuntimeException("Invalid params");
		HashMap<String, Object> tmp = new HashMap<String, Object>();
		for(int i=0;i<f.getParams().size();i++)
		{if(this.getChildren().get(i).execute(context)instanceof Integer)
			tmp.put(f.getParams().get(i), (int)this.getChildren().get(i).execute(context));
		else if(this.getChildren().get(i).execute(context)instanceof Float)
			tmp.put(f.getParams().get(i), (float)this.getChildren().get(i).execute(context));
		else if(this.getChildren().get(i).execute(context)instanceof String)
			tmp.put(f.getParams().get(i), (String)this.getChildren().get(i).execute(context));
		else if(this.getChildren().get(i).execute(context)instanceof Character)
			tmp.put(f.getParams().get(i), (char)this.getChildren().get(i).execute(context));
		}
		context.startFunction();
		context.getVars().putAll(tmp);
		f.root.execute(context);
		Object res =null;
		if(context.getVars().get("ret")instanceof Integer)
			res = (int)context.getVars().get("ret");
		else if(context.getVars().get("ret")instanceof Float)
			res = (float)context.getVars().get("ret");
		else if(context.getVars().get("ret")instanceof String)
			res = (String)context.getVars().get("ret");
		else if(context.getVars().get("ret")instanceof Character)
			res = (char)context.getVars().get("ret");
		context.endFunction();
		return res;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
