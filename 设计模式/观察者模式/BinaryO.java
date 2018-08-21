/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title BinaryO.java
* @Package observerpattern
* @Description: TODO:
* @author eric
* @date 2018年8月21日上午11:28:25
* @version V1.0
*/
package observerpattern;

/**
 * @Title BinaryO.java
 * @Package observerpattern
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日上午11:28:25
 * @version V1.0
 */
public class BinaryO extends Observer {
  
  //protected Subject sub;
  public BinaryO(Subject sub){
    this.sub=sub;
    this.sub.append(this);
  }
  
  @Override
  public void update() {    //保护的东西属性，可以直接使用父类的    this.sub.getStatus();
    System.out.println("BinaryO output:"+Integer.toBinaryString(sub.getStatus()));
  }

}
