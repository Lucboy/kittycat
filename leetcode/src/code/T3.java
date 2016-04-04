package code;

public class T3 {
	 int[] news=new int[2];//保存当前无重复子串的起始下标
     int[] logests=new int[2];//保存当前最长无重复子串的起始下标
  public int lengthOfLongestSubstring(String s) {
     if(s==null||s.length()==0)
      return 0;
     
      int start,end,flag;//flag 标示有无重复
      int length=s.length();
      start=0;
      end=0;
      news[0]=start;
      news[1]=end;
      for(end=1;end<length;end++)
      {
          flag=0;//表示无重复
          int j;
          for(j=news[0];j<=news[1];j++)//查看有无重复。调整start，end
          {
              if(s.charAt(j)==s.charAt(end))//说明有重复，调整start
              {
                  start=j+1;
                  flag=1;
                  break;
              }
              
          }
          if(flag==0)
          {
              news[1]=end;
              if((logests[1]-logests[0])<(news[1]-news[0]))//如果news比logests长
              {
                  logests[0]=news[0];
                  logests[1]=news[1];
                  
              }
          }else{//如果有重复调整start，显然此时的end-start不会比news[1]-news[0]长
              start=j+1;
              news[0]=start;
              news[1]=end;
              
          }
      }
      return logests[1]-logests[0]+1;
      
  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
