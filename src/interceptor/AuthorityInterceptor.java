package interceptor;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
*@author Zhiguang Cheng
*@date 2019年3月27日 下午8:34:22 
*@version 1.0 
**/
public class AuthorityInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2301478600235967985L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//ActionContext ac = invocation.getInvocationContext();
		HttpServletRequest req =  ServletActionContext.getRequest(); 
		if(req.getSession().getAttribute("user") == null) {
			//保存当前客户想要去的url地址
			String goURL = req.getServletPath();//获得用户想要去的地址
			String param = req.getQueryString(); //获得地址中携带的参数
			if(param != null) {
				goURL = goURL + "?" + param; //重新拼好请求地址+参数
			}
			//把当前客户想要访问的地址，存储到session中
			req.getSession().setAttribute("goURL", goURL);
			return "ulogin";
		}else {
			return invocation.invoke();
		}
	}

}
