package code;

import code.T21.ListNode;

public class T61 {

	public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k<=0)
        return head;
        int len,i;
        len=1;
        i=0;
        ListNode p;
        p=head;
        while(p.next!=null)
        {
            len++;
            p=p.next;
        }
        p.next=head;//ÐÎ³É»·
        p=head;
        k=k%len;
        while(i<len-k)
        {
            p=p.next;
        }
        head=p.next;
        p.next=null;
        return head;
        
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
