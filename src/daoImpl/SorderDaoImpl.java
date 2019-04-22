package daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.SorderDao;
import model.Sorder;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午10:09:22 
*@version 1.0 
**/
@Repository("sorderDao")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements SorderDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Sorder> querySale(int number) {
		// TODO Auto-generated method stub
		String hql = "select s.name, sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql) //
			.setFirstResult(0) //
			.setMaxResults(number) //
			.list();
	}

}
