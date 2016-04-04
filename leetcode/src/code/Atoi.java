package code;


public class Atoi {

	public static void main(String[] args) {
		Atoi atoi=new Atoi();
		System.out.println(atoi.myAtoi("  -1"));

	}
	 public int myAtoi(String str) {
	        if(null==str)
	        	return 0;
	        char cur='0',next='0';
	        int i,j=0;
	        int begin;
	        int sum=0;
	        int time=1;
	        int length=str.length();
	        int sign=0;
	    
	        //先对字符串进行预处理去掉前面的无效0和空格，确定符
	        
	        for(i=length-1;i>=0;i--)
	        {
	            cur=str.charAt(i);
	           
	            if(cur>=48&&cur<=57)
	            {
	                   j=length-i-1;
	                    while(j-->0)
	                    {
	                        time*=10;
	                    }
	                    sum+=(cur-48)*time;
	                    time=1;
	             
	            }else{//找到第一个非数字字符
	               break;
	            }
	            
	        }
	        //处理第一个非数字字符
	        
	        if(cur=='+')
	        {
	        	if(i>0){
	        		next=str.charAt(i-1);
	        		if(next=='+'){
	        			sign=1;
	        			begin=i-1;
	        		}
	        			
	        		else if(next=='-')
	        		{
	        			sign=0;
	        			begin=i-1;
	        		}
	        		else 
	        		{
	        			begin=i;
	        			sign=0;
	        		}
	        			
	        	}else {
	        		begin=0;
	        		sign=1;
	        	}
	   
	        }else if(cur=='-')
	        {
	        	if(i>0){
	        		next=str.charAt(i-1);
	        		if(next=='+')
	        		{
	        			sign=0;
	        			begin=i-1;
	        		}
	        			
	        		else if(next=='-')
	        		{
	        			sign=1;
	        			begin=i-1;
	        		}
	        		else {
	        			sign=0;
	        			begin=i;
	        		}
	        			
	        	}else 
	        	{  
	        		begin=0;
	        		sign=-1;
	        	}
	
	        }else if(cur==' '){
	        		begin=i;
	        		sign=1;
	        }else//既非数字又非符号
	        {
	        	 return 0;
	        	 
	        }
	        //检测剩余的字符是否既非数字又非符号
	        for(j=0;j<begin;j++)
	        {	       
	        	if(str.charAt(j)!=' ')
	        	return 0;
	        }
	        
	        if(sign<0)
	              sum*=-1;
	        if(sign==0)
	             sum=0;
	        return sum;
	    }
	
	
}
