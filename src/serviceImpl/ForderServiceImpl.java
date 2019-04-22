package serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Forder;
import model.Product;
import model.Sorder;
import service.ForderService;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午3:36:53 
*@version 1.0 
**/
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService{

	@Override
	public BigDecimal cluTotal(Forder forder) {
		// TODO Auto-generated method stub
		BigDecimal total =new BigDecimal("0");
		for (Sorder sorder:forder.getSorders()) {
			total = total.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber())));
		}
		System.out.println("total is "+total);
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		// TODO Auto-generated method stub
		forderDao.updateStatusById(id, sid);	
	}

	@Override
	public List<Forder> queryJoinUserAndSorders(String name, int page, int size) {
		// TODO Auto-generated method stub
		return forderDao.queryJoinUserAndSorders(name,page,size);
	}

	@Override
	public Long getCount(String name) {
		// TODO Auto-generated method stub
		return forderDao.getCount(name);
	}

}
