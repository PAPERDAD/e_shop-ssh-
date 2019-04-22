package interceptor;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
*@author Zhiguang Cheng
*@date 2019��3��27�� ����8:34:22 
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
			//���浱ǰ�ͻ���Ҫȥ��url��ַ
			String goURL = req.getServletPath();//����û���Ҫȥ�ĵ�ַ
			String param = req.getQueryString(); //��õ�ַ��Я���Ĳ���
			if(param != null) {
				goURL = goURL + "?" + param; //����ƴ�������ַ+����
			}
			//�ѵ�ǰ�ͻ���Ҫ���ʵĵ�ַ���洢��session��
			req.getSession().setAttribute("goURL", goURL);
			return "ulogin";
		}else {
			return invocation.invoke();
		}
	}

}
