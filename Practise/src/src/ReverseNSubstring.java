package src;

import java.util.Arrays;

public class ReverseNSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNSubstring rev = new ReverseNSubstring();
		int[] ip ={1,3,5,7,9,11,15,17,19,24,21};
		System.out.println(rev.reverseNSubset(ip, 3));;

	}

	public String reverseNSubset(int[] ip , int N)
	{
		
		
		for(int i=0;i<ip.length;i++)
		{
			int first =i;
			int last=i+N-1;			
				while(first<last)
			{
				int temp=ip[i];
				ip[i]=ip[last];
				ip[last]=temp;
				first=first+1;
				last=last-1;
			}
				i=i+N-1;
			if(i+N>ip.length-1)
			{
				N=ip.length-1-i;
			}
			
		}
		
		return Arrays.toString(ip);
	}
	
	
	
	
}
