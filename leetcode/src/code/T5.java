package code;

public class T5 {
	 public static String longestPalindrome(String s) {
	       //先用数组把s存起来
	       char[] str=new char[s.length()];
	       int begin,end,bi=0,ei=0,maxlen;
	       int curlen;
	       int[] pos=new int[2];//记录回文的起始位置
	       maxlen=0;
	       for(int i=0;i<str.length;i++)
	       {
	    	   str[i]=s.charAt(i);
	       }
	       for(begin=0;begin<str.length;begin++)//从前往后看
	       {
	           bi=begin;
	           curlen=0;
	           for(end=str.length-1;end>begin;end--)//从后往前找
	           {
	               if(str[end]-str[begin]==0)
	               {
	                   ei=end;
	                   break;
	               }
	               
	           }
	           
	        	   while(bi<ei)//涉及到奇数和偶数的问题
		           {
		               if(str[bi]-str[ei]!=0)
		               {
		                   break;
		               }
		               bi++;
		               ei--;
		               
		           }
		           if(bi>=ei)
		                curlen=(end-begin)+1;
		           else
		                curlen=1;
	        	   
	          
	           if(maxlen<curlen)
	           {   maxlen=curlen;
	               pos[0]=begin;
	               pos[1]=end;
	           }
	           
	 }
	       return s.substring(pos[0],pos[1]+1);
	           
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(longestPalindrome("abb"));
	}

}
