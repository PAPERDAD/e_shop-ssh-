package action;


import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Service;

import model.User;

/**
*@author Zhiguang Cheng
*@date 2019��3��31�� ����5:10:14 
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
    	//���session.error�е���Ϣ

    	session.remove("error");
    	String checkcode_real = (String)session.get("checkCode");
    	if (checkCode.equalsIgnoreCase(checkcode_real)) {
    		String flag = userService.register(model);
        	if (flag == "existed") {
        		session.put("error","ע��ʧ��,�û����Ѵ���");
        		return "register";
        	}else if(flag == "failed") {
        		session.put("error","ע��ʧ��");
        		return "register";
        	}else{
        		    session.put("user",model);
    				emailUtil.registerEmail(model.getEmail(),model);
        			return "index"; //������ҳ
        	}		
    	}else {
    		session.put("error","��֤�����");
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
			session.put("error","��¼ʧ��");
			return "login";
		}else {

			session.put("user", model);
			//����session��goURL�Ƿ���ֵ������ҳ�����ת
			if(session.get("goURL") == null) {
				return "index"; //������ҳ
			} else {
				session.put("goURL",null);
				return "goURL";
		}
		}
	}

}
