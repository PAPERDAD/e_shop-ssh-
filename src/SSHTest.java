import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Category;
import service.CategoryService;
import serviceImpl.CategoryServiceImpl;

/**
*@author Zhiguang Cheng
*@date 2019年3月22日 下午7:15:34 
*@version 1.0 
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SSHTest {

	 
	@Resource
	private CategoryService categoryService;
	
	@Test
	 public void testQueryJoinAccount() {
 		for(Category c : categoryService.queryJoinAccount("",1,2)) {
			 System.out.println(c);
			 System.out.println(c.getAccount());
 		}
 	}


}
