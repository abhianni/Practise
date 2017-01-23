package src;

public class CheckSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {6,6,5,5,4,3,2,1};

		CheckSortedArray ch = new CheckSortedArray();
		ch.checkArray(a);
	}
	public void checkArray(int[] a)
	{
		String str= "fail";
		if(a[0]<=a[1])
		{
			for(int i=0;i<a.length-1;i++)
			{
				if (a[i] <= a[i + 1]) {
					str = "pass1";
				} else {
					str = "fail";
					break ;
				}
			}
		}

		if(a[0]>=a[1])
		{
			for(int i=0;i<a.length-1;i++)
			{
				if(a[i]>=a[i+1])
				{ 
					str="pass2";
				}
				else{str ="fail";
				break ;
				}
			}
		}
		if(str.equals("pass1" ))
		{
			System.out.println("array is asscending sorted");
		}

		else if(str.equals("pass2" ))
		{
			System.out.println("array is descending sorted");
		}
		else
			System.out.println("not sorted");

	}
}
