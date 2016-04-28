package dataStruct;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public static TreeNode root;
	public TreeNode(int x)
	{
		val=x;
	}
  public static TreeNode insert(TreeNode root,int x)
  {
	  if(root==null)
		  root=new TreeNode(x);
	  else if(root.left==null){
		  root.left=insert(root.left,x);
		  
		  
	  }else if(root.right==null)
	  {
		  root.right=insert(root.right,x);
	  }
	  return root;
  }
  public static TreeNode getRoot()
  {
	  return root;
  }
}
