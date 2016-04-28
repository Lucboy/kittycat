package mysql.connection.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MysqlConnectionPool {
	private final String URL="jdbc:mysql://localhost:3306/ispace?user=root&password=root";
	private static final int MAX_SIZE=10;
	private static final int MIN_SIZE=5;
	private static  final int DEFAULT_SIZE=5;
	private LinkedList<Connection> pool=new LinkedList<Connection>();
	public MysqlConnectionPool()
	{
		this(DEFAULT_SIZE);
	}
	public MysqlConnectionPool(int initSize)
	{
		initSize=initSize<MIN_SIZE?MIN_SIZE:initSize>MAX_SIZE?MAX_SIZE:initSize;
		for(int i=0;i<initSize;i++)
		{
			try {
				pool.addLast(DriverManager.getConnection(URL));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Connection fecthConnection(long mills)
	{
		synchronized(pool){
			if(mills<=0)//立即返回
			{
				if(pool.isEmpty())
					return null;
				else return pool.getFirst();
				
			}else{
				long future=System.currentTimeMillis()+mills;//超时时刻
				long remains=mills;
				while(pool.isEmpty()&&remains>0)
				{
					try {
						pool.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Connection rest=null;
				if(!pool.isEmpty())
					rest=pool.removeFirst();
				return rest;
				
			}
			
		}
	}
	//归还一个连接
	public void release(Connection conn)
	{ 
		if(conn!=null){
		synchronized(pool)
		{
			
				pool.addLast(conn);
				pool.notifyAll();//唤醒在pool对象上等待的线程
		}
		}
	}

}
