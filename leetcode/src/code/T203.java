package code;

import code.T21.ListNode;

public class T203 {

	 public ListNode removeElements(ListNode head, int val) {
	       
	        ListNode pre,p;
	        while(head!=null&&head.val==val)
	        {
	            head=head.next;
	        }
	        if(head==null)
	            return head;
	        
	        pre=head;
	        p=pre.next;
	       
	        while(p!=null)
	        {
	            if(p.val==val)
	            {
	                pre.next=p.next;
	                p=pre.next;
	            }
	            else{
	                pre=p;
	                p=pre.next;
	            }
	        }
	        return head;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
