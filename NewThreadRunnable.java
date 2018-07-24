/**
 * Copyright© 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title NewThreadRunnable.java
 * @Package: info.xhs.thread 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年4月18日 上午10:39:00 
 * @version 1.0.0
 * @since JDK1.8
 */
package info.xhs.thread;

/**
 * @className NewThreadRunnable
 * @description
 *
 */
public class NewThreadRunnable {
	public static void main(String[] args) {
	  new Thread(new Runnable(){

			@Override
      public void run() {
	      for(int i=0;i<=5;i++){
	      	System.out.println("output:"+i);
	      }
      }
	  	
	  }).start();
	  
  }
}
