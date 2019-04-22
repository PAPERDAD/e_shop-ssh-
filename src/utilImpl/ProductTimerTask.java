package utilImpl;

import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import service.CategoryService;
import service.ProductService;
import model.Category;
import model.Product;
import java.util.List;
import java.util.ArrayList;
/**
*@author Zhiguang Cheng
*@date 2019年3月28日 下午8:04:56 
*@version 1.0 
**/
@Component("productTimerTask")
public class ProductTimerTask extends TimerTask{

	@Resource(name="productService")
	private ProductService productService = null;
	@Resource(name="categoryService")
	private CategoryService categoryService = null;
	
	private ServletContext application = null;
	
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("------------run---------");
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		for (Category category:categoryService.queryByHot(true)) {
			List<Product> list = productService.queryByCategoryId(category.getId());
			bigList.add(list);
		}
		application.setAttribute("bigList",bigList);
		
	}

}
