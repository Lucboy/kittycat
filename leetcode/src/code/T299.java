package code;

public class T299 {

	  public String getHint(String secret, String guess) {
		     if(secret==null||guess==null||secret.length()==0||guess.length()==0)
		        return "0A0B";
		    int length=secret.length();
		    
		    int bulls=0;
		    int cows=0;
		    int[] nums=new int[10];
		    for(int i=0;i<length;i++)
		    {
		        int s=secret.charAt(i)-'0';
		        int g=guess.charAt(i)-'0';
		        if(s-g==0)
		        {
		            bulls++;
		        }else 
		        {
		            if(nums[s]<0)
		            cows++;
		            if(nums[g]>0)
		            cows++;
		        }
		       
		           nums[g]--;
		           nums[s]++;
		    }
		    
		    
		     return bulls+"A"+cows+"B";
		        
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
