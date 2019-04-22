package serviceImpl;






import service.CategoryService;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Category;

/**
*@author Zhiguang Cheng
*@date 2019�?3�?23�? 下午3:23:41 
*@version 1.0 
**/
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{


	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		// TODO Auto-generated method stub
		return categoryDao.queryJoinAccount(type, page, size);
	}

	@Override
	public Long getCount(String type) {
		// TODO Auto-generated method stub
		return categoryDao.getCount(type);
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		categoryDao.deleteByIds(ids);
		
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		// TODO Auto-generated method stub
		return categoryDao.queryByHot(hot);
	}


}
