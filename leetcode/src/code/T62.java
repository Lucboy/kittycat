package code;

public class T62 {

	  public static int uniquePaths(int m, int n) {
		     
	       int[][] count=new int[m][n];
	       int i=0,j=0;
	       for(i=0;i<m;i++)
	            count[i][0]=1;
	        for(i=0;i<n;i++)
	            count[0][i]=1;
	        for(i=1;i<m;i++)
	            for(j=1;j<n;j++)
	            {
	                count[i][j]=count[i-1][j]+count[i][j-1];
	            }
	            return count[m-1][n-1];
	       
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,3));

	}

}
