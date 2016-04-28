package code;

import java.util.LinkedList;
import java.util.List;

import dataStruct.TreeNode;

public class T107 {

	 public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	       
	       
         LinkedList<TreeNode> cur=new LinkedList<TreeNode>();
         LinkedList<TreeNode> next=new LinkedList<TreeNode>();
         List<List<Integer>> rst=new  LinkedList<List<Integer>>();
         //LinkedList<Integer> level=new LinkedList<Integer>();
        if(root==null)
            return rst;
        cur.add(root);
         LinkedList<Integer> level;
        while(cur.size()>0||next.size()>0){
            level=new LinkedList<Integer>();
             while(!cur.isEmpty())
             {   
                  
                TreeNode node=cur.remove(0);
                level.add(node.val);
                if(node.left!=null)
                    next.add(node.left);
                if(node.right!=null)
                   next.add(node.right);
             }
             rst.add(0,level);
             
             cur=next;
             next=cur;
        }
        return rst;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr={3,9,20,15,7,3,4,6};
       TreeNode root=null;
       for(int i=0;i<arr.length;i++)
       {
    	   TreeNode.insert(root, arr[i]);
       }
       levelOrderBottom(TreeNode.getRoot());
		
	}

}
