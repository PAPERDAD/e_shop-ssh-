package service;

import java.util.List;

import model.Category;


/**
*@author Zhiguang Cheng
*@date 2019年3月23日 下午3:15:00 
*@version 1.0 
**/
public interface CategoryService extends BaseService<Category> {
	public List<Category> queryJoinAccount(String type,int page,int size);
	public Long getCount(String type);
	public void deleteByIds(String ids);
	public List<Category> queryByHot(boolean hot);

}

