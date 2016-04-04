package code;

public class T28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("mississippi", "pi"));
	}
	 public static int strStr(String haystack, String needle) {
	        if(haystack==null||needle==null)
	         return -1;
	        else if(needle=="")
	         return 0;
	        
	        int h,n ;// 两个位置指针
	        h=0;
	        n=0;
	        int hlen=haystack.length();
	        int nlen=needle.length();
	        if(hlen<nlen)
	        {
	            return -1;
	        }
	        while(h<hlen)
	        {
	            while((h<hlen)&&(haystack.charAt(h)!=needle.charAt(0)))//直到下一个匹配的开头
	            {
	            	
	                h++;
	            }
	            if(h<=hlen-nlen)
	            {
	                n=0;
	                while(n<nlen)
	                {
	                    if(haystack.charAt(h)==needle.charAt(n))
	                    {
	                        h++;
	                        n++;
	                    }else{
	                       break;
	                    }
	                    
	                }
	                if(n==nlen)//找到了
	                    return h-nlen;
	                else
	                	h=h-n+1;//没找到，h回退
	                
	            }else{
	                return -1;
	            }
	            
	        }
	        return -1;
	        
	    }
	
}
