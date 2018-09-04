package com.oracle.j229.d0717.Producer_Consumer;

public class ShareData {
	private char ch;
	private int hasd = 0; //0��ʾû�ж���

	public synchronized void setShareChar(char c) {

		if (hasd != 0) {
			try {
				System.out.println("��û���ѣ������ȴ�����");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.ch = c;
		hasd = 1;     //��ʾ�������ˣ��ж�������1   Ȼ��֪ͨ������
		notify();
        System.out.println(Thread.currentThread().getName()+"\t�����ˣ�"+ch+"\t��֪ͨ������");
	}

	public synchronized char getShareChar() {

		if (hasd == 0) {
			try {
				System.out.println("��δ���������ѵȴ�-->");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		hasd = 0;
		notify();
		System.out.println(Thread.currentThread().getName()+"\t�����ˣ�"+ch+"\t��֪ͨ������");
		return this.ch;
		
	}

}
