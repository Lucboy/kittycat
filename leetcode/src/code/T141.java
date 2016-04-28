package code;

import code.T21.ListNode;

public class T141 {

	 public boolean hasCycle(ListNode head) {
	        if(head==null)
	            return false;
	        ListNode p,q;
	        p=head;
	        q=head;
	        while(true)
	        {
	            if(p!=null&&q!=null)
	            {
	                p=p.next;
	                q=q.next;
	                if(q==null)
	                {
	                    return false;
	                }else{
	                    q=q.next;
	                }
	            }else{
	                return false;
	            }
	            if(p==q)
	                return true;
	            
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
