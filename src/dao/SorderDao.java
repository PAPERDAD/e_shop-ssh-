package dao;

import java.util.List;

import model.Sorder;

/**
*@author Zhiguang Cheng
*@date 2019��4��10�� ����9:47:02 
*@version 1.0 
**/
public interface SorderDao extends BaseDao<Sorder>{
	public List<Sorder> querySale(int number);

}
