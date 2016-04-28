package container.jobPool;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;

import exception.NullHttpWrapperException;
import exception.ObjNotAServletException;
import exception.ServletPathException;

//Http ����������
public class HttpJobPool {
	private final  int MAX_WORKER_SIZE=1000;//worker���е����ֵ
	private final  int MIN_WORKER_SIZE=10;
	private final  int DEFAULT_WORKER_SIZE=10;
	
	private   final LinkedBlockingQueue<HttpJob> jobPool=new LinkedBlockingQueue<>(); //�������
	private volatile AtomicInteger jobPoolSize=new AtomicInteger(0);
	private  LinkedList<Worker> workers=new LinkedList<>(); ;
	public volatile boolean isrunning=false;
	public volatile int  workersize=0;
	
	public void open()
	{
		initWorkersQueue(DEFAULT_WORKER_SIZE);
		isrunning=true;
	}
	/**
	 * ����������������
	 * @param job
	 * @return
	 */
	public boolean excute(HttpJob job)
	{
		if(job==null)
			return false;
		synchronized(jobPool){
		try {
			
			jobPool.put(job);
			jobPool.notifyAll();
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		}
	}
	/**
	 * ��ʼ���̳߳أ����������߳�
	 * @param size �̳߳ش�С
	 */
	public void initWorkersQueue(int size)
	{
		if(size>MAX_WORKER_SIZE)
			size=MAX_WORKER_SIZE;
		if(size<MIN_WORKER_SIZE)
			size=MIN_WORKER_SIZE;
		for(int i=0;i<size;i++)
		{ 
			Worker worker=new Worker();
			workers.add(worker);
			worker.start();
			
		}
		workersize=size;
		isrunning=true;
		
	}
	/**
	 * �ر��̳߳�
	 */
	public void shutDownPool()
	{
		while(jobPoolSize.intValue()>0);
		for(Worker worker:workers){
			worker.close();
		}
		isrunning=false;
	}
	public int getJobPoolSize()
	{
		return jobPoolSize.intValue();
	}
	public int getWokerSize()
	{
		return workersize;
	}
	class Worker extends Thread{
		private volatile boolean isAlive=true;
		private volatile boolean isbusy=false;
		public void run(){
			while(isAlive)
			{
				if(jobPoolSize.intValue()<0)
				{
					
					try {
						jobPool.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					//ȡ������ִ������
					synchronized(jobPool){
						
					try {
						HttpJob job=jobPool.take();
						jobPoolSize.incrementAndGet();
						System.out.println("worker"+Thread.currentThread()+"is excute job"+job.toString());
						job.excuteJob();
						
					} catch (InterruptedException | ClassNotFoundException | InstantiationException | IllegalAccessException | ServletPathException | ServletException | IOException | ObjNotAServletException | NullHttpWrapperException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
				}
				
			}
		}
		public void close()
		{
			this.isAlive=false;
		}
	}
	

}
