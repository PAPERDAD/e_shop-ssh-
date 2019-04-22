package service;

import model.User;

/**
*@author Zhiguang Cheng
*@date 2019��3��31�� ����5:11:56 
*@version 1.0 
**/
public interface UserService extends BaseService<User>{
	public User login(User user);
	public String register(User user);
	public boolean isExisted(User login);

}
