package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveSameno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveSameno remove = new RemoveSameno();
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		int End = s.nextInt();
		while(start<=End)
		{
			if(!(start/10==0))
			{
				if(!(remove.isDuplicate(start)))
				{
					System.out.println(start);
				}
			}
			else
			{
				System.out.println(start);
			}
			start=start+1;
		}
//		if(!(End/10==0))
//		{
//			if(!(remove.isDuplicate(End)))
//			{
//				System.out.println(End);
//			}
//		}
//		else
//		{
//			System.out.println(End);
//		}
		
		

	}

	public boolean isDuplicate(int no)
	{
		Map<Character,Integer> map = new HashMap<>();
		char[] array = String.valueOf(no).toCharArray();
		for(char c:array)
		{
			map.put(c, 1);
		}
		if(!(map.size()==array.length))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
