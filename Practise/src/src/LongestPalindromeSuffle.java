package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeSuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromeSuffle suff = new LongestPalindromeSuffle();
		System.out.println(suff.findPalindrome("aabcbcbdcc"));

	}

	public String findPalindrome(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				Integer count = map.get(str.charAt(i));
				map.put(str.charAt(i), count + 1);
			} else {
				map.put(str.charAt(i), 1);
			}

		}
		Set<Character> set = map.keySet();
		int centre = 0;		
		for (char ch : set) {
			Integer fre = map.get(ch);
			if(!(fre%2==0))
			{
				Integer count = map.get(ch);
				if (centre == 0) {
					centre = 1;
					map.put(ch, count);
					continue;
				} 
				if ((!(count == 1) || !(count%2==0))  ){
					count = count - 1 ;
				}
				if (!(count == 0)) {
					map.put(ch, count);
				} else {
					map.remove(ch);
				}
			}
		}
		set = map.keySet();
		String left = "",right="",c="";
		for(char ch:set)
		{
			if(map.get(ch)%2==0)
			{
				for(int i =0;i<map.get(ch)/2;i++)
				{
				left=left+ch;
				right=ch+right;
				}
			}
			else
			{
				for(int i =0;i<map.get(ch);i++)
				{
					c=c+ch;
				}
			}
		}
		
		return left+c+right;
	}

}
