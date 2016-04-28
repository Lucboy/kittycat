package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import mysql.connection.pool.MysqlConnectionPool;

public class ConnectionPoolTest {

	static MysqlConnectionPool connPool=new MysqlConnectionPool(7);//��ʼ�����ӳ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=20;
		AtomicInteger got=new AtomicInteger();
		AtomicInteger notgot=new AtomicInteger();
		for(int i=0;i<count;i++)
		{
			Thread thread=new Thread(new ConnectionRunner(count,got,notgot),"ConnectionRunner");
			thread.start();
			
		}
		System.out.println("got connection:"+got.get());
		System.out.println("notgot connection:"+notgot.get());

	}
	static class ConnectionRunner implements Runnable
	{
	
		int count=20;
		AtomicInteger got;
		AtomicInteger notgot;
		
		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notgot) {
			super();
			this.count = count;
			this.got = got;
			this.notgot = notgot;
		}

		public void run() {
			// TODO Auto-generated method stub
			Connection conn=connPool.fecthConnection(-1);
			if(conn!=null)
			{
				try {
					conn.createStatement();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//conn.close();//�ɲ��ܹر�
					connPool.release(conn);
					got.incrementAndGet();//��ȡ������
				}
			}else{
				System.out.println("can't get connection");
				notgot.incrementAndGet();//δ��ȡ����������1
			}
			
		}
	}

	

}
