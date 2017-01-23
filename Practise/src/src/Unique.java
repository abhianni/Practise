package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Unique {

	public static void main(String[] args) {
		Unique u = new Unique();
		// TODO Auto-generated method stub
		u.uniqueResult("abcabcxyxzhxbjkiuh");

	}

	public void uniqueResult(String str) {
		Set<String> set = new HashSet<String>();
		int size = 0;
		int a = 0;
		ArrayList<Character> op = new ArrayList<>();
		String max = "";
		for (int i = -0; i < str.length(); i++) {
			if (set.add(Character.toString(str.charAt(i)))) {
				op.add(str.charAt(i));
				a = a + 1;

			} else {
				if(op.contains(str.charAt(i))&&size>a)
				{
					op.removeAll(op);	
				}
				if (size < a) {					
					max = op.toString();
					op.removeAll(op);	
					size=a;
					a=0;					
				}
				op.add(str.charAt(i));
				a = a + 1;
			}
		}
		System.out.println(max);
	}

}
