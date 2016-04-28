package mysql.connection.pool;

interface ThreadPool<Job extends Runnable> {
	void execute(Job job);
	void shutdown();
	void addWorkers(int num);
	void removeWorkers(int num);
	int  getJobSize();

}
