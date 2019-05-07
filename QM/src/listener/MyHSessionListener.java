package listener;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import javabean.Good;

public class MyHSessionListener implements HttpSessionListener {
//监听器
	public void sessionCreated(HttpSessionEvent se) {
		//Good -->商品
        //Integer -->购买的商品数量
		se.getSession().setAttribute("cartmap", new LinkedHashMap<Good, Integer>());
	}

	public void sessionDestroyed(HttpSessionEvent se) {

	}

}
