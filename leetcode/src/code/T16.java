package code;

import java.util.Arrays;

public class T16 {
	 public static int threeSumClosest(int[] nums, int target) {
	        int best=Integer.MAX_VALUE;
	        int sum=0;
	        int threediff=0;
	        int j,k;
	        Arrays.sort(nums);
	    
	        //----------------------------------------------
	        for(int i=0;i<=nums.length-3;i++)
	        {  
	            j=i+1;
	            k=nums.length-1;
	            while(k>j)
	            {
	                threediff=(nums[i]+nums[j]+nums[k])-target;
	                if(threediff==0)
	                      return target;
	                if(Math.abs(threediff)<best){
	                    best=Math.abs(threediff);
	                    sum=nums[i]+nums[j]+nums[k];
	                    System.out.println(nums[i]+","+nums[j]+","+nums[k]);
	                }
	                int a=threediff>0?k--:j++;
	          
	            }
	        }
	        return sum;
	        
	     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={-2,1,4,3};
       threeSumClosest(nums,2);
	}

}
