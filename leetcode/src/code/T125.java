package code;

public class T125 {

	public static void main(String[] args) {
		System.out.println(isPalindrome("a."));

	}
	public static boolean isPalindrome(String s) {
        if(s==null)
            return false;
         int i,j,length;
          s=s.trim();
         length=s.length();
        
        char[] origin=s.toCharArray();
        char netchar[]=new char[length];
        boolean flag=true;
        for(i=0,j=0;i<length;i++)
        {
            if((origin[i]>=97&&origin[i]<=122)||(origin[i]>=65&&origin[i]<=90)||(origin[i]>=48&&(origin[i]<=57)))
                netchar[j++]=origin[i];
        }
        s=String.valueOf(netchar).trim().toLowerCase();
        netchar=s.toCharArray();
        for(i=0,j=netchar.length-1;i<=j;i++,j--)
        {
            if(netchar[i]!=netchar[j])
                flag=false;
                
        }
        return flag;
        
        
    }

}
