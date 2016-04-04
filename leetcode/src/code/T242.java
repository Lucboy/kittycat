package code;

public class T242 {
	private static int[][] str=new int[26][2];
	private static  boolean isAn=true;
	public static void hash(String source,int flag)//flag表示是以第一次映射还是比较过程
	{
		int i,j=0;
		int pos;
		while(j<source.length())
		{
			pos=source.charAt(j)%26;

			if(flag==0)//如果是填充过程
			{
				if(str[pos][1]==0)
				{
					str[pos][0]=source.charAt(j);
					str[pos][1]=1;
				}else{
					str[pos][1]++;
				}
			}
			
			if(flag==1)//如果是比较过程
			{
				if(str[pos][1]==0)//说明前一个字符串没有该字符
				{
					isAn=false;
				}
				if(str[pos][1]!=0)
				{
					str[pos][1]--;
				}
				
			}
		   
			j++;
		}
		if(flag==1)
		{
			for(i=0;i<26;i++)
			{
				if(str[i][1]!=0)
					isAn=false;
			}
		}
		
	}
	public static  boolean isAnagram(String source,String compare)
	{
		if(source==null||compare==null)
			return false;
		if(source.length()!=compare.length())
			return false;
		hash(source.trim(),0);
		hash(compare.trim(),1);
		return isAn;
	}
	public static void main(String[] args) {
		
		System.out.println(isAnagram("ab","ba"));
	}

}
