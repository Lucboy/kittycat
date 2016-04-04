package code;

public class T29 {

	 public static int divide(int dividend, int divisor) {
	        if(divisor==0)
	        return Integer.MAX_VALUE;
	        
	        //先判断两个数的符号
	        int signal=((dividend&(0x1<<31))^(divisor&(0x1<<31)))<0?-1:1;
	        System.out.println(((divisor&(0x1<<31))));
	        System.out.println(signal);
	        long Ldividend=Math.abs(dividend);
	        long Ldivisor=Math.abs(divisor);
	        int res=0;
	        long temp;
	        while(Ldividend>=Ldivisor)
	        {
	            int factor=1;
	            temp=Ldivisor;
	            while((temp<<1)<=Ldividend)
	            {
	                temp<<=1;
	                factor<<=1;
	            }
	            Ldividend-=temp;
	            res+=factor;
	            
	            
	        }

	        return res*signal;
	    }
	       
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-18,3));
	}

}
