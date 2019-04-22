package service;

import java.math.BigDecimal;
import java.util.List;

import model.Forder;
import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午3:17:16 
*@version 1.0 
**/
public interface ForderService extends BaseService<Forder>{
	public BigDecimal cluTotal(Forder forder);
	public void updateStatusById(int id, int sid);
	public List<Forder> queryJoinUserAndSorders(String name,int page,int size);
	public Long getCount(String name);


}
