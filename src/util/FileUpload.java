package util;


import javax.servlet.ServletContext;

import model.FileImage;

/**
*@author Zhiguang Cheng
*@date 2019��3��27�� ����3:13:45 
*@version 1.0 
**/
public interface FileUpload {
	public abstract String uploadFile(FileImage fimeImage);
	public String[] getBankImage(ServletContext sc);

}
