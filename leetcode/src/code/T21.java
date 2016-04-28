package code;

public class T21 {
	public static class ListNode{
		int val;
		ListNode next;
	  public ListNode(int x)
		{
			this.val=x;
		}
		public static ListNode arrayToList(int[] arr)
		{
			if(arr==null||arr.length==0)
				return null;
			ListNode p= new ListNode(arr[0]);
			ListNode next=p;
			for(int i=1;i<arr.length;i++)
			{
				next.next=new ListNode(arr[i]);
				next=next.next;
				
			}
			return p;
		}
	}

	public static void main(String[] args) {
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(5);
		ListNode l3=new ListNode(9);
		ListNode l4=new ListNode(12);
		ListNode l5=new ListNode(3);
		ListNode l6=new ListNode(4);
		ListNode l7=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		l5.next=l6;
		l6.next=l7;
		mergeTwoLists(l1, l5);

	}
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null&&l2==null)
	        return null;
	        else if(l1!=null&&l2==null)
	        return l1;
	        else if(l2!=null&&l1==null)
	        return l2;
	       ListNode newhead;
	       ListNode p;
	       ListNode q;
	       ListNode pos;
	        if(l1.val>l2.val)
	        {
	            newhead=l2;
	            p=l1;
	            q=l2.next;
	        }else{
	            newhead=l1;
	            p=l1.next;
	            q=l2;
	        }
	        pos=newhead;
	        while(p!=null&&q!=null)
	        {
	            if(p.val<q.val)
	            {
	                pos.next=p;
	                pos=pos.next;
	                p=p.next;
	            }else{
	                pos.next=q;
	                pos=pos.next;
	                q=q.next;
	            }
	        }
	        if(p!=null)
	        pos.next=p;
	        if(q!=null)
	        pos.next=q;
	        return newhead;
	        
	    }
}
