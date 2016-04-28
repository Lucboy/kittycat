package mysql.connection.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

	private static final int MAX_SIZE=10;
	private static final int MIN_SIZE=5;
	private static final int DEFAULT_SIZE=5;
	private final LinkedList<Job> tasks=new LinkedList<>();
	private final List<Worker> workers=Collections.synchronizedList(new ArrayList<Worker>());
	private int worknum=DEFAULT_SIZE;
	
	public DefaultThreadPool()
	{
		this(DEFAULT_SIZE);
	}
	public DefaultThreadPool(int initsize)
	{
		initialize(initsize);
	}
	private void initialize(int initsize)
	{
		if(initsize>MAX_SIZE)
		{
			initsize=MAX_SIZE;
			
		}
		else if(initsize<MIN_SIZE)
		{
			initsize=MIN_SIZE;
			
		}
			
		for(int i=0;i<initsize;i++)
		{
				Worker w=new Worker();
				workers.add(w);
				Thread thread=new Thread(w,"worker"+i);
				thread.start();
		}
				
		
			
	}
	
	/**
	 * 提交作业等待执行
	 * 
	 * 
	 */
	@Override
	public void execute(Job job) {
		synchronized(tasks)
		{
			tasks.addLast(job);
			System.out.println("+job");
			tasks.notifyAll();
		}
		
	}

	/**
	 * 关闭线程池
	 */
	@Override
	public void shutdown() {
		
		if(tasks.size()>0)//还有未完成的任务，不允许关闭线程池
		return;
		else {
			for(Worker w:workers)
			{
				w.shutdown();
			}
		}
		
	}

	@Override
	public void addWorkers(int num) {
		
		synchronized(tasks){
			num=num+worknum>MAX_SIZE?MAX_SIZE:num+worknum<MIN_SIZE?MIN_SIZE:num;
			initialize(num);
			
		}
		
		
	}

	@Override
	public void removeWorkers(int num) {
		synchronized(tasks)
		{
			num=worknum-num<MIN_SIZE?worknum-MIN_SIZE:workers.size()>=num?num:workers.size();
			initialize(num);
			
		}
		
	}

	@Override
	public int getJobSize() {
		
		return tasks.size();
	}

	class Worker implements Runnable{
	 //是否工作
     private volatile boolean isrunning=true;
		@Override
		public void run() {
			while(isrunning)
			synchronized(tasks)
			{
				while(tasks.isEmpty()){
					try {
						System.out.println("tasks is empty!");
						tasks.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				Job job=tasks.removeFirst();
				if(job!=null){
					job.run();
				}
				
			}
			
		}
		public void shutdown()
		{
			isrunning=false;
			
		}
		
		
	}
}
