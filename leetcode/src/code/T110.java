package code;

public class T110 {
	class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
	    public TreeNode(int x)
		{
			val=x;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 boolean flag=true;
	    public boolean isBalanced(TreeNode root) {
	        int depth=0;
	        if(root==null)
	            return true;
	        int leftd=depth(root.left);
	        int rightd=depth(root.right);
	        if(!flag)
	        {
	            return false;
	        }
	        if(Math.abs(leftd-rightd)<2)
	        {
	             return true;
	            
	        }else{
	            return false;
	        }
	        
	        
	    }
	    public int depth(TreeNode root)
	    {
	        if(root==null)
	        return 0;
	        int leftd=0;
	        int rightd=0;
	        leftd=depth(root.left);
	        rightd=depth(root.right);
	        if(Math.abs(leftd-rightd)>1)//²»Æ½ºâÀ²
	            flag=false;
	        return leftd>rightd?leftd+1:rightd+1;
	    }
}
