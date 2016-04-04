package code;

public class T190 {

	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
		

	}
	 public static int reverseBits(int n) {
	        int sum=0;
	        int x=1;
	        for(int k=0;k<32;k++)
	        {
	        	x=1;
	            x=x<<k;
	           //n&x 可以提取每一个bit ,(n&x>>>k)<<(32-k)达到低比特位移向高比特位，|运算相当于加法
	            sum=sum|((((n&x)>>>k)<<(31-k)));
	            
	        }
	        return sum;
	    }
}
