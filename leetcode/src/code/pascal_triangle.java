package code;

import java.util.ArrayList;
import java.util.List;

public class pascal_triangle {

	public static void main(String[] args) {
		System.out.println(getRow(5));

	}
	public static List<Integer> getRow(int k)
	{
		int i,j;
		if(k<0)
			return null;
		List<Integer> pre=new ArrayList<Integer>();
		List<Integer> next=new ArrayList<Integer>();
		List<Integer>  temp;
		pre.add(1);
		
		for(i=1;i<=k;i++)
		{   
			next.add(0, 1);
			
			for(j=1;j<i;j++)//填充第i行的去掉首尾的其他数
			{
				next.add(j, pre.get(j-1)+pre.get(j));
			}
			next.add(i, 1);
			//System.out.println(next);
			temp=next;
			next=pre;
			pre=temp;
			next.clear();
			
			
		}
		return pre;
		
	}

}
