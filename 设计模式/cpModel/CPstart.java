package cpModel;

import java.util.List;

import com.csdn.access.Get_Link;



public class CPstart {
	public static void main(String[] args) {
		ProxyData pd=new ProxyData();
		List<String> listsUrl=null;
		listsUrl=new Get_Link().get_link_list();
		String prior = "https://blog.csdn.net";
		for (int i = 0; i < 100; i++) {
			new ProxyProduct(pd).start();
    }
		try {
	    Thread.sleep(600*1000);
    } catch (InterruptedException e) {
	    
	    e.printStackTrace();
    }
		for (String string : listsUrl) {
	    new ProxyConsumer(pd, prior+string).start();
    }
	}
}