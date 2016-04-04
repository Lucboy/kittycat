package code;

import java.util.HashMap;

public class T290 {

	 public boolean wordPattern(String pattern, String str) {
	        String[] words=str.split(" ");
	        if(words.length!=pattern.length())
	        return false;
	        
	        HashMap<String,Character> hash=new HashMap<>();
	        int length=pattern.length();
	        for(int i=0;i<length;i++)
	        {
	            char c=pattern.charAt(i);
	            if(!hash.containsKey(words[i]))
	            {   if(hash.containsValue(c))
	                {
	                    return false;
	                }else
	                    hash.put(words[i],c);
	            }else{
	                if(!(hash.get(words[i])-c==0))
	                    return false;
	            }
	            
	        }
	        return true;
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
