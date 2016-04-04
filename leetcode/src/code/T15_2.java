package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T15_2 {

	public static void main(String[] args) {
		int[] arr={1,2,3,0,-1,-2};
		find(arr,0);

	}
	public static List<List<Integer>> find(int[] arr,int target)
	{
		
		int i,j,k;
		List<List<Integer>> set=new LinkedList<List<Integer>>() ;///放所有结果
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(i=0;i<arr.length;i++)
		{
			array.add(arr[i]);
		}
		//先对数组进行排序
		Collections.sort(array);
	
		for(i=0;i<array.size();i++)
		{
			int sum=target-array.get(i);
			for(j=i+1,k=array.size()-1;k>j;j++,k--)
			{
				if(array.get(j)+array.get(k)==sum)
				{
					LinkedList<Integer> alist=new LinkedList<Integer>();
					alist.add(array.get(i));
					alist.add(array.get(j));
					alist.add(array.get(k));
					set.add(alist);
				}
			}
					
		}
		System.out.println(set);
		return set;
		
	}

}
