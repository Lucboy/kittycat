package excutor;

import container.jobPool.HttpJob;
import container.jobPool.HttpJobPool;

public class Excutor {
	private HttpJobPool jobpool;
	public Excutor()
	{
		this.jobpool=new HttpJobPool();
		this.jobpool.initWorkersQueue(10);
	}
	public Excutor(int size)
	{
		this.jobpool=new HttpJobPool();
		this.jobpool.initWorkersQueue(size);
	}
	/**
	 * 提交任务执行
	 * @param job
	 */
	public void pushJob(HttpJob job)
	{
		if(this.jobpool.isrunning==true)
			this.jobpool.excute(job);
		else{
			this.jobpool.open();
			this.jobpool.excute(job);
		}
	}

}
