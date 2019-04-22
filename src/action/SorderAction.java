package action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import model.Forder;
import model.Product;
import model.Sorder;

/**
*@author Zhiguang Cheng
*@date 2019年3月31日 下午3:54:25 
*@version 1.0 
**/
@Controller("sorderAction")
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String addSorder() {
		Product product = productService.get(model.getProduct().getId());
		if (session.get("forder")==null) {
			session.put("forder",new Forder(new ArrayList<Sorder>()));
		}
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.addSorder(forder,product);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder",forder);
		return "showCart";
		
	}
	public String updateSorder() {
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.updateSorder(model,forder);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder",forder);
		inputStream = new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
		
	}
	
	public String deleteSorder() {
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.deleteSorder(model,forder);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder",forder);
		inputStream = new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
		
	}
	
	public String querySale(){
		queryList = sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(queryList);
		return "jsonList";
		
	
	}

}
