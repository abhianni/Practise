package src;

public class Palindromno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindromno np = new Palindromno();
		if(np.palindromeCheck(1221)==1221)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}

	}
	
	public int palindromeCheck(int k)
	
	{
		int reverse =0 ;
		while(k!=0)
		{
			
			reverse=reverse*10+k%10;
		     k=k/10;
		}
		 return reverse;
	}

}
