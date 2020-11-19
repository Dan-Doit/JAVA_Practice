package daO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DataBean;
import DB.JdbcUtil;

public class InputDAO {
	private static InputDAO dao;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public InputDAO() {

	}
	
	
	public boolean search(DataBean db, Connection con) {
		
		boolean result = false;
		
		String sql = "SELECT COUNT(STU_NAME) AS COUNT FROM COMEIN.STUDENT WHERE STU_NAME = ? GROUP BY STU_NAME";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, db.getId());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("COUNT")==1?true:false;
			}
			JdbcUtil.close(rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	public int insert(DataBean db, Connection con) {
		int result = 0;
		String sql = "INSERT INTO COMEIN.STUDENT VALUES (?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, db.getId());
			ps.setString(2, db.getPw());
			
			result = ps.executeUpdate();
			
			JdbcUtil.close(ps);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
//	// getInstance 매소드
//	public static InputDAO getInstace() {
//		
//		if(dao == null) {
//			dao = new InputDAO();
//		}
//		return dao;
//		
//	}
//	
//	// setConnection 매소드
//	public void setConnection(Connection con) {
//		this.con = con;
//		
//	}
}
