package cpModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import bean.ProxyIpBean;

public class ProxyData {
  //队列大小  
  private final int QUEUE_LENGTH = 20000;  
  //基于内存的阻塞队列  
  private BlockingQueue<ProxyIpBean> queue = new LinkedBlockingQueue<ProxyIpBean>(QUEUE_LENGTH);  
  

	public synchronized void setShareBean(ProxyIpBean pib) {

		if (queue.size()>=18000) {
			try {
				System.out.println("还没消费，生产等待……");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.queue.offer(pib);
		         //表示生产完了，有东西，置1   然后通知消费者
		notify();
    System.out.println(Thread.currentThread().getName()+"\t生产了："+pib+"\t并通知消费者");
	}

	public synchronized ProxyIpBean getShareBean() {

		if (queue.size()<=200) {
			try {
				System.out.println("还未生产，消费等待-->");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		System.out.println(Thread.currentThread().getName()+"\t消费了："+this.queue.peek()+"\t并通知生产者");
		return this.queue.poll();
		
	}

	public BlockingQueue<ProxyIpBean> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<ProxyIpBean> queue) {
		this.queue = queue;
	}

}
