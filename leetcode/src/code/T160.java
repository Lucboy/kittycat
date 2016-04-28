package code;

import code.T21.ListNode;

public class T160 {

	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int Alen,Blen;
	        ListNode pa,pb;
	        if(headA==null||headB==null)
	            return null;
	        pa=headA;
	        pb=headB;
	        Alen=0;
	        Blen=0;
	        while(pa!=null)
	        {
	            pa=pa.next;
	            Alen++;
	        }
	        while(pb!=null)
	        {
	            pb=pb.next;
	            Blen++;
	        }
	        pa=headA;
	        pb=headB;
	        while(Alen>Blen)
	        {
	            pa=pa.next;
	            Alen--;
	        }
	        while(Blen>Alen)
	        {
	            pb=pb.next;
	            Blen--;
	        }
	        while(pa!=null&&pb!=null)
	        {
	            if(pa==pb)
	                return pa;
	            else{
	                pa=pa.next;
	                pb=pb.next;
	            }
	        }
	        return null;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
