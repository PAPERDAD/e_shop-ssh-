package serviceImpl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import service.CheckImageService;

/**
*@author Zhiguang Cheng
*@date 2019年4月9日 下午8:05:55 
*@version 1.0 
**/
@Service("checkImageService")
public class CheckImageServiceImpl implements CheckImageService{

	@Override
	public BufferedImage getCheckImage(int codeNum, Map<String, Object> session) {
		// TODO Auto-generated method stub
		int width = 30*codeNum+20;
		int height = 30;
		BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(getRandColor(200,250));
		graphics.fillRect(0,0,width,height);
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0,0,width-1,height-1);
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setFont(new Font("宋体",Font.BOLD,22));
		String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int x = 10;
		for (int i = 0;i < codeNum;i++) {
			graphics2D.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			int angle = random.nextInt(60)-30;
			double theta = angle * Math.PI/180;
			int index = random.nextInt(words.length());
			char c  = words.charAt(index);
			sb.append(c);
			graphics2D.rotate(theta,x,20);
			graphics2D.drawString(String.valueOf(c),x,20);
			graphics2D.rotate(-theta,x,20);
			x += 30;
			
		}
		session.put("checkCode",sb.toString());
		graphics.setColor(getRandColor(160,200));
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i=0;i<30;i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(12);
			y1 = random.nextInt(height);
			y2 = random.nextInt(12);
			graphics.drawLine(x1,y1,x1+x2,x2+y2);
		}
		graphics.dispose();
		return bufferedImage;
	}
	
	public Color getRandColor(int fc,int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc-fc);
		int g = fc + random.nextInt(bc-fc);
		int b = fc + random.nextInt(bc-fc);
		return new Color(r,g,b);
	}

}
