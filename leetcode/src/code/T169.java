package code;

public class T169 {

	 public int majorityElement(int[] nums) {
	        int pre=nums[0];//记录之前出现过的数字
	        int count=1;//记录出现的次数
	        for(int i=1;i<nums.length;i++)
	        {
	            if(nums[i]==pre)
	                count++;
	            else{
	                count--;
	                if(count==0){
	                pre=nums[i];
	                count++;
	                    
	                }
	            }
	            
	        }
	        
	        return pre;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
