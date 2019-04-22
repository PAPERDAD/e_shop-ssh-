package daoImpl;

import org.springframework.stereotype.Repository;

import dao.StatusDao;
import model.Status;

/**
*@author Zhiguang Cheng
*@date 2019��4��10�� ����12:04:26 
*@version 1.0 
**/
@Repository("statusDao")
public class StatusDaoImpl extends BaseDaoImpl<Status> implements StatusDao{

}
