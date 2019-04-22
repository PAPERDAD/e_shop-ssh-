package daoImpl;

import org.springframework.stereotype.Repository;

import dao.AccountDao;
import model.Account;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:58:08 
*@version 1.0 
**/
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao{

}
