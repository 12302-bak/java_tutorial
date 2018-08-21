/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title OctalO.java
* @Package observerpattern
* @Description: TODO:
* @author eric
* @date 2018年8月21日上午11:32:11
* @version V1.0
*/
package observerpattern;

/**
 * @Title OctalO.java
 * @Package observerpattern
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日上午11:32:11
 * @version V1.0
 */
public class OctalO extends Observer {
  
  //protected Subject sub;
  public OctalO(Subject sub){
    this.sub=sub;
    this.sub.append(this);
  }
  @Override
  public void update() { //保护的东西属性，可以直接使用父类的    this.sub.getStatus();
    System.out.println("OctalO output:"+Integer.toOctalString(this.sub.getStatus()));
  }

}
