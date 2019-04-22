package serviceImpl;
/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午3:18:50 
*@version 1.0 
**/

import java.util.List;

import org.springframework.stereotype.Service;

import model.Forder;
import model.Product;
import model.Sorder;
import service.SorderService;
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService{

	@Override
	public Forder addSorder(Forder forder, Product product) {
		// TODO Auto-generated method stub
		boolean isHave = false;
		Sorder sorder = productToSorder(product);

		for(Sorder old : forder.getSorders()) {
			if(old.getProduct().getId().equals(sorder.getProduct().getId())) {
				//购物项有重复，添加数量即可
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		if (!isHave) {
			sorder.setForder(forder);
			forder.getSorders().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		// TODO Auto-generated method stub
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Sorder sorder, Forder forder) {
		// TODO Auto-generated method stub
		for (Sorder temp:forder.getSorders()) {
			if (temp.getProduct().getId().equals(sorder.getProduct().getId())) {
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

	@Override
	public Forder deleteSorder(Sorder sorder, Forder forder) {
		// TODO Auto-generated method stub
		List<Sorder> list = forder.getSorders();
		Sorder selected  = null;
		for (Sorder temp:list) {
			if (temp.getProduct().getId().equals(sorder.getProduct().getId())) {
				selected =  temp;
			}
		}
		list.remove(selected);
		return forder;
	}

	@Override
	public List<Sorder> querySale(int number) {
		// TODO Auto-generated method stub
		sorderDao.querySale(number);
		return sorderDao.querySale(number);
	}

}
