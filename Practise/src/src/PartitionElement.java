package src;

import java.util.ArrayList;
import java.util.List;

public class PartitionElement {
	public static void main(String[] args) 
	{
		PartitionElement part = new PartitionElement();
		int r2[]={9,1,25,4,6,7};
		System.out.println(part.partition(r2, 25));
	}
	
	public String partition(int[] r , int a)
	{
		List<Integer> r1 = new ArrayList<Integer>();
		List<Integer> r2 = new ArrayList<Integer>();
		
		for(int i: r)
		{
			if(i<a)
			{
				r1.add(i);
			}
			else
			{
				r2.add(i);
			
			}
			
		}
		
		
				r1.addAll(r2);
		return r1.toString();
	}
}
