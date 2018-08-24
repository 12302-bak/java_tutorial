/**
 * Copyright_c 2018 qmhd.con.cn Inc. All Rights Reserved.
 * @Title TestSynchronizedTwoMethod.java
 * @Package: info.xhs.thread 
 * @Email:  xhsgg12302@outlook.com   
 * @date: 2018年5月4日 下午11:48:59 
 * @version 1.0.0
 * @since JDK1.8
 */
package info.xhs.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @className TestSynchronizedTwoMethod
 * @description//同一个对象中，不管线程执行那个synchronized方法，其他线程都不能执行其他synchronized方法，
 *               换句话说，也就是synchronized锁住的是所属方法的对象。并不是代码块
 *               为了避免激烈的竞争，而使其他线程挂起的情况，可以使用分段锁。synchronized中不能是基本数据类型
 *               synchronized代码块与synchronized(this)的效果一样，都是锁住当前对象，还有另外的对象（用于分段锁），还有一种类锁。
 */
public class TestSynchronizedTwoMethod {
	 boolean flag=false;
	 List<String> list=new ArrayList<String>();
	 List<String> other=new ArrayList<String>();
	public void method1(){
		 synchronized (this) {
			 while(true){
					try {
		        Thread.sleep(1000);
	        } catch (InterruptedException e) {
		        e.printStackTrace();
	        }
					this.flag=false;
					System.out.println("method1\t"+flag);
				}
    }
			
			
	}
	
	public void method2(){
		synchronized (this) {
			while(true){
				try {
	        Thread.sleep(1000);
        } catch (InterruptedException e) {
	        e.printStackTrace();
        }
				this.flag=true;
				System.out.println("method2\t"+flag);
			}
    }
			
		
	}
	
	
	
	
  public static void main(String[] args) {
  	TestSynchronizedTwoMethod tstm=new TestSynchronizedTwoMethod();
  	Thread one=new ThreadMethod1(tstm);
  	Thread two=new ThreadMethod2(tstm);
  	one.start();
  	two.start();
  }
}

class ThreadMethod1 extends Thread{
	TestSynchronizedTwoMethod tstm;
	ThreadMethod1(TestSynchronizedTwoMethod tstm){
		this.tstm=tstm;
	}
	public void run(){
		try {
	    Thread.sleep(1000);
    } catch (InterruptedException e) {
	    e.printStackTrace();
    }
		tstm.method1();
	}
}

class ThreadMethod2 extends Thread{
	TestSynchronizedTwoMethod tstm;
	ThreadMethod2(TestSynchronizedTwoMethod tstm){
		this.tstm=tstm;
	}
	public void run(){
		try {
	    Thread.sleep(1000);
    } catch (InterruptedException e) {
	    e.printStackTrace();
    }
		tstm.method2();
	}
}