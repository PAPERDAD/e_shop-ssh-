package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
*@author Zhiguang Cheng
*@date 2019年3月23日 下午3:03:34 
*@version 1.0 
**/
public class HibernateSessionFactory {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>(); //sessionFactory中用的是线程池技术
    private static SessionFactory sessionFactory; //sessionFactory：创建session的工厂
	
  
 
    static { //类加载时初始化sessionFactory
    	try {
    		StandardServiceRegistry registry  = new StandardServiceRegistryBuilder().configure().build();
             sessionFactory =  new MetadataSources(registry).buildMetadata().buildSessionFactory();
	} catch (Exception e) {
		System.err.println("%%%% Error Creating SessionFactory %%%%");
		e.printStackTrace();
	}
    }
    private  HibernateSessionFactory() { //私有构造方法阻止new出对象，保证sessionFactory的单例
    }
	
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();  //从线程池中拿session
 
		if (session == null || !session.isOpen()) { //如果线程池是空的，或者session打开失败
			if (sessionFactory == null) {
				rebuildSessionFactory(); //如果sessionFactory是空的，那就再创建一次，和static部分一样的
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null; //sessionFactory不为空就创建一个session
			threadLocal.set(session); //然后把这个session放到线程池中，下次再拿
		}
 
        return session;
    }
 
    public static void rebuildSessionFactory() {
	try {
		StandardServiceRegistry registry  = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory =  new MetadataSources(registry).buildMetadata().buildSessionFactory();
	} catch (Exception e) {
		System.err.println("%%%% Error Creating SessionFactory %%%%");
		e.printStackTrace();
	}
    }
 
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
 
        if (session != null) {
            session.close();
        }
    }
 
    public static SessionFactory getSessionFactory() {//提供一个公共接口让外界获得这个单例sessionFactory
	return sessionFactory;
    }
 

}
