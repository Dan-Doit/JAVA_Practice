package jdbc1113;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//이런식으로 한번에 불러오기도 가능하다.
import java.sql.*;

public class CRUD_SQL {
	
	// DB점속을 위한 변수 con선언
	Connection con = null;
	
	
	// 물음표 변수처리를 위한 preparestatmaent 사용
	PreparedStatement ps;
	// resultset 소환
	ResultSet rs=null;
	
	// DB접속
	public void connect() {
		
		con = DBC.DBconnect();
		
	}
	
	// DB접속 해제
	public void conClose() {
		try {
			con.close();
			System.out.println(" DB접속 해제");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(" DB접속해제 실패!");
		}
	}
	// 학생등록
	public void stuIns(CRUD_DTO stu) {
		
		String sql = "INSERT INTO COMEIN.STUDENT VALUES(?,?)";
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, stu.getStuName());
			ps.setInt(2, stu.getStuAge());
			
			ps.executeUpdate();
			
			System.out.println(" 학생등록 성공");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" 학생등록 실패");
		}
	}

	public void stuInfo(CRUD_DTO stu) {
		
		
		String sql = "SELECT STU_AGE FROM COMEIN.STUDENT WHERE STU_NAME = ?";
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, stu.getStuName());
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				stu.setStuAge(rs.getInt("STU_AGE"));
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println(" 경로 찾기 오류");
			e.printStackTrace();
		}
		
	}

	public void modInfo(CRUD_DTO stu) {
		
		String sql = "UPDATE COMEIN.STUDENT SET STU_AGE = ? WHERE STU_NAME = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, stu.getStuAge());
			ps.setNString(2, stu.getStuName());
			
			ps.executeUpdate();
			
			System.out.println(" 데이터가 변경되었습니다.");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	public void delstu(CRUD_DTO stu) {
		
		String sql = "DELETE FROM COMEIN.STUDENT WHERE STU_NAME = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, stu.getStuName());
			ps.executeUpdate();
			System.out.println("계정삭제 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
