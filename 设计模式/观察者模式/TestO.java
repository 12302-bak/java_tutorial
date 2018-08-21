/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title TestO.java
* @Package observerpattern
* @Description: TODO:
* @author eric
* @date 2018年8月21日上午11:37:44
* @version V1.0
*/
package observerpattern;

/**
 * @Title TestO.java
 * @Package observerpattern
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日上午11:37:44
 * @version V1.0
 */
public class TestO {
  public static void main(String[] args) {
    Subject sub = new Subject();
    
    new BinaryO(sub);
    new OctalO(sub);
    new HexO(sub);
    
    sub.setStatus(10);
  }
}
