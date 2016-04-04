package code;

public class T14 {

	public static void main(String[] args) {
		String[] strs={"abcd","abcf","abfred"};
		System.out.println(longestCommonPrefix(strs));

	}
	 public static String longestCommonPrefix(String[] strs) {
	        if(strs==null||strs.length==0)
	        return "";
	        int i=0;//最长公共子序列的长度
	        char[] chars;//备忘录数组
	        int length=strs[0].length();//备忘录数组的长度
	        chars=new char[length];
	        int j=0;
	        for(j=0;j<length;j++)
	        {
	            chars[j]=strs[0].charAt(j);    
	           
	        }
	        i=length-1;
	        for(j=1;j<strs.length;j++)
	        {
	            for(int k=0;k<=i;k++)
	            {
	                if((strs[j].length()>k))
	                {
	                    if((strs[j].charAt(k)!=chars[k]))
	                    {
	                         i=k-1;
	                         break;
	                    }
	                   
	                }else{
	                   
	                    i=strs[j].length()-1;
	                }
	            }
	        }
	       
	       return new String(chars,0,i+1);
	        
	    }
}
