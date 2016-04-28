package code;

import code.T21.ListNode;

public class T143 {
	  //从[n/2]位置开始逆转，然后插入
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        int len=0;
       ListNode  p=head;
        while(p!=null)
        {
            len++;
            p=p.next;
        }
        int start=len/2+1;
        p=head;
        int i=1;
        while(i++<start)
        {
            p=p.next;   
        }
        ListNode  begin=p.next;
        p.next=null;
        ListNode  cur;
        ListNode rever=new ListNode(0);
        while(begin!=null)
        {
             cur=begin;
             begin=begin.next;
             cur.next=rever.next;
             rever.next=cur;
        }
        //现在开始插入
        p=head;
        begin=rever.next;
        while(begin!=null)
        {
            cur=begin;
            begin=begin.next;
            cur.next=p.next;
            p.next=cur;
            p=p.next.next;
        }
        
        
        
        
    }

}
