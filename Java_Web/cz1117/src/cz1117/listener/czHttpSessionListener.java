package cz1117.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class czHttpSessionListener implements HttpSessionListener {
	//��ǰ�û���
	private int userCounts=0;
    public void sessionCreated(HttpSessionEvent se)  { 
    	//sessionCreated �û���+1
    	userCounts++;
    	//������servletContext�б���userConts
    	se.getSession().getServletContext().setAttribute("userCounts", userCounts);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        //sessionCreated �û���-1
    	userCounts--;
    	//������servletContext�б���userConts
    	se.getSession().getServletContext().setAttribute("userCounts", userCounts);
    }
	
}
