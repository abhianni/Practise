package src;

public class ExpressionCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionCheck test = new ExpressionCheck();
		//test.check("(()){}");
		test.check("({})}{");
		
	}

	public boolean check(String str)
	{
		int i=0;
		int j=0;
		for(int k=0;k<str.length();k++)
		{
			if(Character.toString(str.charAt(k)).equals("("))
			{
				if(i<0)
				{
					break;
				}
				i=i+1;
			}
			else if(Character.toString(str.charAt(k)).equals("{"))
			{
				if(j<0)
				{
					break;
				}
				j=j+1;
			}
			else if(Character.toString(str.charAt(k)).equals("}"))
			{
				if(j<0)
				{
					break;
				}
				j=j-1;
			}
			else if(Character.toString(str.charAt(k)).equals(")"))
			{
				if(i<0)
				{
					break;
				}
				i=i-1;
			}
			
	
		}
		
		if(i==0&j==0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
