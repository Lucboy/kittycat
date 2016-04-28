package code;

import code.T21.ListNode;

public class T83 {

	 public ListNode deleteDuplicates(ListNode head) {
	        if(head==null)
	            return head;
	        ListNode p,psuc;
	        p=head;
	        psuc=p.next;
	        while(psuc!=null)
	        {
	            
	            if(p.val==psuc.val)
	            {
	                p.next=psuc.next;
	                psuc=p.next;
	            }else{
	                p=psuc;
	                psuc=p.next;
	            }
	            
	        }
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
