/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title TestP.java
* @Package dynamicproxy
* @Description: TODO:
* @author eric
* @date 2018年8月21日下午12:58:34
* @version V1.0
*/
package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Title TestP.java
 * @Package dynamicproxy
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日下午12:58:34
 * @version V1.0
 */
public class TestP {
  public static void main(String[] args) {
    RealHost rh = new RealHost();
    
    InvocationHandler ih = new IHandler(rh);
    
    Surf sf = (Surf) Proxy.newProxyInstance(rh.getClass().getClassLoader(), rh.getClass().getInterfaces(), ih);
    
    sf.shangwang();
  }
}
