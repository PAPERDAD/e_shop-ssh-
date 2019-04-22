package dao;

import java.util.List;

import model.Forder;
import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:45:10 
*@version 1.0 
**/
public interface ForderDao extends BaseDao<Forder> {
	public void updateStatusById(int id, int sid);
	public List<Forder> queryJoinUserAndSorders(String type, int page, int size); //使用商品的名称查询
	//根据关键字查询总记录数
	public Long getCount(String type);

}
