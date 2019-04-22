package dao;

import java.util.List;

import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:46:06 
*@version 1.0 
**/
public interface ProductDao extends BaseDao<Product>{
	//查询商品信息，级联类别
	public List<Product> queryJoinCategory(String type, int page, int size); //使用商品的名称查询
	//根据关键字查询总记录数
	public Long getCount(String type);
	//根据ids删除多条记录
	public void deleteByIds(String ids);
	//根据热点类别查询推荐商品（仅仅查询前4个）
	public List<Product> querByCategoryId(int cid);

}
