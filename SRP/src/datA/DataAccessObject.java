package datA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dB.JdbcUtil;

public class DataAccessObject {
	
	
	private static DataAccessObject dao;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public DataAccessObject() {
		
	}

	// getinstance
	public static DataAccessObject getInstance() {
		if(dao==null) {
			dao = new DataAccessObject();
		}
			return dao;

	}
	
	// getcon
	public void getCon(Connection con) {
		this.con = con;
	}
	
	
	public boolean isAccess(TeacherInfoBean tib, Connection con) {
		
		boolean result = false;
		
		String sql = "select count(te_code) as count from te where te_code = ? and te_pwd = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, tib.getId());
			ps.setString(2, tib.getPwd());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("count")==1?true:false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public void getTeInfo(TeacherInfoBean tib,Connection con) {
		boolean result = false;
		
		String sql = "SELECT TE_NAME , SU_NAME, TE_LEVEL, TE_GRCODE, TE_CLCODE, COUNT(ST_NAME) FROM TE \r\n"
				+ "INNER JOIN SU ON SU_CODE = TE_SUCODE INNER JOIN ST ON ST_GRCODE = TE_GRCODE AND TE_CLCODE = ST_CLCODE\r\n"
				+ "WHERE TE_CODE = ? AND TE_PWD = ?\r\n"
				+ "GROUP BY TE_NAME , SU_NAME, TE_LEVEL, TE_GRCODE, TE_CLCODE";
		
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, tib.getId());
			ps.setString(2, tib.getPwd());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				tib.setName(rs.getString(1));
				tib.setSubject(rs.getString(2));
				tib.setLevel(rs.getString(3));
				tib.setGrade(rs.getString(4));
				tib.setTeclass(rs.getString(5));
				tib.setStudents(rs.getString(6));
				
				System.out.println(rs.getNString("TE_NAME"));
				System.out.println(rs.getNString("SU_NAME"));
				
			}
			
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}


}
