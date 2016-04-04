package code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 算法描述：给定一个int数组，找出任何三个数之和等于0的所有组合
 * 输入：例如{1,2,3,0,-1,-2}
 * 输出：{1,0，-1}，{2,0,-2} {-1,-2,3}
 * 算法分析：先排序，然后遍历的时候注意去除重复的，所以要保存上一次循环时的值，这样如果下一次是相同的值则跳过，保证没有重复的值。
 * @author Administrator
 *
 */
public class T15 {

	public static void main(String[] args) {
		int[] array={-1,-2,1,2};
		
		List<List<Integer>> rstset=fun(array);
		for(int i=0;i<rstset.size();i++)
			for(Integer val:rstset.get(i))
				System.out.println(val);
	}
	public static List<List<Integer>> fun(int[] arr)
	{
		if(arr==null||arr.length<3)
			return null;
		Arrays.sort(arr);//先排序
		
		
		List<List<Integer>> rst=new LinkedList<List<Integer>>();
		int k1;
		k1=arr[0]-1;
		
	
		for(int i=0;i<=arr.length-3;i++)
		{   if(arr[i]==k1)
				continue;
			
			k1=arr[i];
			
			for(int j=i+1,k2=arr[0]-1;j<=arr.length-2;j++)
			{      
				if(arr[j]==k2)
					continue;
			
				k2=arr[j];
				int rest=-(arr[i]+arr[j]);
				int m=Arrays.binarySearch(arr, j+1, arr.length, rest);
				if(m>=0)
					{
						List<Integer> set=new LinkedList<>();
						set.add(arr[i]);
						set.add(arr[j]);
						set.add(arr[m]);
						rst.add(set);
					}
						
				
			}
				
		}
			
		return rst;
	}
}
