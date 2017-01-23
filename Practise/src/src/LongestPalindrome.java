package src;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestPalindrome palin = new LongestPalindrome();
		System.out.println(palin.palindrome("aaabbaaaccdeqjncsdddmmmkkkmmmddd"));
	}
	
	public String palindrome(String str)
	{
		int max=0;
		String largestString="";
		for(int i =1;i<str.length();i++)
		{
			String largest = ispalindrome(str, i);
			if(max<largest.length())
			{
				largestString=largest;
				max=largest.length();
			}
		}
		
		return largestString;
	}
	
	public String ispalindrome(String str , int i)
	{
		String result = "" ;
		int left =i-1;
		int right = i+1;
		while(left>=0&& right<str.length()&&str.charAt(left)==str.charAt(right))
		{
			
			left--;
			right++;
		}
		result=str.substring(left+1,right);
		return result;
	}

}
