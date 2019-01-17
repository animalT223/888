package baseDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import baseDao.BaseDao;
import baseDao.stuDao;
import entity.stu;

import utitiy.StuUtitiy;

public class stuImpl extends BaseDao implements stuDao{
/**
 * 查询
 */
	public List<stu> getInfo() {
		List<stu> list=new ArrayList<stu>();;
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		conn=super.getConnection();
		//int i=(curPage-1)*StuUtitiy.PAGE_NO;
		String sql="select * from stu";
		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while (rs.next()) {
				stu s=new stu();
				s.setSno(rs.getString("sno"));
				s.setSna(rs.getString("sna"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(conn, stat, rs);
		}
		return list;
	}


/**
 * 修改
 */
	public int setUpda(String sname, String sno) {
		Connection conn=null;
		PreparedStatement stmt=null;
		conn=super.getConnection();
		String sql="update stu set sna=? where sno=?";
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, sname);
			stmt.setString(2, sno);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

/**
 * 删除
 */
public int setDel(String sno) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	conn=super.getConnection();
	String sql="delete from stu where sno=?";
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sno);
		return pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
}

/**
 * 新增
 */
public int setIns(String name, String no) {
	Connection conn=null;
	Statement stmt=null;
	conn=super.getConnection();
	String sql="insert into stu values('"+no+"','"+name+"')";
	try {
		stmt=conn.createStatement();
		
		return stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
}

/**
 * 获取总页数
 */
public int getSumPage() {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	int page=0;    //总页数
	conn=super.getConnection();
	String sql="select count(*) from stu";
	try {
		stmt=conn.createStatement();
		rs = stmt.executeQuery(sql);
		int count=0;
		if(rs.next()){
			count=rs.getInt(1);
		}
		page=count%StuUtitiy.PAGE_NO==0?(count/StuUtitiy.PAGE_NO):(count/StuUtitiy.PAGE_NO+1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return page;
}

/**
 * 
 * 登录
 */
public boolean getName(String name, String pwd) {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	conn=super.getConnection();
	String sql="select * from stu where sno=? and sna=?";
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}
	
}
