package src;


/* IMPORTANT: Multiple classes and nested static classes are supported */


// * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class InventoryProb {
    public static void main(String args[] ) throws Exception {
        
        // * Read input from stdin and provide input before running
       HashMap <String,Integer> items = new HashMap<String,Integer>();
       HashMap<String,Integer> inventory = new HashMap<String,Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str [] = line.split(" ");
            items.put(str[0],Integer.parseInt(str[1]));
            inventory.put(str[0],0);
        }
         line = br.readLine();
		int M = Integer.parseInt(line);
		for(int i =0;i<M;i++)
		{
			line = br.readLine();
			String str[] = line.split(" ");
			
			if(str[0].equals("+"))
			{
				
				Integer no = inventory.get(str[1]);
				inventory.put(str[1] , no+1);
			}
			else if(str[0].equals("-"))
			{
					Integer no = inventory.get(str[1]);
					if(no>0)
					{
						inventory.put(str[1] , no-1);
					}
			}
			else if(str[0].equals("?"))
			{
				int total=0;
				Set<String> key = new HashSet<String>();
				key = items.keySet();
			for(String single:key)
			{
				if(items.get(single)>Integer.parseInt(str[1]) && inventory.get(single)>0)
				{
					total=total+1;
				}
			}
			System.out.println(total);
				
			}
			
		
		}
       
    }
}
