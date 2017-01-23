package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/

class PrintHackerEarth {
    public static void main(String args[] ) throws Exception {
        
       //  * Read input from stdin and provide input before running
       //  * Use either of these methods for input

        //BufferedReader
        int total=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
		String str = br.readLine();
       HashMap<String,Integer> map = new HashMap<>();
 		
        for (int i = 0; i < N; i++) {
             
             if(map.containsKey(Character.toString(str.charAt(i))))
             {
             	Integer no = map.get(Character.toString(str.charAt(i)));
             	map.put(Character.toString(str.charAt(i)),no+1);
             }
             else
             {
             	map.put(Character.toString(str.charAt(i)),1);
             }
			  }
			  
		if(map.containsKey("h"))	  
		{
			Integer no = map.get("h")	;
			no=no / 2;
			
				total=no;
			
		}
		 if(map.containsKey("a"))	  
		{
			Integer no = map.get("a")	;
			no=no/2;
			if(total>no)
			{
				total=no;
			}
		}
		 if(map.containsKey("c"))	  
		{
			Integer no = map.get("c")	;
			
			if(total>no)
			{
				total=no;
			}
		}
		 if(map.containsKey("k"))	  
		{
			Integer no = map.get("k")	;
		
			if(total>no)
			{
				total=no;
			}
		}
		 if(map.containsKey("e"))	  
		{
			Integer no = map.get("e")	;
			no=no/2;
			if(total>no)
			{
				total=no;
			}
		}
		 if(map.containsKey("r"))	  
		{
			Integer no = map.get("r")	;
			no=no/2;
			if(total>no)
			{
				total=no;
			}
		}
		 if(map.containsKey("t"))	  
		{
			Integer no = map.get("t")	;
		
			if(total>no)
			{
				total=no;
			}
		}
		System.out.println(total);
    }	
}
