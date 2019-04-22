package action;


import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Service;

import model.User;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午5:10:14 
*@version 1.0 
**/
@Service("userAction")
public class UserAction extends BaseAction<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5829221114435987141L;

	/**
	 * 
	 */

    public String register() {
    	//清空session.error中的信息

    	session.remove("error");
    	String checkcode_real = (String)session.get("checkCode");
    	if (checkCode.equalsIgnoreCase(checkcode_real)) {
    		String flag = userService.register(model);
        	if (flag == "existed") {
        		session.put("error","注册失败,用户名已存在");
        		return "register";
        	}else if(flag == "failed") {
        		session.put("error","注册失败");
        		return "register";
        	}else{
        		    session.put("user",model);
    				emailUtil.registerEmail(model.getEmail(),model);
        			return "index"; //跳到首页
        	}		
    	}else {
    		session.put("error","验证码错误");
    		return "register";
    	}
    	


    }
    
    public String exit() {
    	session.remove("user");
		return "index"; 	
    }
    
    public String isExisted() {
    	boolean flag = userService.isExisted(model);
    	inputStream = new ByteArrayInputStream(String.valueOf(flag).getBytes()); 
    	return "stream";
    }
		


    	
    
	public String login() {
		model = userService.login(model);
		if (model==null) {
			session.put("error","登录失败");
			return "login";
		}else {

			session.put("user", model);
			//根据session中goURL是否有值而决定页面的跳转
			if(session.get("goURL") == null) {
				return "index"; //跳到首页
			} else {
				session.put("goURL",null);
				return "goURL";
		}
		}
	}

}
