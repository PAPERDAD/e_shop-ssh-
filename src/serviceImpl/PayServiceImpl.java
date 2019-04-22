package serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import model.BackData;
import model.SendData;
import service.PayService;
import utilImpl.DigestUtil;

/**
*@author Zhiguang Cheng
*@date 2019年4月1日 下午10:35:35 
*@version 1.0 
**/
@Service("payService")
public class PayServiceImpl implements PayService{
	@Value("${pay.key}")
	private String key;
	@Value("${pay.p1_MerId}")
	private String p1_MerId;
	@Value("${pay.p8_Url}")
	private String p8_Url;
	
	private SendData finishSendData(SendData sendData) {
        sendData.setP0_Cmd("Buy");
        sendData.setP1_MerId(p1_MerId);
        sendData.setP4_Cur("CNY");
        sendData.setP5_Pid("");
        sendData.setP6_Pcat("");
        sendData.setP7_Pdesc("");
        sendData.setP8_Url(p8_Url);
        sendData.setP9_SAF("0");
        sendData.setPr_NeedResponse("0");
        return sendData;
	}

	private String joinSendDataParam(SendData sendData) {
		sendData = this.finishSendData(sendData);
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append(sendData.getP0_Cmd());
        infoBuffer.append(sendData.getP1_MerId());
        infoBuffer.append(sendData.getP2_Order());
        infoBuffer.append(sendData.getP3_Amt());
        infoBuffer.append(sendData.getP4_Cur());
        infoBuffer.append(sendData.getP5_Pid());
        infoBuffer.append(sendData.getP6_Pcat());
        infoBuffer.append(sendData.getP7_Pdesc());
        infoBuffer.append(sendData.getP8_Url());
        infoBuffer.append(sendData.getP9_SAF());
        infoBuffer.append(sendData.getPa_MP());
        infoBuffer.append(sendData.getPd_FrpId());
        infoBuffer.append(sendData.getPr_NeedResponse());
        return infoBuffer.toString();

		
	}
	@Override
	public Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData) {
		// TODO Auto-generated method stub
        String joinParam = joinSendDataParam(sendData);
        request.put("p0_Cmd", sendData.getP0_Cmd());
        request.put("p1_MerId", sendData.getP1_MerId());
        request.put("p2_Order", sendData.getP2_Order());
        request.put("p3_Amt", sendData.getP3_Amt());
        request.put("p4_Cur", sendData.getP4_Cur());
        request.put("p5_Pid", sendData.getP5_Pid());
        request.put("p6_Pcat", sendData.getP6_Pcat());
        request.put("p7_Pdesc", sendData.getP7_Pdesc());
        request.put("p8_Url", sendData.getP8_Url());
        request.put("p9_SAF", sendData.getP9_SAF());
        request.put("pa_MP", sendData.getPa_MP());
        request.put("pd_FrpId", sendData.getPd_FrpId());
        request.put("pr_NeedResponse", sendData.getPr_NeedResponse());
        request.put("hmac", DigestUtil.hmacSign(joinParam, key));//追加之后的签名（密文）
        return request;

	}

	@Override
	public boolean checkBackData(BackData backData) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
        // 获取所有的明文
        String r0_Cmd = formatString(backData.getR0_Cmd()); 
        String p1_MerId = backData.getP1_MerId();
        String r1_Code = formatString( backData.getR1_Code());
        String r2_TrxId = formatString( backData.getR2_TrxId());
        String r3_Amt = formatString( backData.getR3_Amt());
        String r4_Cur = formatString( backData.getR4_Cur());
        String r5_Pid = new String(formatString(
					 backData.getR5_Pid()).getBytes("iso-8859-1"),
			        "UTF-8");
        String r6_Order = formatString( backData.getR6_Order());
        String r7_Uid = formatString( backData.getR7_Uid());
        String r8_MP = new String(formatString(
        		 backData.getR8_MP()).getBytes("iso-8859-1"),
                "UTF-8");
        String r9_BType = formatString( backData.getR9_BType());
        // 对明文进行数据追加
        String hmac = formatString(backData.getHmac());
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append(p1_MerId);
        infoBuffer.append(r0_Cmd);
        infoBuffer.append(r1_Code);
        infoBuffer.append(r2_TrxId);
        infoBuffer.append(r3_Amt);
        infoBuffer.append(r4_Cur);
        infoBuffer.append(r5_Pid);
        infoBuffer.append(r6_Order);
        infoBuffer.append(r7_Uid);
        infoBuffer.append(r8_MP);
        infoBuffer.append(r9_BType);
        // 对返回的明文进行加密
        String md5 = DigestUtil.hmacSign(infoBuffer.toString(), key);
        // 判断加密的密文与传过来的数据签名是否相等
        boolean isOK = md5.equals(hmac);

		return isOK;
	}
	
   public  String formatString(String text) {
        if (text == null) {
            return "";
        }
        return text;
    }


}
