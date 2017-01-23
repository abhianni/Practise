package src;

public class CompressionString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompressionString comp = new CompressionString();
		System.out.println(comp.compress("aabbbd"));

	}

	public String compress(String str)
	{
		StringBuilder st = new StringBuilder();
		int j=1;
		for (int i=0;i<str.length()-1;i++)
		{
			if(Character.toString(str.charAt(i)).equals(Character.toString(str.charAt(i+1))))
					{
						j=j+1;
					}
			else
			{ 
				j=j/2;
				
				for(int a=0;a<j;a++)
				{
					 
				   st.append(Character.toString(str.charAt(i)));
				  
				}
				j=1;
			}
			
			if(i==str.length()-2)
			{
				j=j/2;
				
				for(int a=0;a<j;a++)
				{
					
				   st.append(Character.toString(str.charAt(i)));
				  
				}
			}
			
		}
		
		return st.toString();
	}
}
