package code;

import code.T21.ListNode;

public class T206 {

	 public ListNode reverseList(ListNode head) {
	        if(head==null)
	            return head;
	        ListNode ppre,p,psuc;
	        ppre=head;
	        p=head.next;
	        ppre.next=null;
	        while(p!=null)
	        {
	            psuc=p.next;
	            p.next=ppre;
	            ppre=p;
	            p=psuc;
	            
	        }
	        return ppre;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
