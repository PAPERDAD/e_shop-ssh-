package serviceImpl;

import java.util.List;


import org.springframework.stereotype.Service;

import model.Product;
import service.ProductService;

/**
*@author Zhiguang Cheng
*@date 2019年3月27日 上午11:15:56 
*@version 1.0 
**/
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {



	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		// TODO Auto-generated method stub
		return productDao.queryJoinCategory(name, page, size);
	}

	@Override
	public Long getCount(String name) {
		// TODO Auto-generated method stub
		return productDao.getCount(name);
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		productDao.deleteByIds(ids);
	}


	@Override
	public List<Product> queryByCategoryId(int cid) {
		// TODO Auto-generated method stub
		return productDao.querByCategoryId(cid);
	}
	
	

}
