package action;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import model.BackData;
import model.Forder;
import model.SendData;
import model.User;

/**
*@author Zhiguang Cheng
*@date 2019年4月1日 下午10:06:03 
*@version 1.0 
**/
@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3193100512401195032L;
	private HttpServletRequest requestContext;
	@Override
	public Object getModel() {
		System.out.println("flag:"+requestContext.getParameter("pd_FrpId"));
		if(requestContext.getParameter("pd_FrpId") != null) {
			model = new SendData();
		} else {
			model = new BackData();
		}
		return model;
	}
	public String goBank() {
		SendData sendData = (SendData)model;
		Forder forder = (Forder) session.get("oldForder");
		User user = (User) session.get("user");
		sendData.setP2_Order(forder.getId()+""); //商户订单号
		sendData.setP3_Amt(forder.getTotal().toString()); //支付金额
		sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //商户扩展信息
		//2. 对参数进行追加		
		//3. 加密获取签名		
		//4. 存储到request域中
		payService.saveDataToRequest(request, sendData); //完成2,3,4
		//5. 跳转到支付页面
		return "pay";
		
	}
	public String backBank() {
		BackData backData = (BackData) model;
		System.out.println(model);
		try {
			boolean isOk = payService.checkBackData(backData);
			if(isOk) {
				forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()),2);
				String emailAddress = backData.getR8_MP().split(",")[0];
				emailUtil.orderEmail(emailAddress,backData.getR6_Order());
					System.out.println("-----------success!!---------");
			}else{
				System.out.println("------false-----!!");
			}
			return "back";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.requestContext = request;
	}
	



}
