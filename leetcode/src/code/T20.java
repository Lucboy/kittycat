package code;

import java.util.LinkedList;

public class T20 {

	public static void main(String[] args) {
		System.out.println(isValid("()]"));

	}
	 public static  boolean isValid(String s) {
	        if(s==null||s=="")
	        {
	            return true;
	        }
	        int  i=-1,j=-2;//分别指向栈顶和次栈顶
	        int length=s.length();//字符串长度
	        LinkedList<Character> stack=new LinkedList<>();
	        for(int k=0;k<length;k++)
	        {
	            stack.add(s.charAt(k));
	            i++;//栈顶
	            j++;//次栈顶
	            if(i>=0&&j>=0)
	            {
	                if(isPair(stack.get(j),stack.get(i)))
	                {
	                    stack.remove(i);
	                    stack.remove(j);
	                    i-=2;
	                    j-=2;
	                }
	            }
	            
	            
	        }
	        
	        if(stack.size()!=0)
	            return false;
	        else 
	             return true;
	    }
	    public static boolean isPair(char c1,char c2)
	    {
	        if(c1=='('&&c2==')')
	             return true;
	        else if(c1=='['&&c2==']')
	             return true;
	        else if(c1=='{'&&c2=='}')
	             return true;
	        else 
	             return false;
	    }
}
