package buybuyla.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener   //註冊listenner   或在web.xml中去註冊
public class SessionFactoryListener implements ServletContextListener {
     //伺服器一啟動就會開啟     結束的時候會自動關閉
	
	
	 //這邊可以用source override/implements builder去幫建   
	  //但是要注意init和Destroy的順序
	@Override      
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();
		System.out.println("ServletContextListener 控制的getSessionFactory Created");
		
	}
	
	@Override    
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();
		System.out.println("ServletContextListener 控制的getSessionFactory Closed");
		
	}
}
