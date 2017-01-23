package src;

import java.util.ArrayList;
import java.util.Collections;

public class FindMaxPossibleNo {
	public static void main(String[] args) 
	{
		FindMaxPossibleNo max = new FindMaxPossibleNo();
		System.out.println(max.sortedno(6789086));
		System.out.println(max.findMax(6789086));
	}
	
	
	public String sortedno(int r)
	{
		String result = "";
	   String str = Integer.toString(r);
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0;i<str.length();i++)
		{
			list.add(str.charAt(i));
		}		
		Collections.sort(list);
		for(int i=list.size()-1;i>=0;--i)
		{
			result +=list.get(i);
		}
		return result;
		
	}
	
	public int findMax(int r)
	{
		int[] digits = getDigit(r);
		int maxnum=0;
		for(int i = digits.length-1;i>=0;--i)
		{
			  int frequency = digits[i];
	            while (frequency > 0) {
	                maxnum = maxnum * 10 + i;
	              //  frequency--;
	            }
		}
		return maxnum;
	}

	public int[] getDigit(int r)
	{
		int[] digits = new int[10];
		while(r>0)
		{
			int remain = r%10;
			digits[remain]++;
			r=r/10;
		}
		
		return digits;
	}
}
