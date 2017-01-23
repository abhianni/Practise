package src;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicates {
	public static void main(String[] args) 
	{
		RemoveDuplicates remove = new RemoveDuplicates();
		ArrayList<String> data = new ArrayList<>();
		data.add("add");
		data.add("add");
		data.add("4");
		data.add("4");
		System.out.println(remove.identifyDuplicates(data));
	}
	
	public ArrayList<String> identifyDuplicates(ArrayList<String> r)
	{
		ArrayList<String> result = new ArrayList<>();
		
		HashSet<String> duplicate = new HashSet<>();
		
		for(String wrd : r)
		{
			
			if(duplicate.add(wrd))
			{
				
			}
			else
			{
				result.add(wrd);
			}
		}
		
		return result;
	}
	
	
}
