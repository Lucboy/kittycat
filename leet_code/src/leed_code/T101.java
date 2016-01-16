package leed_code;

import java.util.LinkedList;

import dataStruct.TreeNode;

public class T101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode t1=new TreeNode(2);
		TreeNode t2=new TreeNode(2);
		root.left=t2;
		root.right=t1;
		System.out.println(isSymmetric(root));

	}
	public static boolean isSymmetric(TreeNode root) {
		 if(root==null)
	         return false;
	        
	        LinkedList<TreeNode> leftStack=new LinkedList<TreeNode>();//
	         LinkedList<TreeNode> rightStack=new LinkedList<TreeNode>();
	         leftStack.add(root.left);//×ó×ÓÊ÷ÈëÕ»
	         rightStack.add(root.right);//ÓÒ×ÓÊ÷ÈëÕ»
	         TreeNode left;
	         TreeNode right;
	         int leftsize;
	         int rightsize;
	         while((leftsize=leftStack.size())>0&&(rightsize=rightStack.size())>0)
	         {
	             left=leftStack.removeLast();//×ó³öÕ»
	             right=rightStack.removeLast();//ÓÒ³öÕ»
	             if((left!=null&&right!=null))
	             {
	               if(left.val!=right.val)
	                return false;
	               leftStack.add(left.right);
	               leftStack.add(left.left);
	               rightStack.add(right.left);
	               rightStack.add(right.right);
	             
	             }else if((left!=null&&right==null)||(left==null&&right!=null))
	             {
	                 return false;
	                 
	             }
	              
	         }
	        
	             return true;
	        
	}
         
         
        
}
