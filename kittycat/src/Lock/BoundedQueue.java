package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 边界队列
 * @author Administrator
 *
 */
public class BoundedQueue {
	private Object[] items;
	private int Qsize;//记录边界队列中元素的个数
	private int Qcapacity;
	private static final int DEFAULT_CAPACITY=5;//默认边界队列的大小
	private Lock lock=new ReentrantLock();//锁对象
	private Condition Empty=lock.newCondition();//非空条件对象
	private Condition Full=lock.newCondition();//非满条件对象
	public BoundedQueue()
	{
		this(DEFAULT_CAPACITY);
	}
	public BoundedQueue(int capacity)
	{
		this.Qcapacity=capacity;
		items=new Object[Qcapacity];
	}
	public void produce()
	{
		lock.lock();
		if(Qsize==Qcapacity)//如果队列已满则生产者等待
		{
			try {
				Full.await();  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			items[Qsize++]=new Object();//生产一个对象放入队列
			Empty.signalAll();//唤醒在队列上等待的消费者
		
		}
		lock.unlock();
	}
	public void consume()
	{
		lock.lock();
		if(Qsize==0)
		{
			try {
				Empty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Object obj=items[--Qsize];
			Full.signalAll();//唤醒在满队列上等待的线程
		}
		lock.unlock();
	}

}
