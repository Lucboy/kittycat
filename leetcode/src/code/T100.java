package code;

import dataStruct.TreeNode;

public class T100 {
	 public boolean check(TreeNode A,TreeNode B)
	    {
	        if(A==null&&B==null)
	            return true;
	        if(A==null&&B!=null)
	            return false;
	        if(A!=null&&B==null)
	            return false;
	        if(A.val!=B.val)
	        {
	            return false;
	        }else{
	            boolean left=check(A.left,B.left);
	            boolean right=check(A.right,B.right);
	            if(left==false||right==false)
	                return false;
	            else
	                return true;
	        }
	    }
	
}
