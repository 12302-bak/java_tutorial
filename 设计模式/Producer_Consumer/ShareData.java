package com.oracle.j229.d0717.Producer_Consumer;

public class ShareData {
	private char ch;
	private int hasd = 0; //0表示没有东西

	public synchronized void setShareChar(char c) {

		if (hasd != 0) {
			try {
				System.out.println("还没消费，生产等待……");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.ch = c;
		hasd = 1;     //表示生产完了，有东西，置1   然后通知消费者
		notify();
        System.out.println(Thread.currentThread().getName()+"\t生产了："+ch+"\t并通知消费者");
	}

	public synchronized char getShareChar() {

		if (hasd == 0) {
			try {
				System.out.println("还未生产，消费等待-->");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		hasd = 0;
		notify();
		System.out.println(Thread.currentThread().getName()+"\t消费了："+ch+"\t并通知生产者");
		return this.ch;
		
	}

}
