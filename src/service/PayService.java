package service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import model.BackData;
import model.SendData;

/**
*@author Zhiguang Cheng
*@date 2019��4��1�� ����10:14:44 
*@version 1.0 
**/

public interface PayService {
	public abstract Map<String, Object> saveDataToRequest(
            Map<String, Object> request, SendData sendData);

    //�ѷ��ص����ݽ��м��ܵõ����ģ����봫���������ıȽϣ������Ǻ�������ʵ�֣�
    public boolean checkBackData(BackData backData) throws UnsupportedEncodingException;

}
