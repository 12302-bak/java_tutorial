package com.oracle.j229.d0717.Producer_Consumer;

public class TestCP {
	public static void main(String[] args) {
		ShareData sd=new ShareData();
		new Producer(sd,"A").start();
		//new Producer(sd,"B").start();
		new Consumer(sd,"C").start();
		//new Consumer(sd,"D").start();
	}
}
