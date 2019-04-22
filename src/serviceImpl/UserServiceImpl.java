package serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import model.User;
import service.UserService;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午5:13:11 
*@version 1.0 
**/
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);

	}


	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		return userDao.register(user);
      

	}


	@Override
	public boolean isExisted(User user) {
		// TODO Auto-generated method stub
		return userDao.isExisted(user);
	}	

}
