package service;

import java.awt.image.BufferedImage;
import java.util.Map;


/**
*@author Zhiguang Cheng
*@date 2019年4月9日 下午7:56:23 
*@version 1.0 
**/
public interface CheckImageService {
	public BufferedImage getCheckImage(int codeNum,Map<String,Object> session);

}
