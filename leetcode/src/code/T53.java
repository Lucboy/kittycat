package code;

public class T53 {

	 public int maxSubArray(int[] nums) {
	       
	       int cursum=nums[0];
	       int max=nums[0];
	        for(int i=1;i<nums.length;i++)
	        {
	            cursum=cursum<0?nums[i]:cursum+nums[i];
	            max=Math.max(cursum,max);
	        }
	      return max;
	    }
	public static void main(String[] args) {
	
		
	}

}
