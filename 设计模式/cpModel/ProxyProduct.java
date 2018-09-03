package cpModel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pitd.StartIPSet;
import zookeeper.UseZKInstance;
import bean.ProxyIpBean;



public class ProxyProduct extends Thread {
	private ProxyData pd;
	
	public ProxyProduct(ProxyData pd) {
		this.pd = pd;
	}

	@Override
	public void run() {
		List<ProxyIpBean> listBean=StartIPSet.getListBean();
		Proxy proxy = null;
		String ipInfo=null;
		String localIP=getV4IP();
		
		for (ProxyIpBean proxyIpBean : listBean) {
					try {
						proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIpBean.getIp(), proxyIpBean.getPort()));
				    ipInfo = getHtml("http://ip.chinaz.com/getip.aspx",proxy);
				    Pattern p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
				    if(ipInfo!=null){
					    Matcher m = p.matcher(ipInfo);
					    if (m.find()) {
					    	String proxyIP = m.group(0);
					    	System.out.println("正在检测的代理ip:" + proxyIP);
					    	if (!localIP.equals(proxyIP)) {
					    		System.out.println("本机ip:" + localIP);

                  if(!pd.getQueue().contains(proxyIpBean)){
                  	 pd.setShareBean(proxyIpBean);
                  	 if(pd.getQueue().size()%10==0){
                  		 UseZKInstance.getZKInstance().setData("/myNode", "change".getBytes(), -1);
                  	 }
                  	 System.out.println("=======================Queue大小：="+pd.getQueue().size()+"======Add Bean "+proxyIpBean.getIp()+"=========================");
                  }
					    	}
				      }
				    }
			    } catch (Exception e) {
				    System.out.println(e.getMessage()+">>>>");
			    }
       }
	}
	private static String getHtml(String address,Proxy proxy){
		StringBuffer html = new StringBuffer();
		String result = null;
		/*
		 * System.getProperties().setProperty("proxySet", "true"); //
		 * 如果不设置，只要代理IP和代理端口正确,此项不设置也可以 String ip = "218.56.132.158";
		 * 
		 * System.getProperties().setProperty("http.proxyHost",
		 * "202.124.205.26");
		 * System.getProperties().setProperty("http.proxyPort", "3128");
		 */
		URL url;
    HttpURLConnection con = null;
    BufferedInputStream in = null;
    byte[] buf;
    try {
	    url = new URL(address);
	    con = (HttpURLConnection) url.openConnection(proxy);
	    con.setConnectTimeout(5000);
	    con.setInstanceFollowRedirects(true);
	    con.setRequestMethod("GET");

	    in = new BufferedInputStream(con.getInputStream());

	    String inputLine;
	    buf = new byte[4096];
	    int bytesRead = 0;
	    while (bytesRead >= 0) {
	    	inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");
	    	html.append(inputLine);
	    	bytesRead = in.read(buf);
	    	inputLine = null;
	    }
			result = new String(html.toString().trim().getBytes("ISO-8859-1"),
					"gb2312").toLowerCase();
    } catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    } catch (ProtocolException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    System.out.println(e.getMessage());
    }finally{
		   
				try {
	        in.close();
	        con.disconnect();
        } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
    }


		return result;
	}

	public static  String getV4IP() {
		String ip = "";
		String chinaz = "http://ip.chinaz.com/getip.aspx";

		StringBuilder inputLine = new StringBuilder();
		String read = "";
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedReader in = null;
		try {
			url = new URL(chinaz);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection
					.setRequestProperty(
							"User-Agent",
							"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36");
			// conn.setRequestProperty("Accept-Encoding",
			// "gzip, deflate, sdch"); //kongzhi bainma

			urlConnection
					.setRequestProperty("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			urlConnection.setInstanceFollowRedirects(true);
			urlConnection.setRequestProperty("Connection", "keep-alive");
			urlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			urlConnection.connect();
			if (urlConnection.getResponseCode() == 200) {
				in = new BufferedReader(new InputStreamReader(
						urlConnection.getInputStream(), "UTF-8"));
				while ((read = in.readLine()) != null) {
					inputLine.append(read);
				}
			}
			// System.out.println(inputLine.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// "\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>"
		Pattern p = Pattern
				.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		Matcher m = p.matcher(inputLine.toString());
		if (m.find()) {
			String ipstr = m.group(0);
			ip = ipstr;
		}
		return ip;
	}
}
