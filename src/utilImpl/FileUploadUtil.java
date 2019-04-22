package utilImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import model.FileImage;
import util.FileUpload;

/**
*@author Zhiguang Cheng
*@date 2019年3月27日 下午3:16:44 
*@version 1.0 
**/
//@PropertySource({"/WEB-INF/fileSavePath.properties"})
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	@Value("${image.path}")
	private String fileSavePath;
	@Value("${image.bankImagePath}")
	private String bankImagePath;
	private ServletContext sc;
	
	public FileUploadUtil() {
	}
	
	@Override
	public String uploadFile(FileImage fileImage) {
		// TODO Auto-generated method stub
		sc = ServletActionContext.getServletContext();
		String  pic  = newFileName(fileImage.getUploadFileName());
		String path = sc.getRealPath(getFileSavePath()+pic);
		try(FileInputStream fis = new FileInputStream(fileImage.getUpload());
			FileOutputStream fos = new FileOutputStream(path))
		{
			byte[] bytes = new byte[1024];
			int len=0;
			while((len=fis.read(bytes))>0) {
				fos.write(bytes, 0, len);
			}
			return pic;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}
	
	private  String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	private  String newFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID().toString()+"."+ext;
	}
	@Override
	public String[] getBankImage(ServletContext se) {
		// TODO Auto-generated method stub
		System.out.println("i'm in getBankImage");
		System.out.println("i' m jump the sc");
		String realPath = se.getRealPath(bankImagePath);
		System.out.println(realPath);
		String[] list = new File(realPath).list(new FilenameFilter() {
			@Override
			public boolean accept(File dir,String name) {
				// TODO Auto-generated method stub
				System.out.println("dir:"+dir+",name:"+name);
				return name.endsWith(".gif");
			}
			
		});
		System.out.println("boom!!!!!!!!!!!!!!!!!!!!");
		
		return list;
	}

	public String getBankImagePath() {
		return bankImagePath;
	}

	public void setBankImagePath(String bankImagePath) {
		this.bankImagePath = bankImagePath;
	}
	

}
