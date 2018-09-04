package com.oracle.j229.d0717.Producer_Consumer;

public class Consumer extends Thread {
	private ShareData s;
	
	public Consumer(ShareData s,String str) {
		super(str);
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		char c=' ';
		do{	
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c=s.getShareChar();
			
		}while(c!='E');
		
	}
}
