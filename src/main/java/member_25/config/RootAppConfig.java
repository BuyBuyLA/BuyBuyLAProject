package member_25.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.v2.c3p0.ComboPooledDataSource;


//@Configuration 取代web.xml黨  然後用@Bean來定義xml中的BEan
@Configuration
@EnableTransactionManagement //DAO相關 讓DAO的@Transaction啟用
public class RootAppConfig {

	//
	
	@Bean
    public DataSource dataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser("sa");
        ds.setPassword("password");
        try {
            ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=BuyBuyLa");
        ds.setInitialPoolSize(4);
        ds.setMaxPoolSize(8);
        return ds;
    }
    
    @Bean   //建立工廠
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(new String[] {
                 //   "com.web.store.model"
        			"member_25.model"
                });
        factory.setHibernateProperties(additionalProperties());
        return factory;
    }
    @Bean(name="transactionManager")  //注入工廠
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
         HibernateTransactionManager txManager = new HibernateTransactionManager();
         txManager.setSessionFactory(sessionFactory);
         return txManager;
      }    
    
    private Properties additionalProperties()  {  //方言
        Properties properties=new Properties();
        properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
        properties.put("hibernate.show_sql", Boolean.TRUE);
        properties.put("hibernate.format_sql", Boolean.TRUE);
        properties.put("default_batch_fetch_size", 10);
        //原本一定要有這句才能開啟交易(用Hibernate來開的session 也就是在ProductServiceImpl那邊用getCurrentSession的servlet方式取得session)
        //但是當用@Transactional後(spring來管的版本) 工廠是spring的 也舊是spring開的交易 那Hibernate的交易就不會有了是空的
        //所以有這行的話過來找就會找沒有交易
//        properties.put("hibernate.current_session_context_class", "thread");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
	
	
	
}
