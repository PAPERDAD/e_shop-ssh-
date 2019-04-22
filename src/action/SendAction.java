package action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
*@author Zhiguang Cheng
*@date 2019年3月25日 下午3:16:02 
*@version 1.0 
**/
@Controller("sendAction")
@Scope("prototype")
public class SendAction extends ActionSupport{
	/**
	 * 
	 */

	private static final long serialVersionUID = -2064414252552243634L;

	public String execute() {
		return "send";
	}

}
