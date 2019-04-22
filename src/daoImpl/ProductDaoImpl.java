package daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.ProductDao;
import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午10:05:43 
*@version 1.0 
**/
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		// TODO Auto-generated method stub
		String hql = "from Product p left join fetch p.category where p.name like :name";
		List<Product> list = getSession().createQuery(hql).setParameter("name","%"+name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size).list();
		return list;
	}

	@Override
	public Long getCount(String name) {
		// TODO Auto-generated method stub
		String hql = "select count(p) from Product p where p.name like :name";
		Long count = (Long)getSession().createQuery(hql).setParameter("name","%"+name+"%").
				uniqueResult();
		return count;
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql = "delete from Product p where p.id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> querByCategoryId(int cid) {
		// TODO Auto-generated method stub
		String hql = "from Product p  join fetch p.category "+
				"where p.commend=true and p.open=true and p.category.id =:cid order by p.date desc";
		List<Product> list = getSession().createQuery(hql).setParameter("cid",cid).setFirstResult(0)
				.setMaxResults(4).list();
		return list;
	}

}
