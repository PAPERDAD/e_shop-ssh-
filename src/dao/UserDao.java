package dao;

import model.User;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:47:54 
*@version 1.0 
**/
public interface UserDao extends BaseDao<User>{
	public User login(User user);
	public String register(User user);
	public boolean isExisted(User user);

}
