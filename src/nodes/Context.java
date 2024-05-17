package nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Context {
	ArrayList<String> list=new ArrayList<String>();
	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	private HashMap<String, Object> vars = new HashMap<>();
	private HashMap<String, Object> varshe = new HashMap<>();
	Stack<HashMap<String, Object>> varStack = new Stack<HashMap<String,Object>>();
public void stratScop()
{varshe.putAll(vars);
	varStack.push(varshe);
}
	public void startFunction() {
		varStack.push(vars);
		vars = new HashMap<String, Object>();
	}
	public void endScop()
	{
		Object ret;
		if(vars.containsKey("ret"))
			{ret=vars.get("ret");
		vars = varStack.pop();
		vars.put("ret",ret);}
		else{vars=varStack.pop();} 
		}
	
	public void endFunction() {
		
		vars = varStack.pop();
	}
	
	public HashMap<String, Object> getVars() {
		return vars;
	}
	
	
	
	
}
