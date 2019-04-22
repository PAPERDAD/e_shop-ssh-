package daoImpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import dao.BaseDao;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:49:26 
*@version 1.0 
**/
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class<T> clazz;
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseDaoImpl() {
		System.out.println("this代表的是当前调用构造方法的对象" + this);
		System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass());
		//拿到泛型的参数类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>)type.getActualTypeArguments()[0];
	}
	
	
	protected Session getSession() {
		//从当前线程获取session，如果没有则创建一个新的session
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String hql = "delete " + clazz.getSimpleName() + " as c where c.id=:id";
		getSession().createQuery(hql) //
				  .setParameter("id", id) //
				  .executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		
		return (T)getSession().get(clazz,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query() {
		// TODO Auto-generated method stub
		String hql = "from " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByField(String field, String arg) {
		// TODO Auto-generated method stub
		String hql = "from "+clazz.getSimpleName()+" c where c."+field+" like :arg";
		List<T> list = getSession().createQuery(hql).setParameter("arg","%"+arg+"%").list();
		return list;
	}

}
