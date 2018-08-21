/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title IHandler.java
* @Package dynamicproxy
* @Description: TODO:
* @author eric
* @date 2018年8月21日下午12:55:36
* @version V1.0
*/
package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title IHandler.java
 * @Package dynamicproxy
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日下午12:55:36
 * @version V1.0
 */
public class IHandler implements InvocationHandler {

  private Object o;
  public IHandler(Object o){
    this.o=o;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    System.out.println("正在代理");
    method.invoke(o, args);
    System.out.println("代理结束");
    return null;
  }

}
