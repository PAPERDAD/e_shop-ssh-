package service;

import model.User;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午5:11:56 
*@version 1.0 
**/
public interface UserService extends BaseService<User>{
	public User login(User user);
	public String register(User user);
	public boolean isExisted(User login);

}
