package code;

public class T198 {
	 public int rob(int[] nums) {
	        int[] rest=dp(nums,0);
	        return Math.max(rest[0],rest[1]);
	        
	    }
	    public int[] dp(int[] nums,int pos)
	    {
	        if(pos>=nums.length)
	        return new int[2];
	        int[] rst=new int[2];
	        int[] pre=dp(nums,pos+1);
	        rst[0]=pre[1]+nums[pos];                               //抢当前节点pos
	        rst[1]=Math.max(pre[0],pre[1]);            //不抢当前节点pos
	        return rst;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
