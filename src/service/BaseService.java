package service;

import java.util.List;



/**
*@author Zhiguang Cheng
*@date 2019��3��24�� ����7:30:07 
*@version 1.0 
**/

public interface BaseService<T> {
	public void delete(int id);
	public void update(T t);
	public void save(T t);
	public T get(int id);
	public List<T> query();
	public List<T> queryByField(String field,String arg);


}
