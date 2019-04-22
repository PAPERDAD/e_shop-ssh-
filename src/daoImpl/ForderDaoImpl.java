package daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.ForderDao;
import model.Forder;
import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午10:03:50 
*@version 1.0 
**/
@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao{

	@Override
	public void updateStatusById(int id, int sid) {
		// TODO Auto-generated method stub
		String hql = "update Forder f set f.status.id=:sid where f.id=:id";
		getSession().createQuery(hql)
			.setParameter("sid", sid)
			.setParameter("id", id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Forder> queryJoinUserAndSorders(String type, int page, int size) {
		// TODO Auto-generated method stub
		String hql = "from Forder f left join fetch f.user left join fetch f.sorders where f.name like :name";
		List<Forder> list = getSession().createQuery(hql).setParameter("name","%"+type+"%").setFirstResult((page-1)*size).setMaxResults(size).list();
		return list;
	}

	@Override
	public Long getCount(String type) {
		// TODO Auto-generated method stub
		String hql = "select count(f) from Forder f where f.name like :name";
		Long count = (Long)getSession().createQuery(hql).setParameter("name","%"+type+"%").
				uniqueResult();
		return count;
	}

}
