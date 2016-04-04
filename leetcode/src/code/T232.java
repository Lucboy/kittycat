package code;

import java.util.ArrayList;

public class T232 {
	
	private static  ArrayList<Integer> stack=new ArrayList<Integer>();
	private static  ArrayList<Integer> stackbak=new ArrayList<Integer>();
	private static int stack_top=-1;//¼ÇÂ¼Õ»¶¥Î»ÖÃ
	
    // Push element x onto stack.
	   // Push element x to the back of queue.
    public void push(int x) {
        if(stack!=null)
        {
        	stack.add(x);
        	stack_top++;
        	
        }
    }


    // Get the front element.
    public int peek() {
    	if(!empty())
    	{
    		
    		return stack.get(0);
    		
    	}
    		
    	return -1;
    }

    
    // Removes the element on top of the stack.
    public void pop() {
        if(!empty())
         {
             
             stack.remove(0);
             stack_top--;
         }
    }

  

    // Return whether the stack is empty.
    public boolean empty() {
        if(stack==null)
          return true;
        if(stack_top==-1)
          return true;
        return false;
    }
	public static void main(String[] args) {
		T232 t=new T232();
		t.push(1);
//		t.pop();
//		t.pop();
		System.out.println(t.empty());
//		System.out.println(stack_top);
//		t.pop();
//		System.out.println(t.peek());
//		System.out.println(stack_top);
//		t.pop();
//		System.out.println(t.peek());
//		System.out.println(stack_top);
//		t.pop();
//		t.pop();
	}

}
