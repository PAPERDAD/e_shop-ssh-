package util;

import model.User;

/**
*@author Zhiguang Cheng
*@date 2019年4月4日 下午1:34:25 
*@version 1.0 
**/
public interface EmailUtil {
	public abstract void orderEmail(String emailAddress,String id);
	public abstract void registerEmail(String emailAddress,User user);

}
