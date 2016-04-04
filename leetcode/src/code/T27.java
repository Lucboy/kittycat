package code;
import java.util.*;
public class T27 {

	public static void main(String[] args) {
		int[] array=new int[3];
				array[0]=1;
				array[1]=2;
				array[2]=3;
//				array[3]=3;
//				array[4]=2;
//				array[5]=4;
//				array[6]=6;
//				array[7]=7;
				System.out.println(removeElement(array,2));
				
				

	}
	
	 public static int removeElement(int[] nums, int val) {
	        
		 LinkedList<Integer> list=new LinkedList<Integer>();
	        int i;
	        for(i=0;i<nums.length;i++)
	         list.add(nums[i]);
	         
	        int size=list.size();
	        Integer value=new Integer(val);
	        for(i=0;i<size;i++)
	         if(list.contains(val))
	            list.remove(value);
	          System.out.println(list);  
	        return list.size();
	        
	    }

}
