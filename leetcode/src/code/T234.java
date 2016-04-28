package code;

import code.T21.ListNode;

public class T234 {

	 public boolean isPalindrome(ListNode head) {
	        if(head==null)
	            return true;
	        ListNode pre,p,psuc;
	        int len=0;
	        p=head;
	        while(p!=null)
	        {
	            p=p.next;
	            len++;
	        }
	        int i=0;
	        len=len/2;
	        pre=head;
	        while(i<len)
	        {
	            pre=pre.next;
	            i++;
	        }
	        p=pre.next;
	       
	        while(p!=null)
	        {
	             psuc=p.next;
	              p.next=pre;
	              pre=p;
	              p=psuc;
	             
	        }
	        i=0;
	        p=head;
	        psuc=pre;
	        while(i<len)
	        {
	            if(p.val!=psuc.val)
	                return false;
	            else{
	                p=p.next;
	                psuc=psuc.next;
	            }
	            i++;
	        }
	        return true;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
