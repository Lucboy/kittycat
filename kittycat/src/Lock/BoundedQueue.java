package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �߽����
 * @author Administrator
 *
 */
public class BoundedQueue {
	private Object[] items;
	private int Qsize;//��¼�߽������Ԫ�صĸ���
	private int Qcapacity;
	private static final int DEFAULT_CAPACITY=5;//Ĭ�ϱ߽���еĴ�С
	private Lock lock=new ReentrantLock();//������
	private Condition Empty=lock.newCondition();//�ǿ���������
	private Condition Full=lock.newCondition();//������������
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
		if(Qsize==Qcapacity)//������������������ߵȴ�
		{
			try {
				Full.await();  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			items[Qsize++]=new Object();//����һ������������
			Empty.signalAll();//�����ڶ����ϵȴ���������
		
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
			Full.signalAll();//�������������ϵȴ����߳�
		}
		lock.unlock();
	}

}
