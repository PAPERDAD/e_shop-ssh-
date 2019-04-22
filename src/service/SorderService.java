package service;

import java.util.List;

import model.Forder;
import model.Product;
import model.Sorder;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午3:14:22 
*@version 1.0 
**/
public interface SorderService  extends BaseService<Sorder>{
	public Forder addSorder(Forder forder,Product product);
	public Sorder productToSorder(Product product);
	public Forder updateSorder(Sorder sorder,Forder forder);
	public Forder deleteSorder(Sorder sorder,Forder forder);
	public List<Sorder> querySale(int number);


}
