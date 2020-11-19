package DB;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class JdbcUtil {
	// 따로 변수에 의해 수정이 안되도록 static으로 지정해줌
	public static Connection getConnection() {
		
		Connection con = null;
		
		// tomcat의 내용을 xml내용으로 가져오는 작업
		
		try {
			// Context.xml파일의 정보를 가져오기위한 Context Class 생성
			Context initCtx = new InitialContext();
			// 경로 찾아오기
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
			
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			System.out.println("접속성공");
		
		} catch (Exception e) {
			System.out.println("접속실패");
			e.printStackTrace();
			
		}
		
		
		
		return con;
		
	}
	
	// close : con
	public static void close(Connection con) {
		
		try {
			con.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	// close : stmt
	public static void close(Statement stmt) {
		
		try {
			stmt.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	
	// close : pstmt
	public static void close(PreparedStatement pstmt) {
		
		try {
			pstmt.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	// close : rs
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	
	// commit
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// rollback
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
