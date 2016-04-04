package code;

import java.util.HashSet;
import java.util.Set;

public class T202 {

	public static void main(String[] args) {
		System.out.println(isHappy(2));

	}
	public static boolean isHappy(int n) {
        int sum=0;
        Set<Integer> set=new HashSet<Integer>();
        
        while(true)
        {   
            set.add(n);
            sum=0;
            while(n!=0)
            {
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            if(sum==1)
            return true;
            else if(set.contains(sum))
            return false;
            n=sum;
                       
        }
        
        
    }
}
