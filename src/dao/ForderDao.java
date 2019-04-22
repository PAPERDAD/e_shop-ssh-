package dao;

import java.util.List;

import model.Forder;
import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019��4��10�� ����9:45:10 
*@version 1.0 
**/
public interface ForderDao extends BaseDao<Forder> {
	public void updateStatusById(int id, int sid);
	public List<Forder> queryJoinUserAndSorders(String type, int page, int size); //ʹ����Ʒ�����Ʋ�ѯ
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String type);

}
