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
*@date 2019��3��23�� ����3:03:34 
*@version 1.0 
**/
public class HibernateSessionFactory {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>(); //sessionFactory���õ����̳߳ؼ���
    private static SessionFactory sessionFactory; //sessionFactory������session�Ĺ���
	
  
 
    static { //�����ʱ��ʼ��sessionFactory
    	try {
    		StandardServiceRegistry registry  = new StandardServiceRegistryBuilder().configure().build();
             sessionFactory =  new MetadataSources(registry).buildMetadata().buildSessionFactory();
	} catch (Exception e) {
		System.err.println("%%%% Error Creating SessionFactory %%%%");
		e.printStackTrace();
	}
    }
    private  HibernateSessionFactory() { //˽�й��췽����ֹnew�����󣬱�֤sessionFactory�ĵ���
    }
	
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();  //���̳߳�����session
 
		if (session == null || !session.isOpen()) { //����̳߳��ǿյģ�����session��ʧ��
			if (sessionFactory == null) {
				rebuildSessionFactory(); //���sessionFactory�ǿյģ��Ǿ��ٴ���һ�Σ���static����һ����
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null; //sessionFactory��Ϊ�վʹ���һ��session
			threadLocal.set(session); //Ȼ������session�ŵ��̳߳��У��´�����
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
 
    public static SessionFactory getSessionFactory() {//�ṩһ�������ӿ���������������sessionFactory
	return sessionFactory;
    }
 

}
