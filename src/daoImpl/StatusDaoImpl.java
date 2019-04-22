package daoImpl;

import org.springframework.stereotype.Repository;

import dao.StatusDao;
import model.Status;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 下午12:04:26 
*@version 1.0 
**/
@Repository("statusDao")
public class StatusDaoImpl extends BaseDaoImpl<Status> implements StatusDao{

}
