package action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import model.Category;


/**
*@author Zhiguang Cheng
*@date 2019年3月24日 下午2:28:36 
*@version 1.0 
**/
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2416109287695747055L;

	
	public void update() throws Exception{
		System.out.println("--update--");
	//	System.out.println(((Category)model).getId()+""+((Category)model).getType());
		categoryService.update(model);
	}
	
	public void save() throws Exception{
		System.out.println("--save--");
		System.out.println(model);
		categoryService.save(model);
	}
	
	public String query() {
		queryList = categoryService.query();
		return "query";
	}
	
	
	public String queryJoinAccount() {
		pageMap = new HashMap<String,Object>();
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(),page,rows);
		pageMap.put("rows",categoryList);
		Long total = categoryService.getCount(model.getType());
		pageMap.put("total",total);
		return "jsonMap";
	}
	public String deleteByIds(){
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}


	

}
