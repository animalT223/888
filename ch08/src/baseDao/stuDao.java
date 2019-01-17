package baseDao;

import java.util.List;

import entity.stu;

public interface stuDao {
		/**
		 * 查询
		 */
	List<stu> getInfo();
	/**
	 * 修改
	 */
	int setUpda(String sname,String sno);
	/**
	 * 删除
	 */
	int setDel(String sno);
	/**
	 * 新增
	 */
	int setIns(String name,String no);
	/**
	 * 获取总页数
	 */
	int getSumPage();
	/**
	 * 登录
	 */
	boolean getName(String name,String pwd);
}
