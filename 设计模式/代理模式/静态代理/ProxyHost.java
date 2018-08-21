/**
* Copyright 2018 qmhd.con.cn Inc. All Rights Reserved. 
* @Title ProxyHost.java
* @Package staticproxy
* @Description: TODO:
* @author eric
* @date 2018年8月21日上午11:52:24
* @version V1.0
*/
package staticproxy;

/**
 * @Title ProxyHost.java
 * @Package staticproxy
 * @Description: TODO:
 * @author eric
 * @date 2018年8月21日上午11:52:24
 * @version V1.0
 */
public class ProxyHost implements Surf {

  private RealHost rl;
  
  @Override
  public void shangwang() {
    System.out.println("正在代理");
    if(rl==null){
      rl =new RealHost();
    }
    rl.shangwang();
    System.out.println("代理结束");
  }

}
