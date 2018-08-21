/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title Observer.java
* @Package observerpattern
* @Description: TODO:
* @author eric
* @date 2018年8月21日上午11:15:51
* @version V1.0
*/
package observerpattern;

/**
 * @Title Observer.java
 * @Package observerpattern
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日上午11:15:51
 * @version V1.0
 */
public abstract class Observer {
  protected Subject sub;
  public abstract void update();
}
