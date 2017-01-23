package src;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	int first,last,middle,search;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		int a[]={9,1,25,4,6,7,89,54,46,28,58,52,47};
		
		
		BinarySearch src = new BinarySearch();
		src.searchno(a);
	}
	
	public void searchno(int[] n)
	{
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		search=scan.nextInt();
		first=0;
		last=n.length-1;
		middle=(first+last)/2;
		Arrays.sort(n);
	for(int i=0;i<n.length;i++)
		{
			if(search<n[middle])
			{
				last=middle-1;
				
			}
			
			else if(search==n[middle])
			{
				System.out.println("Searched Element found at"  +middle );
				break;
			}
			
			else if(search>n[middle])
			{
				first=middle+1;
				
			}
		 if(first>last)
			{
				System.out.println("Searchable element not found");
				break;
			}
			middle=(first+last)/2;
		}
	}

}
