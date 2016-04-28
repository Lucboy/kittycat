package code;

import code.T21.ListNode;

public class T92 {
	//利用尾插法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return head;
        if(m>=n)
            return head;
        //给链表加一个头结点，防止从head开始反转的特殊情况
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        //反转从 m+1 至 n+1 
        ListNode begin,cur,p,plast;
        int i=1;
        p=newhead;
        while(i++<m)
        {
            if(p==null)
                return head;
            p=p.next;
            
        }
        begin=p;
        plast=begin.next;
        p=begin.next;
        begin.next=null;
        i=m+1;
        while(i++<=n+1)
        {
            if(p==null)
                return head;
            cur=p;
            p=p.next;
            cur.next=begin.next;
            begin.next=cur;
        }
        plast.next=p;
        return newhead.next;
        
        
        
        
    }

}
