package baseDao;

import java.util.List;

import entity.stu;

public interface stuDao {
		/**
		 * ��ѯ
		 */
	List<stu> getInfo();
	/**
	 * �޸�
	 */
	int setUpda(String sname,String sno);
	/**
	 * ɾ��
	 */
	int setDel(String sno);
	/**
	 * ����
	 */
	int setIns(String name,String no);
	/**
	 * ��ȡ��ҳ��
	 */
	int getSumPage();
	/**
	 * ��¼
	 */
	boolean getName(String name,String pwd);
}
