package src;

import java.util.Arrays;

public class SwapMaxMin {
	public static void main(String [] args) throws Exception 
	{
		SwapMaxMin swap = new SwapMaxMin();
		//Scanner input = new Scanner(System.in);
		int r1[]={2,5,4,5,1,8};
		int r2[]={9,1,25,4,6,7};
		int[] a =swap.swapInt(r1, r2);
		System.out.println(Arrays.toString(a));
	}
	
 public int[] swapInt(int[] r1 , int[] r2)
 {
	 int[] a=new int[]{minIndex(r1),maxIndex(r2)};
	 
	return a;
	 
 }
 
 public int minIndex(int[] r1)
 {
	 int minindex=0;
	 for(int i=1;i<r1.length;i++)
	 {
		 if(r1[i]<r1[minindex])
		 {
			 minindex=i;
		 }
	 }
	 return r1[minindex];
 }
 
 public int maxIndex(int[] r2)
 {
	 int maxIndex=0;
	 for(int i=1;i<r2.length;i++)
	 {
		 if(r2[i]>r2[maxIndex])
		 {
			 maxIndex=i;
		 }
	 }
	 return r2[maxIndex];
 }
}
