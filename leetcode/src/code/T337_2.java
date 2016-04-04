package code;

import dataStruct.TreeNode;

public class T337_2 {
	 public int rob(TreeNode root) {
	       int[] rest=dfs(root);
	       return Math.max(rest[0],rest[1]);
	        
	    }
	    public int[] dfs(TreeNode root)
	    {
	        if(root==null)
	        return new int[2];
	        int[] left=dfs(root.left);
	        int[] right=dfs(root.right);
	        int[] rst=new int[2];//定义状态记录备忘录，rst[0]表示抢劫当前节点，[1]表示不抢劫当前节点；
	        //状态转移方程
	        rst[0]=root.val+left[1]+right[1];
	        rst[1]=Math.max(left[0],left[1])+Math.max(right[1],right[0]);
	        return rst;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
