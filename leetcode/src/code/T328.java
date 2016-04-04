package code;

import code.T21.ListNode;

public class T328 {

	 public ListNode oddEvenList(ListNode head) {
	        ListNode odd,even,oddnext,evennext,pnext;
	        odd=new ListNode(-1);
	        even=new ListNode(-1);
	        oddnext=odd;
	        evennext=even;
	        pnext=head;
	        int i=0;
	        while(pnext!=null)
	        {   i++;
	           
	            if(i%2==1)
	            {
	                
	                oddnext.next=pnext;
	                pnext=pnext.next;
	                oddnext=oddnext.next;
	                oddnext.next=null;
	            }
	            else
	            {
	                evennext.next=pnext;
	                pnext=pnext.next;
	                evennext=evennext.next;
	                evennext.next=null;
	            }
	        }
	        pnext=even.next;
	        while(pnext!=null)
	        {
	            oddnext.next=pnext;
	            oddnext=oddnext.next;
	            pnext=pnext.next;
	        }
	        return odd.next;
	       
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
