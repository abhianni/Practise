package src;

import java.util.HashMap;

public class PairsSumInarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] t={1,2,3,4,5,6,7,8,9,0,10,5};
		PairsSumInarray pair = new PairsSumInarray();
		pair.findPairWithHash(t,10);
	}
	
	public void findPairWithHash(int [] arr , int sum)
	{
		HashMap<Integer, Integer> pair = new HashMap<>();
		for(int each : arr)
		{
			if(pair.containsKey(each))
			{
				System.out.println( each+","+pair.get(each));
			}
			else
			{
				pair.put(sum-each, each);
			}
		}
	}

}
