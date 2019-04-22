package action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import model.Account;

/**
*@author Zhiguang Cheng
*@date 2019年3月26日 下午2:35:16 
*@version 1.0 
**/
@Service("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String query() {
		queryList =  accountService.query();
		return "query";
	}

}
