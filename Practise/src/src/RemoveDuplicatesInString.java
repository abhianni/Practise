package src;

import java.util.HashSet;

public class RemoveDuplicatesInString {
	public static void main(String[] args) 
	{
		RemoveDuplicatesInString dub = new RemoveDuplicatesInString();
		System.out.println(dub.removeFromString("jkjblblkblblblblblh"));
	}
	
	public String removeFromString(String str)
	{
		StringBuilder result = new StringBuilder();	
		
		
		HashSet<String> duplicate = new HashSet<>();
		for(int i=0;i<str.length();i++)
		{
			String wrd =Character.toString(str.charAt(i));
			if(duplicate.add(wrd))
			{
				result.append(wrd);
			}
		}
		
		return result.toString();
	}

}
