package src;

import java.util.ArrayList;

public class ChangeKthBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeKthBit bit = new ChangeKthBit();
		//System.out.println(bit.notoBitConverter(13));
		System.out.println(bit.replaceKBit(13,2));
		System.out.println(bit.replaceKBit(13,3));
		System.out.println(bit.bitTonoConverter(bit.replaceKBit(13,3)));
		System.out.println(bit.bitTonoConverter(bit.replaceKBit(13,2)));
	}
	
	public ArrayList<Integer> replaceKBit(int n , int k)
	{
		ArrayList<Integer> bit = new ArrayList<Integer>();
		bit=notoBitConverter(n);
		int check = bit.get(k);
		if(check==1)
		{
			bit.set(bit.size()-k, 0);
		}
		
		return bit;
	}

	public double bitTonoConverter(ArrayList<Integer> i)
	{
		double result = 0;
		int k =0;
		for(int j=i.size()-1 ; j>=0;j--)
		{
			
			if(i.get(j)==1)
			{
				result = result+Math.pow(2, k);
				k=k+1;
			}
			else
			{
				k=k+1;
			}
			
		}
		return result;
	}
	
	public ArrayList<Integer> notoBitConverter(int n)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!(n==1))
		{
			int reminder = n%2;
			result.add(reminder);
			n=n/2;
		}
		result.add(1);
		int left,right=0;
		right=result.size()-1;
		for(left=0; left < right ; left++ ,right--)
		{
			 int temp = result.get(left);
		    result.set(left, result.get(right)) ;
		     result.set(right, temp);
			
		}
		
		return result;
	}
}
