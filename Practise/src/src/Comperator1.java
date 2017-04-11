package src;

import java.util.Comparator;



public class Comperator1 implements Comparator<Flipkartiphone>
{
	@Override
	public int compare(Flipkartiphone s1, Flipkartiphone s2) {
			return s1.getPrice().compareTo(s2.getPrice());
}




}
