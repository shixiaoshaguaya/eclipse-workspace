package cz1117.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class czHttpSessionListener implements HttpSessionListener {
	//当前用户数
	private int userCounts=0;
    public void sessionCreated(HttpSessionEvent se)  { 
    	//sessionCreated 用户数+1
    	userCounts++;
    	//重新在servletContext中保存userConts
    	se.getSession().getServletContext().setAttribute("userCounts", userCounts);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        //sessionCreated 用户数-1
    	userCounts--;
    	//重新在servletContext中保存userConts
    	se.getSession().getServletContext().setAttribute("userCounts", userCounts);
    }
	
}
