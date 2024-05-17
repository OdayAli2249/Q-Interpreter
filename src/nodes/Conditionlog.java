package nodes;

import java.util.ArrayList;
import java.util.HashMap;

public class Conditionlog extends AbstractTreeNode{
	@Override
	public String toString()
	{
		return "Conditionlog " + ao;
	}
	
	String ao;
	boolean res;
	public String getAo() {
		return ao;
	}

	public void setAo(String ao) {
		this.ao = ao;
	}

	
	HashMap<Integer, String> notlog = new HashMap<>();
	
	public HashMap<Integer, String> getNot() {
		return notlog;
	}

	public void setNot(HashMap<Integer, String> notlog) {
		this.notlog = notlog;
	}

	@Override
	public Object execute(Context context) {
		
	
		if(notlog.get(0)!=null)
		{
			if(notlog.get(1)!=null)
			{
				calres(context);
				res=!res;
			}
			else
			{
				calres(context);}
			return !res;
		}
		else
		{
			if(notlog.get(1)!=null)
			{
				calres(context);
				res=!res;
			}
			else
			{
				calres(context);}
			
		}
		
		return res;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}
	public void calres(Context context)
	{	
		if(children.size()==2&&children.get(1) instanceof BlockNode )
	{
		BlockNode node=(BlockNode)children.get(1);
		node.setYes(true);
		if(node.children.size()>1)
		{for(int i=0;i<node.children.size()-1;i++)
		{
			Conditionlog con=(Conditionlog)node.children.get(i);
			Conditionlog con1=(Conditionlog)node.children.get(i);
			switch(con1.getAo()) {
			case "$":
				res=(boolean) con.execute(context)&& (boolean)con1.execute(context);
			case "|":
				res= (boolean) con.execute(context)||(boolean)con1.execute(context);
			}
			
		}
			}
		else if(node.children.size()==1)
		{
			Conditionlog con=(Conditionlog)node.children.get(0);
			
			switch(con.getAo()) {
			case "$":
				res=(boolean) children.get(0).execute(context)&& (boolean)con.execute(context);
			case "|":
				res= (boolean) children.get(0).execute(context)||(boolean)con.execute(context);
			}
			
		}
		
	}
	else
	{res=(boolean) children.get(0).execute(context);}
	}
}
