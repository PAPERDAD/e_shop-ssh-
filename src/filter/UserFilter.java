package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
//@WebFilter(filterName="userFilter",urlPatterns="/user/*")
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// �жϵ�ǰsession�Ƿ����û���Ϣ
		if(req.getSession().getAttribute("user") == null) {
			//���浱ǰ�ͻ���Ҫȥ��url��ַ
			String goURL = req.getServletPath();//����û���Ҫȥ�ĵ�ַ
			String param = req.getQueryString(); //��õ�ַ��Я���Ĳ���
			if(param != null) {
				goURL = goURL + "?" + param; //����ƴ�������ַ+����
			}
			//�ѵ�ǰ�ͻ���Ҫ���ʵĵ�ַ���洢��session��
			req.getSession().setAttribute("goURL", goURL);
			
			//�Ƿ�������ת����½ҳ��
			req.getSession().setAttribute("error", "�Ƿ��������¼��");
			res.sendRedirect(req.getContextPath() + "/ulogin.jsp");
		} else {
			//�������һ������������ת������ֱ�ӵ�Ŀ��ҳ��
			chain.doFilter(request, response);
		}
	}

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
