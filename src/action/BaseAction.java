package action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import model.FileImage;
import service.AccountService;
import service.CategoryService;
import service.CheckImageService;
import service.ForderService;
import service.PayService;
import service.ProductService;
import service.SorderService;
import service.StatusService;
import service.UserService;
import util.EmailUtil;
import util.FileUpload;

/**
*@author Zhiguang Cheng
*@date 2019年3月24日 下午8:30:54 
*@version 1.0 
 * @param <T>
**/
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -107792051454035196L;
	protected Map<String,Object> request;
	protected Map<String,Object> session;
	protected Map<String,Object> application;
	protected T model;
	protected int page;
	protected int rows;
	protected String checkCode;
	protected Map<String,Object> pageMap = null;
	protected String ids;
	protected String jsonResult;
	protected InputStream inputStream;
	protected List<T> queryList;
	protected FileImage fileImage;
	
	@Resource(name="userService")
	protected UserService userService;
	@Resource(name="sorderService")
	protected SorderService sorderService;
	@Resource(name="forderService")
	protected ForderService forderService;
	@Resource(name="fileUpload")
	protected FileUpload fileUpload;
	@Resource(name="categoryService")
	protected CategoryService categoryService;
	@Resource(name="accountService")
	protected AccountService accountService;
	@Resource(name="productService")
	protected ProductService productService;
	@Resource(name="statusService")
	protected StatusService statusService;
	@Resource(name="payService")
	protected PayService payService;
	@Resource(name="checkImageService")
	protected CheckImageService checkImageService;
	@Resource(name="emailUtil")
	protected EmailUtil emailUtil;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	


	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.application = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;  
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class<?> clazz = (Class<?>) type.getActualTypeArguments()[0];
		try {
			model = (T)clazz.getDeclaredConstructor().newInstance();
		}catch(Exception e ) {
			throw new RuntimeException(e);
		}
		return model;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public List<T> getQueryList() {
		return queryList;
	}
	public void setQueryList(List<T> queryList) {
		this.queryList = queryList;
	}
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	public FileImage getFileImage() {
		return fileImage;
	}
	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}
	public SorderService getSorderService() {
		return sorderService;
	}
	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}
	public ForderService getForderService() {
		return forderService;
	}
	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}
	public EmailUtil getEmailUtil() {
		return emailUtil;
	}
	public void setEmailUtil(EmailUtil emailUtil) {
		this.emailUtil = emailUtil;
	}
	public String getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}




}
