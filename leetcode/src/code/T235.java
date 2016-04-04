package code;

/**
 * 
 * 算法说明：找二叉查找树中两个节点从同的最小祖先
 *
 */
public class T235 {
	
	 
	  public class TreeNode {
	      int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; left=null;right=null;}
	 }
	 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null||p==null||q==null)
        	return null;
     TreeNode min,pnext,qnext;
     min=root;
     pnext=root;
     qnext=root;
     while(true)
     {
         if(p.val>pnext.val)
            pnext=pnext.right;
         else if(p.val<pnext.val)
            pnext=pnext.left;
         if(q.val>qnext.val)
            qnext=qnext.right;
        else  if(q.val<qnext.val)
            qnext=qnext.left;
           
           if(qnext==null||pnext==null)
                break;
           if(qnext.val==pnext.val)
                if(qnext.val<min.val)
                 min=qnext;
           if(qnext.val!=pnext.val)
            break;
     }
   return min;
   }
    public TreeNode insert(TreeNode root,int node)
    {
    	if(root==null)
    		
    		root=this.new TreeNode(node);
    	else if(node>root.val)
    		root.right=insert(root.right,node);
    	else if(node<root.val)
    		root.left=insert(root.left,node);
    	  return root;
	
    }
	public static void main(String[] args) {
		T235 t=new T235();
		TreeNode root=null,p,q;
		root=t.insert(root, 6);
		t.insert(root, 2);
		t.insert(root, 0);
		t.insert(root, 8);
		t.insert(root, 4);
		t.insert(root, 3);
		t.insert(root, 5);
		
		System.out.println(t.lowestCommonAncestor(root, root.left.right.left, root.left.right.right).val);
	}

}
