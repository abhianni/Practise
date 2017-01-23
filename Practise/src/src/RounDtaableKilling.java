package src;

import java.util.ArrayList;
import java.util.Stack;

public class RounDtaableKilling {
	ArrayList<Integer> originalList = new ArrayList<>();
	ArrayList<Integer> survivedList = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RounDtaableKilling killer = new RounDtaableKilling();
		System.out.println(killer.roundtable(10, 2));
	}
	
	public int roundtable(int size , int killer)
	{
		int survivor = 0;
		for(int i=1;i<=size;i++)
		{
			originalList.add(i);
			
		}
		for(int i =0;i<killer-1;i++)
		{
			survivedList.add(originalList.get(0));
			originalList.remove(0);
		}
		
		originalList.addAll(survivedList);
		while(!(originalList.size()==1))
		{
			firingRound(originalList);
		}
		survivor = originalList.get(0);
		return survivor;
	}
	
	public void firingRound(ArrayList<Integer> list)
	{
		survivedList.clear();
	
		for(int i=0;i<list.size();i++)
		{
			survivedList.add(originalList.get(i));
			
			if(i==list.size()-1)
			{
			
				originalList.clear();
				for(int j =0;j<survivedList.size();j++)
				{
					originalList.add(survivedList.get(0));
					survivedList.remove(0);
				}
				survivedList.addAll(originalList);
			}
				i=i+1;
		}
		originalList.clear();
		originalList.addAll(survivedList);
	}
	
	
	

}
