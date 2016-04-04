package code;

//此题要注意翻转一个整数有可能超出int的可表示范围
public class T7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse(-2147483647);

	}
	 public static long reverse(int x) {
		 
		        String digits=x+"";
		        char[] nums=digits.toCharArray();
		        char[] rst=new char[nums.length];
		        int i;
		      
		        if(nums[0]>=48&&nums[0]<=57)//第一个是数字
		        {
		             for(i=nums.length-1;i>=0;i--)
		             {
		                rst[nums.length-i-1]=nums[i];
		             }
		        }else{
		             rst[0]=nums[0];
		             for(i=nums.length-1;i>0;i--)
		             {
		                rst[nums.length-i]=nums[i];
		             }
		            
		            
		        }
		        
		        
		        digits=String.valueOf(rst);
		        //这里要考虑翻转后不能超出int的表示范围，先放到long里面在比较
		        long number=Long.parseLong(digits);
		        if(number<-2147483648||number>2147483647)//out of range
		             return 0;
		        else 
		            return (int)number;
		        
		        
		        
		    }
	        
	    

}
