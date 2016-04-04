package code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 算法描述：给定一个int数组，找出任何四个数之和等于0的所有组合
 * 输入：例如{1,2,3,0,-1，-1,-2}
 * 输出：{-1,-1，0,2}，{-2,-1,0,3} 
 * 算法分析：先排序，然后遍历的时候注意去除重复的，所以要保存上一次循环时的值，这样如果下一次是相同的值则跳过，保证没有重复的值。
 * 			最后一个数可以用二分查找来查询，比线性查找块
 * @author Administrator
 *
 */
public class T18 {

	public static void main(String[] args) {
		int[] array={1,0,-1,0,-2,2};
		
		List<List<Integer>> rstset=fun(array,0);
		for(int i=0;i<rstset.size();i++)
		{
			for(Integer val:rstset.get(i))
				System.out.print(val+",");
			System.out.println();
		}
			
	}
	public static List<List<Integer>> fun(int[] arr,int target)
	{
		if(arr==null)
			return null;
		Arrays.sort(arr);//先排序
		
		
		List<List<Integer>> rst=new LinkedList<List<Integer>>();
		if(arr.length<4)
			return rst;
		int k1;
		k1=arr[0]-1;
		
		for(int i=0;i<=arr.length-4;i++)
		{   if(arr[i]==k1)
				continue;
			
			k1=arr[i];
			
			for(int j=i+1, k2=arr[0]-1;j<=arr.length-3;j++)
			{      
				if(arr[j]==k2)
					continue;
			
				k2=arr[j];
				for(int k=j+1,k3=arr[0]-1;k<=arr.length-2;k++)
				{
					if(arr[k]==k3)
						continue;
					
					k3=arr[k];
					int rest=target-(arr[i]+arr[j]+arr[k]);
					int m=Arrays.binarySearch(arr, k+1, arr.length, rest);
					if(m>-1)
					{
							List<Integer> set=new LinkedList<>();
							set.add(arr[i]);
							set.add(arr[j]);
							set.add(arr[k]);
							set.add(arr[m]);
							rst.add(set);
						
					}
					
						
				}
			}
				
		}
			
		return rst;
	}
}
