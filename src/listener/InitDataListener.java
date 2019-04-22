package listener;


import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.FileUpload;
import utilImpl.ProductTimerTask;

/**
*@author Zhiguang Cheng
*@date 2019年3月28日 下午3:09:33 
*@version 1.0 
**/
@WebListener
public class InitDataListener implements ServletContextListener {	

	private ApplicationContext context = null;
	private FileUpload fileUpload = null;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(sc);  
		ProductTimerTask tt = (ProductTimerTask) context.getBean("productTimerTask");
		tt.setApplication(event.getServletContext());
		new Timer(true).schedule(tt,0,1000*60*20);
		fileUpload = (FileUpload)context.getBean("fileUpload");
		sc.setAttribute("bankImageList",fileUpload.getBankImage(sc));
	}
	
	@Override 
	public void contextDestroyed(ServletContextEvent event) {
		
	}
			
	
	

}
