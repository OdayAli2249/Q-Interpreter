package nodes;

public class ConditionNode extends Conditionlog {

	@Override
	public String toString()
	{
		return "Condition " + operator;
	}
	
	
	String operator;
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public Object execute(Context context) {
		try {
			if(children.get(0).execute(context) instanceof Integer && children.get(1).execute(context) instanceof Integer)
			{int d1 = (Integer)children.get(0).execute(context);
			int d2 = (Integer)children.get(1).execute(context);
		switch(operator) {
		case ">":
			return d1 > d2;
		case "<":
			return d1 < d2;
		case ">=":
			return d1 >= d2;
		case "<=":
			return d1 <= d2;
		case "<>":
			return d1 != d2;
		case "=":
			return d1 == d2;
		}}
			if(children.get(0).execute(context) instanceof Float && children.get(1).execute(context) instanceof Float)
			{float d1 = (Float)children.get(0).execute(context);
			float d2 = (Float)children.get(1).execute(context);
			
			switch(operator) {
			case ">":
				return d1 > d2;
			case "<":
				return d1 < d2;
			case ">=":
				return d1 >= d2;
			case "<=":
				return d1 <= d2;
			case "<>":
				return d1 != d2;
			case "=":
				return d1 == d2;
			}}
			if(children.get(0).execute(context) instanceof Float && children.get(1).execute(context) instanceof Integer)
			{
				float d1 = (Float)children.get(0).execute(context);
				int d2 = (Integer)children.get(1).execute(context);
			switch(operator) {
			case ">":
				return d1 > d2;
			case "<":
				return d1 < d2;
			case ">=":
				return d1 >= d2;
			case "<=":
				return d1 <= d2;
			case "<>":
				return d1 != d2;
			case "=":
				return d1 == d2;
			}
			}
			if(children.get(0).execute(context) instanceof Integer && children.get(1).execute(context) instanceof Float)
			{int d1 = (Integer)children.get(0).execute(context);
			float d2 = (Float)children.get(1).execute(context);
			switch(operator) {
			case ">":
				return d1 > d2;
			case "<":
				return d1 < d2;
			case ">=":
				return d1 >= d2;
			case "<=":
				return d1 <= d2;
			case "<>":
				return d1 != d2;
			case "=":
				return d1 == d2;
			}
			}
		}
		catch(Exception e)
		{System.out.println(e);}
		return null;
	}

	@Override
	public Object convert(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
