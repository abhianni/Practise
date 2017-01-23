package src;

import java.util.HashMap;
import java.util.HashSet;

public class FrequencyString {
	public static void main(String[] args){
		FrequencyString str  = new FrequencyString();
		String fre="parallel in length";
		System.out.println(str.frequency(fre));
	   
	}
	
	public String frequency(String str)
	{
		String result=null;
		str=str.replaceAll("\\s", "");
		HashSet<String> hash = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String , Integer>();
		
		for(int i=0;i<str.length();i++)
		{
			if(hash.add(Character.toString(str.charAt(i))))
			{
				map.put(Character.toString(str.charAt(i)), 1);
			}
			
			else
			{
				
					Integer count = map.get(Character.toString(str.charAt(i)));
					map.put(Character.toString(str.charAt(i)), count+1);
				
				
			}
		}
		
		result=map.toString();
		return result;
	}

}
