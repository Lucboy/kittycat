package code;

public class T136 {

	public static void main(String[] args) {
		

	}
	 public static int singleNumber(int[] nums) {
	        if(nums==null)
	            return 0;
	        int rst=nums[0];
	        int i;
	        for(i=1;i<nums.length;i++)
	        {
	            rst^=nums[i];
	        }
	        return rst;
	        
	    }
}
