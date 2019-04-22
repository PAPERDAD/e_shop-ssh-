package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import model.User;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午10:11:22 
*@version 1.0 
**/
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.login=:login and u.pass=:pass";
		return (User) getSession().createQuery(hql) //
			.setParameter("login", user.getLogin()) //
			.setParameter("pass", user.getPass()) //
			.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
	    String hql = "from User u Where u.login =:login ";
		Session session = getSession();
		List<User> exists =  session.createQuery(hql) .setParameter("login", user.getLogin()).list();
		if (exists.size() > 0 ) {
			return "existed";
		}else {
			try {
				session.save(user);
			}catch(Exception e) {
				return "failed";
			}
			    return "success";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExisted(User user) {
		// TODO Auto-generated method stub
	    String hql = "from User u Where u.login =:login ";
		Session session = getSession();
		List<User> exists =  session.createQuery(hql) .setParameter("login", user.getLogin()).list();
		if(exists.size() > 0) return true;
		return false;
	}

}
