package code;

import code.T21.ListNode;

public class T24 {

	 public ListNode swapPairs(ListNode head) {
	        if(head==null)
	          return null;
	        ListNode odd=new ListNode(-1);
	        ListNode even=new ListNode(-1);
	        
	        ListNode p=head,oddp=odd,evenp=even;
	        int i=1;
	        while(p!=null)//把链表按奇偶位置分开
	        {
	            if((i&0x1)==1)
	            {
	              
	                oddp.next=p;
	                p=p.next;
	                oddp=oddp.next;
	                oddp.next=null;
	                
	                
	                
	            }else{
	                evenp.next=p;
	                p=p.next;
	                evenp=evenp.next;
	                evenp.next=null;
	            }
	            i++;
	           
	        }
	        
	        evenp=even.next;//要插入的位置的前驱节点
	        oddp=odd.next;//要插入的节点
	        if(evenp==null)
	          return odd.next;
	        while(evenp!=null&&oddp!=null)
	        {
	            p=oddp;
	            oddp=oddp.next;
	            if(evenp.next==null)//已经到末尾
	            {
	                evenp.next=p;
	                 break;
	            }
	            
	            p.next=evenp.next;
	            evenp.next=p;
	            evenp=evenp.next.next;
	            
	        }
	        
	        return even.next;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
