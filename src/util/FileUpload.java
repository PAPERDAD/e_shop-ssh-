package util;


import javax.servlet.ServletContext;

import model.FileImage;

/**
*@author Zhiguang Cheng
*@date 2019年3月27日 下午3:13:45 
*@version 1.0 
**/
public interface FileUpload {
	public abstract String uploadFile(FileImage fimeImage);
	public String[] getBankImage(ServletContext sc);

}
