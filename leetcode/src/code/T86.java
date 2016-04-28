package code;

import code.T21.ListNode;

public class T86 {

	public static ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode lower=new ListNode(0);
        ListNode upper=new ListNode(0);
    
        ListNode p,nextLow,nextUp;
        nextLow=lower;
        nextUp=upper;
        p=head;
        while(p!=null)
        {
            if(p.val<x)
            {
                nextLow.next=p;
                p=p.next;
                nextLow=nextLow.next;
                nextLow.next=null;
            }else{
                
                nextUp.next=p;
                p=p.next;
                nextUp=nextUp.next;
                nextUp.next=null;
            }
        }
        nextLow=lower.next;
        nextUp=upper.next;
        
        p=lower;
        lower.next=null;
        while(nextLow!=null)
        {
            p.next=nextLow;
            p=p.next;
            nextLow=nextLow.next;
        }
        while(nextUp!=null)
        {
            p.next=nextUp;
            p=p.next;
            nextUp=nextUp.next;
            
        }
        return head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,5,6,3,2};
		ListNode list=ListNode.arrayToList(arr);
		partition(list,3);

	}

}
