package code;

public class T8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println( myAtoi("-+123"));
		
	}
	 public static int myAtoi(String str) {
	        if(str==null)
	        return 0;
	        str=str.trim();
	       
	        int length=0;//有效数字的长度
	        int[] num; 
	        int flag=0; //  正负符号
	        char c1,c2;
	        int i=0; //数字开始
	        if(!(str.length()>0))
	            return 0;
	        if(str.length()==1){
	            c1=(char)(str.charAt(0)-48);
	            if(c1>=0&&c1<=9)
	             return c1;
	            else
	             return 0;
	            
	        }
	        if(str.length()>1)
	        {
	            c1=str.charAt(0);
	            c2=str.charAt(1);
	            if(c1=='-')
	            {
	                if(c2=='-')
	                {
	                    flag=1;
	                    i=2;
	                }
	                else if(c2=='+'){
	                    flag=0;
	                    i=2;
	                }
	                else{
	                     flag=-1;
	                     i=1;
	                }
	                 
	            }else if(c1=='+')
	            {
	                if(c2=='-'){
	                     flag=0;
	                     i=2;
	                }
	                
	                else if(c2=='+')
	                {
	                     flag=1;
	                     i=2;
	                }
	                else{
	                    flag=1;
	                    i=1;
	                }
	                  
	            }else{
	                i=0;
	                flag=1;
	            }
	            
	            
	                
	        }
	        
	        //-------确定符号
	        
	             length=str.length()-i;
	             
	             num=new int[length];
	             for(int j=length-1 ;j>=0;j--)
	             {   
	              if((num[j]=str.charAt(j+i)-48)>=0&&num[j]<=9)
	                ;
	             else
	                return Integer.MIN_VALUE;
	             }
	       
	           
	       
	        long sum=0;
	        for(i=length-1;i>=0;i--)
	        {
	            int time=1; //进位的倍数
	            for(int count=0;count<length-i-1;count++)
	            {
	                time*=10;
	            }
	            sum+=num[i]*time;
	           
	        }
	         sum*=flag;
	        if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
	           return 0;
	        return (int)sum;
	 }

}
