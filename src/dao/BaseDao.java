package dao;

import java.util.List;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:39:47 
*@version 1.0 
**/
public interface BaseDao<T> {
	public void save(T t);

	public void update(T t);
	
	public void delete(int id);
	
	public T get(int id);
	
	public List<T> query();
	
	public List<T> queryByField(String field,String arg) ;

}
