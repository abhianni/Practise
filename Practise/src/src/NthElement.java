package src;


public class NthElement {
	public static void main(String[] args) 
	{
		NthElement n = new NthElement();
		int r2[]={9,1,25,4,6,7};
		System.out.println(n.findElement(r2,4));
	}
	
	public String findElement(int[] r,int k)
	{
		int j=0;
		for(int i=k;i<r.length;i++)
		{
			j=j+1;
		}
		String result = Integer.toString(r[j]);
		
		return result;
				
	}

}
