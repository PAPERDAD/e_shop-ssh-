package service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import model.BackData;
import model.SendData;

/**
*@author Zhiguang Cheng
*@date 2019年4月1日 下午10:14:44 
*@version 1.0 
**/

public interface PayService {
	public abstract Map<String, Object> saveDataToRequest(
            Map<String, Object> request, SendData sendData);

    //把返回的数据进行加密得到密文，并与传回来的密文比较，（我们后面再来实现）
    public boolean checkBackData(BackData backData) throws UnsupportedEncodingException;

}
