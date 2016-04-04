package code;

import java.util.ArrayList;
import java.util.LinkedList;

import dataStruct.TreeNode;

public class T337 {

	 public int rob(TreeNode root) {
	        if(root==null)
	          return 0;
	        LinkedList<TreeNode> Lqueue=new LinkedList<TreeNode>();
	        LinkedList<TreeNode> Tqueue=new LinkedList<TreeNode>();
	        ArrayList<Integer> counter=new ArrayList<>();//统计每层的钱数
	        Lqueue.offer(root);
	         int level=0;//层数
	         int count=0;//每层的钱数
	        while(!Lqueue.isEmpty()||!Tqueue.isEmpty())
	        {
	           count=0;
	           TreeNode t=null;
	           while((t=Lqueue.poll())!=null)
	           {
	               count+=t.val;
	               Tqueue.offer(t);
	           }
	           counter.add(level,count);
	           level++;
	           
	           while((t=Tqueue.poll())!=null)
	           {
	               if(t.left!=null)
	                  Lqueue.offer(t.left);
	               if(t.right!=null)
	                 Lqueue.offer(t.right);
	           }
	          
	        }
	        int start0=0;
	        int start1=0;
	        for(int i=0;i<counter.size();i++)
	        {
	            if(i%2==0)
	                start0+=counter.get(i);
	            else
	                start1+=counter.get(i);
	        }
	        return start0>start1?start0:start1;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
