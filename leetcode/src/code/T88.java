package code;

public class T88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1={1,6,9,0,0};
		int[] nums2={4,5};
		merge(nums1,3,nums2,2);
		System.out.println();

	}
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        int j=0;
	        int i=0;
	        int topos=0;
	        int frompos=m;
	       //把n2用插入排序的方法插入nums1中
	       
	        for(j=0;j<n;j++)
	        {
	            int nextel=nums2[j];//待插入的元素
	            for(i=frompos;i>topos&&nextel<nums1[i-1];i--)
	            {
	                nums1[i]=nums1[i-1];
	            }
	            
	            nums1[i]=nextel;
	            frompos++;
	            topos=i;
	            
	        }
	        
	        
	    }
}
