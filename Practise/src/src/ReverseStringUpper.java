package src;

public class ReverseStringUpper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStringUpper s = new ReverseStringUpper();
		s.reversestr("Hi! This is Lithium Technologies");

	}
	
	public void reversestr(String str)
	{
		String[] ip;
		ip=str.split(" ");
		StringBuffer op = new StringBuffer();
		for(int i= 0; i<ip.length;i++)
		{
			if(i==0)
			{
				op.append(ip[i].toUpperCase());
				op.append(" ");
				continue;
			}
			if(i==1)
			{
				String ip2 = ip[i];
				for(int j=ip2.length()-1;j>=0;j--)
				{
					
					op.append(ip2.charAt(j));
				}
				op.append(" ");
				continue;
			}
			if((i%2==0))
			{
				op.append(ip[i].toUpperCase());
				op.append(" ");
			}
			else
			{
				
				String ip2 = ip[i];
				for(int j=ip2.length()-1;j>=0;j--)
				{
					
					op.append(ip2.charAt(j));
				}
				op.append(" ");
			}
		}
		System.out.println(op);
	}

}
