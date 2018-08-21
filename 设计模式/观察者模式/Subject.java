/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title Subject.java
* @Package observerpattern
* @Description: TODO:
* @author eric
* @date 2018年8月21日上午11:19:51
* @version V1.0
*/
package observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Subject.java
 * @Package observerpattern
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日上午11:19:51
 * @version V1.0
 */
public class Subject {
  private int status;
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
    this.notifyAllObserver();
  }
  private List<Observer> lists =new ArrayList<Observer>();
  public void append(Observer o){
    lists.add(o);
  }
  
  public void notifyAllObserver(){
    for (Observer observer : lists) {
      observer.update();
    }
  }
}
