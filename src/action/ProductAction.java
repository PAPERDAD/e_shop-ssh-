package action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019年3月27日 上午11:20:03 
*@version 1.0 
**/
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String queryJoinCategory() {
		pageMap = new HashMap<String,Object>();
		pageMap.put("rows",productService.queryJoinCategory(model.getName(),page,rows));
		pageMap.put("total",productService.getCount(model.getName()));
		return "jsonMap";
	}
	public String deleteByIds() {
		System.out.println(ids);
		productService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save() throws Exception{
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		System.out.println(model);
		productService.save(model);
	}
	public void update() throws Exception{
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		productService.update(model);
	}
	public String get() {
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
	
	public String search() {
		List<Product> searchList = productService.queryByField("name",model.getName());
		pageMap = new HashMap<>();
		pageMap.put("searchList",searchList);
		return "search";
	}

}
