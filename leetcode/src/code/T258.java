package code;

public class T258 {

	public static void main(String[] args) {
		System.out.println(addDigits(38));

	}
	public static int addDigits(int num)
	{
		if(num<=0)
			return 0;
		String n=num+"";
		char[] digits=n.toCharArray();
		int i;
		int sum=0;
		while(true)
		{
			sum=0;
			for(i=0;i<digits.length;i++)
			{
				sum+=digits[i]-48;
			}
			if(sum>0&&sum<=9)
				break;
			else{
				n=sum+"";
				digits=n.toCharArray();
			}
		
			
		}
		return sum;
	}

}
