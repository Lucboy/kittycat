package code;

public class T26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,1,2,2,2,3,4,5};
		System.out.println(removeDuplicates(nums));
	}
	  public static int removeDuplicates(int[] nums) {
	        if(nums==null||nums.length==0)
	        return 0;
	        if(nums.length==1)
	        return 1;
	        
	        int pre;
	   
	        pre=nums[0];
	        int count=1;//记录没有重复的长度
	        for(int i=1;i<nums.length;i++)
	        {
	            if(nums[i]!=pre)
	            {
	                count++;
	                pre=nums[i];
	            }
	        }
	        return count;
	        
	        
	        
	    }

}
