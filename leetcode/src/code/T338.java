package code;

public class T338 {

	public int[] countBits(int num) {
        int[] rst=new int[num+1];
        for(int i=0;i<=num;i++)
        {
             int count=0;
            for(int j=0;j<32;j++)
            {
               
                if(((i>>>j)&0x1)==0x1)
                {
                    count++;
                }
            }
            rst[i]=count;
        }
        return rst;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
