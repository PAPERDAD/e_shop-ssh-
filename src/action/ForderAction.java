package action;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import model.Forder;


/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午6:06:31 
*@version 1.0 
**/
@Controller("forderAction")
public class ForderAction extends BaseAction<Forder>{
	String name;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3567911444018429562L;
	@Override
	public Forder getModel() {
		model = (Forder) session.get("forder");
		return model;
	}
	public String save() {
		model.setUser((model.User)session.get("user"));
		model.setStatus(statusService.get(1));
		model.setDate(new Date());
		forderService.save(model);
		session.put("oldForder",session.get("forder"));
		session.put("forder",new Forder());
		return "bank";
		
	}
	public String queryJoinUserAndSorders() {
		pageMap = new HashMap<String,Object>();
		pageMap.put("rows",forderService.queryJoinUserAndSorders(getName(),page,rows));
		pageMap.put("total",forderService.getCount(getName()));
		return "jsonMap";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
