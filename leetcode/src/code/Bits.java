package code;

public class Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(7));

	}
	 public static int hammingWeight(int n) {
	        int count=0;
	        int i;
	        for(i=1;i<=32;i++)
	        {
	            if(((n>>>i)&1)==1)
	                count++;
	        }
	        return count;
	        
	    }
}
