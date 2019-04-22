package serviceImpl;

import org.springframework.stereotype.Service;

import model.Account;
import service.AccountService;

/**
*@author Zhiguang Cheng
*@date 2019年3月24日 下午8:08:59 
*@version 1.0 
**/
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

}
