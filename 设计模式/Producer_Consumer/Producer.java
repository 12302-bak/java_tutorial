package com.oracle.j229.d0717.Producer_Consumer;

public class Producer extends Thread {
	private ShareData s;
	
	public Producer(ShareData s,String str) {
        super(str);		
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(char c='A';c<='E';c++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.setShareChar(c);
		}
	}
}
