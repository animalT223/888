package baseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
		private String driver="com.mysql.jdbc.Driver";  //���ݿ������ַ���
		private String url="jdbc:mysql://localhost:3306/newsmanagersystem?useUnicode=true&characterEncoding=utf-8";   //����URL�ַ���
		private String user="root";   //���ݿ��û���
		private String password="";    //�û�����
		Connection conn=null;    //�������Ӷ���
		/**
		 * ��ȡ���ݿ����Ӷ���
		 */
		public Connection getConnection(){
			if(conn==null){
				try{
					Class.forName(driver);
					conn=DriverManager.getConnection(url, user, password);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return conn;
		}
	/**
	 * ���ӳ��������ݿ�
	 */
//	public Connection getConnection(){
//		Context ctx;
//		Connection con=null;
//		try {
//			ctx = new InitialContext();
//			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/news");
//			con=ds.getConnection();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//	}
		/**
		 * �ر����ݿ�����
		 */
		public void closeAll(Connection conn,Statement stmt,ResultSet rs){

			
				try {
					if (rs!=null) {
					rs.close();
					}
					if (stmt!=null) {
				stmt.close();
			}
					if (conn!=null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
}
