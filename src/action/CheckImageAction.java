package action;


import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

/**
*@author Zhiguang Cheng
*@date 2019年4月9日 下午4:11:22 
*@version 1.0 
**/
@Controller("checkImageAction")
public class CheckImageAction extends BaseAction<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510770566188877199L;
	@Override
	public String execute() throws IOException {
		BufferedImage bi = checkImageService.getCheckImage(4,session);
		ImageIO.write(bi,"jpeg",ServletActionContext.getResponse().getOutputStream());
		return NONE	;
		
	}


}
