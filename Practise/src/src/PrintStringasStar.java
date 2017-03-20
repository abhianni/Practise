package src;

public class PrintStringasStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 PrintStringasStar star = new PrintStringasStar();

 star.printStarColumnWise(34502);
	}

	public void printStarInHorizontal(int input)
	{
		char[] ch = String.valueOf(input).toCharArray();
		int length = ch.length;
		int space;
		
		for(int i=0;i<length;i++)
		{
			String left="",right="",centre="";
			int temp = Character.getNumericValue(ch[i]);
			if(temp==0)
			{
				space=10;
			}
			else
			{
			 space = 10-temp;
			}
			if(space==10)
			{
				System.out.println("          ");
			}
			else
			{
				centre="*";
				temp=temp-1;
			while(space>0)
			{
				left=left+" ";
				space=space-1;
				if(space==0)
					break;
				right=" "+right;
				space=space-1;
			}
			while(temp>0)
			{
				left=left+"*";
				temp=temp-1;
				if(temp==0)
					break;
				right="*"+right;
				temp=temp-1;
			}
			System.out.println(left+centre+right);
			}
			
		}
	
	}
	
	public void printStarinVertical(int input)
	{
		char[] ch = String.valueOf(input).toCharArray();
		int length = ch.length;
		for(int i=0;i<length;i++)
		{
			int temp = Character.getNumericValue(ch[i]);
			for(int k=0;k<temp;k++)
			{
			for(int j=0;j<i;j++)
			{
				System.out.print(" ");
			}
			System.out.println("*");
			}
		}
	}
	
	public void printStarColumnWise(int input)
	{
		char[] ch = String.valueOf(input).toCharArray();
		int length = ch.length;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<length;j++)
			{
				int temp = Character.getNumericValue(ch[j]);
				if(temp>0)
				{
					System.out.print("*");
					temp=temp-1;
					ch[j]=Integer.toString(temp).charAt(0);
				}
				else
				{
					System.out.print(" ");
				}
				
			}
			if(sum(ch)==0)
			{
				break;
			}
			System.out.println();
		}
	}
	
	public int sum(char[] ch)
	{
		int sum=0;
		for(int i=0;i<ch.length;i++)
		{
			sum=Character.getNumericValue(ch[i])+sum;
		}
		return sum;
	}
	
}
