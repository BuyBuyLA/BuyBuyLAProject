package buybuyla.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	   //final只需載入一次
	//一個db對應一個cfg對應一個factory
	private static final SessionFactory factory=createSessionFactory();
	
	
	private static SessionFactory createSessionFactory() {
		// 建立工廠模式		

		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure().build();
		//得到session facototy物件(資料庫物件)  (取得資源MetadataSources(serviceRegistry))
		//找到設定黨(註冊等等)
		SessionFactory factory= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		return factory; //回傳factory物件
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close(); 
		}
	}	
}
