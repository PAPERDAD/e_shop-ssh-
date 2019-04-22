package serviceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import dao.AccountDao;
import dao.BaseDao;
import dao.CategoryDao;
import dao.ForderDao;
import dao.ProductDao;
import dao.SorderDao;
import dao.StatusDao;
import dao.UserDao;
import service.BaseService;

/**
*@author Zhiguang Cheng
*@date 2019年3月24日 下午7:33:00 
*@version 1.0 
**/
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	private Class<T> clazz;
	//protected BaseDao<Object> objectDao =new  BaseDaoImpl<Object>();
	protected BaseDao<T> baseDao;
	@Resource(name="accountDao")
	protected AccountDao accountDao;
	@Resource(name="categoryDao")
	protected CategoryDao categoryDao;
	@Resource(name="forderDao")
	protected ForderDao forderDao;
	@Resource(name="productDao")
	protected ProductDao productDao;
	@Resource(name="sorderDao")
	protected SorderDao sorderDao;
	@Resource(name="userDao")
	protected UserDao userDao;
	@Resource(name="statusDao")
	protected StatusDao statusDao;


	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>)type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init() {
		//根据clazz的类型，把不同的dao对象复制给baseDao对象
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao"; //例如Account==>accountDao
		System.out.println(clazzDao);
		try {
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this)); //baseDao就有值了
	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	




	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		baseDao.delete(id);
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		baseDao.update(t);
		
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		baseDao.save(t);
		
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> query() {
		// TODO Auto-generated method stub
	
		return (List<T>)baseDao.query();
	}

	@Override
	public List<T> queryByField(String field,String arg) {
		// TODO Auto-generated method stub
		return (List<T>)baseDao.queryByField(field,arg);
	}

}
