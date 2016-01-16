package leed_code;

import java.util.LinkedList;

import dataStruct.TreeNode;

public class T226 {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode t1=new TreeNode(2);
		TreeNode t2=new TreeNode(3);
		root.left=null;
		root.right=t1;
		
		invertTree(root);
		
		System.out.println();

	}
	 public static TreeNode invertTree(TreeNode root) {
	        if(root==null)
	            return null;
	        TreeNode temp;
	        if(root.left==null&&root.right!=null)
	        {
	            root.left=root.right;
	            root.right=null;
	        }
	        else if(root.right==null&&root.left!=null)
	        {
	            root.right=root.left;
	            root.left=null;
	        }else if(root.left!=null&&root.right!=null)
	        {
	          temp=root.left;
	          root.left=root.right;
	          root.right=temp;
	        }
	        invertTree(root.left);
	        invertTree(root.right);
	        return root;
	        
	    }
}
