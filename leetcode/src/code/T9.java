package code;

public class T9 {

	public static boolean isPalindrome(int x) {
        String str=x+"";
        int length=str.length();
        int i,j;
        
        if((length&0x1)==0)//Å¼Êý
        {
            i=0;
            j=length-1;
            while(i<j)
            {
                if(str.charAt(i)-str.charAt(j)!=0)
                    return false;
                i++;
                j--;
                
            }
            return true;
        }else{
            int mid=(length+1)/2;
            i=mid-1;
            j=mid+1;
            while(i>=0&&j<length)
            {
                if(str.charAt(i)-str.charAt(j)!=0)
                    return false;
                i--;
                j++;
                
            }
            return true;
            
            
            
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(-10));

	}

}
