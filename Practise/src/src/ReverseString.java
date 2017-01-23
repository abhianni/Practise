package src;

import java.util.ArrayList;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseString reverse = new ReverseString();		
		System.out.println(reverse.reverse("this is test string"));
	}
	
	public String reverse(String  str)
	{
		String result = "";
		char[] newchar = str.toCharArray();
		int start = 0;
		int last = newchar.length-1;
		for(int i=start ; i<last;i++,last--)
		{
			char temp ;
			temp=newchar[i];
			newchar[i]=newchar[last];
			newchar[last]=temp;
			
		}
		for(char c:newchar)
		{
			result=result+c;
		}
		
		return result;
	}

}
