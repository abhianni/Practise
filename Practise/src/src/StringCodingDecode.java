package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Stack;

public class StringCodingDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCodingDecode ip = new StringCodingDecode();
		System.out.println(Arrays.toString(ip.getFrequency("2421#(3)1915#23#11")));

	}
	
	public int[] getFrequency(String str)
	{
		String output="";
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		for(int i=97;i<=122;i++)
		{
			map.put((char) i, 0);
		}
		Stack<Character> s  = new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='#')
			{
				int a = Character.getNumericValue(s.pop());
				a=a+Character.getNumericValue(s.pop())*10;
				a=a+96;
					Integer c =map.get((char)a);
					map.put((char)a,c+1);
				String next="";
				if(s.size()>0)
				{
				for(int j=0;j<=s.size();j++)
				{
					int b=Character.getNumericValue(s.pop());
					b=b+96;
					
						Integer x =map.get((char)b);
						map.put((char)b,x+1);
					next=(char)b+next;
					
				}
				output+=next;
				}
				output+=(char)a;
				
			}
			else if(str.charAt(i)=='(')
			{
				int l = Character.getNumericValue(str.charAt(i+1));
				for(int j=0;j<l-1;j++)
				{
					Integer v =map.get(output.charAt(output.length()-1));
					map.put(output.charAt(output.length()-1),v+1);
					output+=output.charAt(output.length()-1);
					
				}
				i=i+2;
			}
			else
			{
				s.push(str.charAt(i));
			}
			if(i==str.length()-1&&s.size()>0)
			{
				String next="";
				for(int j =0;j<=s.size();j++)
				{
					int b=Character.getNumericValue(s.pop());
					b=b+96;
					
						Integer x =map.get((char)b);
						map.put((char)b,x+1);
					next=(char)b+next;
				}
				output+=next;
			}
		
		}
		int[] array = new int[map.size()];
		Set<Character> set = map.keySet();
		int count=0;
		for(char c:set)
		{
			array[count]=map.get(c);
			count=count+1;
		}
		System.out.println(output);
		return array;
	}

}
