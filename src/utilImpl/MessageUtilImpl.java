package utilImpl;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import util.MessageUtil;

/**
*@author Zhiguang Cheng
*@date 2019��4��9�� ����3:33:12 
*@version 1.0 
**/
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil{
	@Value("${message.url}")
	private String url;
	@Value("${message.uid}")
	private String Uid;
	@Value("${message.key}")
	private String Key;
	

	@Override
	public void orderMessage(String phoneNum, String id) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.setParameter("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid",Uid);
		post.setParameter("Key",Key);
		post.setParameter("smsMob",phoneNum);
		post.setParameter("smsText","��Ķ����Ѹ���ɹ�");
		try {
			int code = 0;
			code = client.executeMethod(post);
			System.out.println("http���ص�״̬���ǣ�"+code);
			String result =  post.getResponseBodyAsString();
			System.out.println("���ŷ��͵Ľ���ǣ�"+result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			post.releaseConnection();
		}
		
		
		
		
	}

	@Override
	public void registerMessage(String phoneNum) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("");
		
	}
	

}
