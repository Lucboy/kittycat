package code;

import java.util.LinkedList;

public class T225 {
	
	private  LinkedList<Integer> queue=new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if(queue!=null)
            queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!empty())
         {
             int size=queue.size();
             queue.remove(size-1);
         }
    }

    // Get the top element.
    public int top() {
        if(!empty())
        {
            return queue.get(queue.size()-1);
        }
        return -1;
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue==null)
          return true;
        if(queue.size()==0)
          return true;
        return false;
    }
	public static void main(String[] args) {
		T225 t=new T225();
		t.push(1);
		t.push(2);
		t.push(3);
		
		System.out.println(t.top());
		t.pop();
		System.out.println(t.top());
		t.pop();
		System.out.println(t.top());
		t.pop();
		t.pop();
	}

}
