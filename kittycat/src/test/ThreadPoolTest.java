package test;

import mysql.connection.pool.DefaultThreadPool;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DefaultThreadPool threadpool=new DefaultThreadPool();
		int count=20;
		for(int i=0;i<count;i++)
		{
			Thread job=new Thread(new Runnable(){
				public void run()
				{
					System.out.println(Thread.currentThread().getName()+"is runnig");
				}
			},"thread"+i);
			threadpool.execute(job);
			job.join();
		}
		

	}

}
