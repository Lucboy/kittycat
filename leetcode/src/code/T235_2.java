package code;

import java.util.LinkedList;

public class T235_2 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	  };
	public static void main(String[] args) {
		
		 
		}
	  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null)
	        return null;
	        if(p==null||q==null)
	        return null;
	        
	        LinkedList<TreeNode> ancs=new LinkedList<TreeNode>();
	        //---------find the ancestors of p
	        TreeNode nexac=root;
	        while(nexac!=null)
	        {
	            ancs.add(nexac);
	            if(p.val>nexac.val)
	                nexac=nexac.right;
	            else if(p.val<nexac.val)
	                nexac=nexac.left;
	            else
	                break;
	        }
	        //---------find the lowest common ancestor
	        nexac=root;
	        TreeNode lowestanc=root;
	        int ancs_pos=0;
	        while(nexac!=null)
	        {
	            if(nexac.val>q.val)
	            {
	                nexac=nexac.left;
	                ancs_pos++;
	                if(ancs_pos>=ancs.size()||(ancs.get(ancs_pos).val!=nexac.val))//如果分叉了就跳出
	                {
	                    break;
	                }else{
	                    if(nexac.val<lowestanc.val)//比较当前祖先与的值是否是最小
	                        lowestanc=nexac;
	                }
	            }
	           else if(nexac.val<q.val)
	            {
	                nexac=nexac.right;
	                ancs_pos++;
	                if(ancs_pos>=ancs.size()||(ancs.get(ancs_pos).val!=nexac.val))//如果分叉了就跳出
	                {
	                    break;
	                }else{
	                    if(nexac.val<lowestanc.val)//比较当前祖先与的值是否是最小
	                        lowestanc=nexac;
	                }
	            }else{
	                break;
	            }
	            
	        }
	        return lowestanc;
	    }
	}


