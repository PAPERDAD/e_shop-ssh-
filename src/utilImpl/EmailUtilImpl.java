package utilImpl;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import model.User;
import util.EmailUtil;
/**
*@author Zhiguang Cheng
*@date 2019年4月4日 下午1:36:05 
*@version 1.0 
**/
@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil{

	@Override
	public void orderEmail(String emailAddress, String id) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		Session  session = null;
		Message message = null;
		Transport transport = null;
		try {
			prop.setProperty("mail.transport.protocol","smtp");
			session = Session.getDefaultInstance(prop);
			session.setDebug(true);
			message = new MimeMessage(session);
			message.setSubject("网上商城订单反馈！");
			message.setContent("顾客你好，欢迎光临网上商城，你的订单号："+id+"已支付完成！","text/html;charset=utf-8");
			message.setFrom(new InternetAddress("scomliy@163.com"));
			transport = session.getTransport();
			transport.connect("smtp.163.com","scomliy","mima36898256");
			transport.sendMessage(message,new InternetAddress[] {new InternetAddress(emailAddress)});
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e); 
		}finally {
			try {
				transport.close();
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e); 
			}
		}
		
	}

	@Override
	public void registerEmail(String emailAddress, User user) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		Session  session = null;
		Message message = null;
		Transport transport = null;
		try {
			prop.setProperty("mail.transport.protocol","smtp");
			session = Session.getDefaultInstance(prop);
			session.setDebug(true);
			message = new MimeMessage(session);
			message.setSubject("BearShop注册成功！");
			String mess = "<h1 style=\"text-align: center\">BearShop感谢你的注册！</h1>\r\n" + 
					"<div style=\"margin: 0 auto; width: 200px; text-align: center;\">你的注册信息</div>\r\n" + 
					"<table align=\"center\">\r\n" + 
					"    <tr>\r\n" + 
					"        <td>\r\n" + 
					"            <div>用户名:"+user.getLogin()+"</div>\r\n" + 
					"        </td>\r\n" + 
					"    </tr>\r\n" + 
					"    <tr>\r\n" + 
					"        <td>\r\n" + 
					"            <div>姓名:"+user.getName()+"</div>\r\n" + 
					"        </td>\r\n" + 
					"    </tr>\r\n" + 
					"    <tr>\r\n" + 
					"        <td>\r\n" + 
					"            <div>性别："+user.getSex()+"</div>\r\n" + 
					"        </td>\r\n" + 
					"    </tr>\r\n" + 
					"     <tr>\r\n" + 
					"        <td>\r\n" + 
					"            <div>电话："+user.getPhone()+"</div>\r\n" + 
					"        </td>\r\n" + 
					"    </tr>\r\n" + 
					"    <tr>\r\n" + 
					"        <td>\r\n" + 
					"            <div>邮件："+user.getEmail()+"</div>\r\n" + 
					"        </td>\r\n" + 
					"    </tr>\r\n" + 
					"</table>\r\n" + 
					"\r\n" + 
					"<div style=\"text-align: center;\">\r\n" + 
					"    <div style=\"display: inline-block;\"><img src=\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554393718026&di=adba3af780e42e9a27488ec7c420bd0b&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_gif%2FJ2yjOVBzsVRiczznjEYooB3YKXERRc8rn3pWmsHm3Z0ayTh5YDpbkhste2ic1icEvkribes1iahhA0qkFqgDr6BZrOw%2F640%3Fwx_fmt%3Dgif\" height=\"200\" width=\"200\"/></div>\r\n" + 
					"</div>\r\n" + 
					"";
			message.setContent(mess,"text/html;charset=utf-8");
			message.setFrom(new InternetAddress("scomliy@163.com"));
			transport = session.getTransport();
			transport.connect("smtp.163.com","scomliy","mima36898256");
			transport.sendMessage(message,new InternetAddress[] {new InternetAddress(emailAddress)});
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e); 
		}finally {
			try {
				transport.close();
			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e); 
			}
		}
		
		
	}

}
