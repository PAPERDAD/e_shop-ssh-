package daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.CategoryDao;
import model.Category;

/**
*@author Zhiguang Cheng
*@date 2019年4月10日 上午9:59:04 
*@version 1.0 
**/
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		// TODO Auto-generated method stub
		String hql = "from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
				.setParameter("type", "%" + type + "%")
				.setFirstResult((page-1) * size) //从第几个开始显示
				.setMaxResults(size) //显示几个
				.list();
	}

	@Override
	public Long getCount(String type) {
		// TODO Auto-generated method stub
		String hql = "select count(c) from Category c where c.type like :type";
		return (Long) getSession().createQuery(hql)
			.setParameter("type", "%" + type + "%")
			.uniqueResult(); //返回一条记录:总记录数
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql = "delete from Category c where c.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryByHot(boolean hot) {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.hot=:hot";
		return getSession().createQuery(hql)
			.setParameter("hot", hot)
			.list();
	}

}
