package service;

import java.util.List;

import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年3月27日 上午10:26:03 
*@version 1.0 
**/
public interface ProductService extends BaseService<Product>{
		public List<Product> queryJoinCategory(String name,int page,int size);
		public Long getCount(String name);
		public void deleteByIds(String ids);
		public List<Product> queryByCategoryId(int cid);
}
