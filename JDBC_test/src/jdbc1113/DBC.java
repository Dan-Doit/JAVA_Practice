package jdbc1113;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	public static Connection DBconnect() {
		
		// DB에 접속정보 저장을 위한 connection 타입의 변수 con 선언
		Connection con = null;
		
		// 접속할 DB의 주소정보
		// String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String url = "jdbc:oracle:thin:@192.168.0.220:1521:XE";
		
		// 접속할 유저의 계정정보
		String user = "DOOLY";
		String pass = "0000";
		
		// Database Driver 설정
		try {
			// ojdbc6 파일 현재 소스에 적용
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// con에 정보를 저장
			con = DriverManager.getConnection(url,user,pass);
			System.out.println(" DB접속 성공");
			

		}catch(ClassNotFoundException cne) {
			// 드라이버가 재대로 작동하지 않은경우
			// printStackTrace() 오류가 발생했을경우 경로를 알려준다.
			cne.printStackTrace();
			System.out.println(" DB접속 실패 : 드라이버");
		}catch (SQLException se) {
			// DB 계정 정보 오류
			se.printStackTrace();
			System.out.println(" DB접속 실패 : DB계정");
		}
		
		return con;
		
	}
}
