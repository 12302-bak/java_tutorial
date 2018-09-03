package cpModel;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import bean.ProxyIpBean;


public class ProxyConsumer extends Thread {
	private ProxyData pd;
	private String accessUrl;
	public ProxyConsumer(ProxyData pd,String accessUrl) {
		this.accessUrl=accessUrl;
		this.pd = pd;
	}

	@Override
	public void run() {
		while(true){
		try {
			URL url = new URL(accessUrl);
			ProxyIpBean temp=pd.getShareBean();
			Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress(temp.getIp(), temp.getPort()));
			HttpURLConnection con = (HttpURLConnection) url.openConnection(proxy);
			con.setConnectTimeout(2000);
			con.setRequestMethod("GET");
			System.out.println("ResponseCode£º"+con.getResponseCode()+"\tusingProxy:"+con.usingProxy());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	 }
	}
}
