package dao;

import java.util.List;

import model.Category;

/**
*@author Zhiguang Cheng
*@date 2019��4��10�� ����9:43:42 
*@version 1.0 
**/
public interface CategoryDao extends BaseDao<Category> {
	//��ѯ�����Ϣ����������Ա
	public List<Category> queryJoinAccount(String type, int page, int size); //ʹ���������Ʋ�ѯ
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String type);
	//����idsɾ��������¼
	public void deleteByIds(String ids);
	//����boelenֵ��ѯ�ȵ����ȵ����
	public List<Category> queryByHot(boolean hot);

}
