package dao;

import java.util.List;

import model.Product;

/**
*@author Zhiguang Cheng
*@date 2019��4��10�� ����9:46:06 
*@version 1.0 
**/
public interface ProductDao extends BaseDao<Product>{
	//��ѯ��Ʒ��Ϣ���������
	public List<Product> queryJoinCategory(String type, int page, int size); //ʹ����Ʒ�����Ʋ�ѯ
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String type);
	//����idsɾ��������¼
	public void deleteByIds(String ids);
	//�����ȵ�����ѯ�Ƽ���Ʒ��������ѯǰ4����
	public List<Product> querByCategoryId(int cid);

}
