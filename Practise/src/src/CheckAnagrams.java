package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 CheckAnagrams ana = new CheckAnagrams();
 if(ana.anagramCheck("army", "mary"))
 {
	 System.out.println("Words are anagrames");
 }
 else
 {
	 System.out.println("Words are not anagrames");
 }
	}

	public boolean anagramCheck(String str1, String str2) {
		boolean flag = false;
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		if (!(str1.length() == str2.length())) {
			flag = false;

		} else {
			for (int i = 0; i < str1.length(); i++) {

				if (map1.containsKey(str1.charAt(i))) {
					Integer count = map1.get(str1.charAt(i));
					map1.put(Character.toString(str1.charAt(i)), count + 1);
				} else {
					map1.put(Character.toString(str1.charAt(i)), 1);
				}
				if (map2.containsKey(str2.charAt(i))) {
					Integer count = map2.get(str2.charAt(i));
					map2.put(Character.toString(str2.charAt(i)), count + 1);
				} else {
					map2.put(Character.toString(str2.charAt(i)), 1);
				}
			}
		}
		if (!(map1.size() == map2.size())) {
			flag = false;
		} else {
			Set<String> set = map1.keySet();
			for(String str :set)
			{
				if(map1.get(str).equals(map2.get(str)))
				{
					flag=true;
				}
				else
				{
					flag=false;
					break;
				}
			}

		}
		return flag;																																																														
	}

}
