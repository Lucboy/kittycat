package code;

public class T4 {
	 static int length=0;
	   public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        return 0;
	        
	    }
	    public static int find(int[] A,int[] B)
	    {
	        int p1,p2,curval;
	        p1=0;
	        p2=0;
	        curval=A[0];
	        while(p1<A.length&&p2<B.length)
	        {
	            while(A[p1]==curval)
	                p1++;
	            
	            while(B[p2]==curval)
	                 p2++;
	            if(A[p1]==B[p2])
	            {
	            	length+=1;
	            		curval=A[p1];
	            }
	            	
	            else{
	            	length+=2;
	            	curval=B[p2];
	            }
	            	
	            
	            
	             
	        }
	        
	        while(A.length-p1>1)
	        {
	             
	             while(A[p1++]==curval)
	                continue;
	             length++;    
	        }
	      
	        while(B.length-p2>1)
	        {
	             
	             while(B[p2++]==curval)
	                continue;
	             length++;    
	        }
	        return length;
	    }
	public static void main(String[] args) {
		int[] a={1,1,2};
		int[] b={1,1,2,3};
		find(a,b);
		System.out.println(length);
	}

}
