package code;

import java.util.LinkedList;

public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING",3)));
		
		

	}
	
	public  static String convert(String s, int numRows) {
	        if(s==null||numRows<=0)
	            return null;
	        if(numRows==1)
	            return s;
	        
	        int t=numRows+numRows-2;//周期
	        int k=0; //新的字符数组中下一个要访问的位置
	        int nextpos;//s字符串中下一个要访问的位置
	        int nt=1; //下一次周期的倍数
	        int length=s.length();
	        char[] news=new char[length];
	        {
	        	
	        	nextpos=0;
	        	while(nextpos<length)
	        	{
	        		news[k++]=s.charAt(nextpos);
	        		
	        		nextpos=t+nextpos;
	        		
	        	}
	        }
	        
	        for(int i=1;i<numRows-1;i++)
	        {
	        	nt=1;
	        	nextpos=i;
	        	while(nextpos<length)
	        	{
	        		news[k++]=s.charAt(nextpos);
	        		
	        		nextpos=nt*t-nextpos;
	        		nt++;
	        	}
	        }
	        
	        {
	        	
	        	nextpos=numRows-1;
	        	while(nextpos<length)
	        	{
	        		news[k++]=s.charAt(nextpos);
	        		
	        		nextpos=t+nextpos;
	        		
	        	}
	        }
	        return  new StringBuilder().append(news).toString();
	      
	 }
}
