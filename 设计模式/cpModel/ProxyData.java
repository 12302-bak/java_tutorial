package cpModel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import bean.ProxyIpBean;

public class ProxyData {
  //���д�С  
  private final int QUEUE_LENGTH = 20000;  
  //�����ڴ����������  
  private BlockingQueue<ProxyIpBean> queue = new LinkedBlockingQueue<ProxyIpBean>(QUEUE_LENGTH);  
  

	public synchronized void setShareBean(ProxyIpBean pib) {

		if (queue.size()>=18000) {
			try {
				System.out.println("��û���ѣ������ȴ�����");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.queue.offer(pib);
		         //��ʾ�������ˣ��ж�������1   Ȼ��֪ͨ������
		notify();
    System.out.println(Thread.currentThread().getName()+"\t�����ˣ�"+pib+"\t��֪ͨ������");
	}

	public synchronized ProxyIpBean getShareBean() {

		if (queue.size()<=200) {
			try {
				System.out.println("��δ���������ѵȴ�-->");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		System.out.println(Thread.currentThread().getName()+"\t�����ˣ�"+this.queue.peek()+"\t��֪ͨ������");
		return this.queue.poll();
		
	}

	public BlockingQueue<ProxyIpBean> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<ProxyIpBean> queue) {
		this.queue = queue;
	}

}
