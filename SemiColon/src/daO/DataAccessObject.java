package daO;

import static utilL.JdbcUtil.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import daO.BoardInfoBean;
import daO.PageInfoBean;
import daO.UserInfoBean;


public class DataAccessObject {

	private static DataAccessObject dao;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	CallableStatement cs;

	public DataAccessObject() {

	}

	// getInstance메소드
	public static DataAccessObject getInstance() {
		if (dao == null) {
			dao = new DataAccessObject();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}
	// 로그인 프로시져
	public boolean isAccess(UserInfoBean uib) {

		boolean result = false;

		String sql = "{call ISACCESS(?,?,?,?,?)}";

		try {
			cs = con.prepareCall(sql);

			cs.setNString(1, uib.getUserId());
			cs.setNString(2, uib.getUserPassword());
			cs.registerOutParameter(3, Types.NVARCHAR);
			cs.registerOutParameter(4, Types.NVARCHAR);
			cs.registerOutParameter(5, Types.NVARCHAR);
			cs.execute();
			uib.setUserId(cs.getString(3));
			uib.setUserPassword(null);
			uib.setUserName(cs.getString(4));
			uib.setUserLevel(cs.getString(5));


			result = uib.getUserName()!=null?true:false;



		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(cs);
		}

		return result;

	}
	// 중복된 아이디 체크
	public boolean isSame(UserInfoBean uib) {

		boolean result = true;

		String sql = "SELECT COUNT(USERID) FROM SEMIUSER WHERE USERID=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setNString(1, uib.getUserId());

			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1)==1?false:true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}

		return result;

	}
	// 유저 등록
	public boolean regUser(UserInfoBean uib) {

		boolean result = false;

		String sql = "INSERT INTO SEMIUSER VALUES (?,?,?,1,?,?,TO_DATE(?,\'YYYY-MM-DDHH24MISS\'),DEFAULT)";

		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, uib.getUserId());
			ps.setNString(2, uib.getUserPassword());
			ps.setNString(3, uib.getUserName());
			ps.setNString(4, uib.getUserAdd());
			ps.setNString(5, uib.getUserPhone());
			ps.setNString(6, uib.getUserDate());
			
			result = ps.executeUpdate()==1?true:false;
			System.out.println(result);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;

	}
	
	// 맥스값 가져오기
	public boolean getCount(PageInfoBean pig) {

		boolean result = false;

		String sql = "SELECT COUNT(BNUM) FROM BOARD";

		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				pig.setCount(rs.getInt(1));
				result = true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}

		return result;

	}
	
	// 리스트 불러오기
	public boolean getBoardList(ArrayList<BoardInfoBean> boardList,PageInfoBean pig) {

		boolean result = false;
		
		BoardInfoBean bib;
		
		String sql = "SELECT BO_USERID,BNUM,BO_TITLE,BO_WRITER,BO_DATE,HITS\r\n"
				+ "FROM (SELECT BO_USERID,BNUM,BO_TITLE,BO_WRITER,BO_DATE,HITS,ROW_NUMBER() OVER(ORDER BY BNUM DESC) AS RN \r\n"
				+ "FROM BOARD)\r\n"
				+ "WHERE RN BETWEEN ? AND ?";

		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, pig.getStartRow());
			ps.setInt(2, pig.getEndRow());

			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				 result = true;
				 bib = new BoardInfoBean();
				 bib.setBo_Userid(rs.getNString(1));
				 bib.setBo_Num(rs.getInt(2));
				 bib.setBo_Title(rs.getNString(3));
				 bib.setBo_Writer(rs.getNString(4));
				 bib.setBo_Date(rs.getNString(5));
				 bib.setBo_Hits(rs.getInt(6));
				 
				 boardList.add(bib);
			}
			result = boardList.get(0).getBo_Title()!=null ? true:false;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
			close(rs);
		}

		return result;

	}
	// 게시판 등록
	public boolean insertBoard(BoardInfoBean bib) {

		boolean result = false;
		
		String sql = "INSERT INTO BOARD VALUES(?,DAN.NEXTVAL,?,?,SYSDATE,?,?,0)";
		
		
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, bib.getBo_Userid());
			ps.setNString(2, bib.getBo_Title());
			ps.setNString(3, bib.getBo_Writer());
			ps.setNString(4, bib.getBo_Content());
			ps.setNString(5, bib.getBo_FileName());
			
			result = ps.executeUpdate()==1?true:false;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}

		return result;

	}
	// 클릭수 올리고 디테일 추출
	public boolean getDetail(BoardInfoBean bib) {

		boolean result = false;

		String sql = "{call GETDETAIL(?,?,?,?,?,?,?,?,?,?)}";

		try {
			cs = con.prepareCall(sql);

			cs.setInt(1, bib.getBo_Num());
			cs.setInt(2, bib.getBo_Hits());
			cs.registerOutParameter(3, Types.NVARCHAR);
			cs.registerOutParameter(4, Types.NUMERIC);
			cs.registerOutParameter(5, Types.NVARCHAR);
			cs.registerOutParameter(6, Types.NVARCHAR);
			cs.registerOutParameter(7, Types.NVARCHAR);
			cs.registerOutParameter(8, Types.NVARCHAR);
			cs.registerOutParameter(9, Types.NVARCHAR);
			cs.registerOutParameter(10, Types.NUMERIC);
			cs.execute();
			
			bib.setBo_Userid(cs.getNString(3));
		    bib.setBo_Num(cs.getInt(4));
			bib.setBo_Title(cs.getNString(5));
			bib.setBo_Writer(cs.getNString(6));
			bib.setBo_Date(cs.getNString(7));
			bib.setBo_Content(cs.getNString(8));
			bib.setBo_FileName(cs.getNString(9));
			bib.setBo_Hits(cs.getInt(10));

			result = bib.getBo_Title()!=null?true:false;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(cs);
		}

		return result;

	}
	
	// 게시판 수정
	public boolean updateBoard(BoardInfoBean bib) {

		boolean result = false;
		
		String sql = "UPDATE BOARD SET BO_TITLE=?,BO_DATE=SYSDATE,BO_CONTENT=?,BO_FILENAME=? WHERE BO_USERID = ? AND BNUM=?";
		
		
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, bib.getBo_Title());
			ps.setNString(2, bib.getBo_Content());
			ps.setNString(3, bib.getBo_FileName());
			ps.setNString(4, bib.getBo_Userid());
			ps.setInt(5, bib.getBo_Num());
			
			result = ps.executeUpdate()==1?true:false;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}

		return result;

	}
	
	// 게시판 삭제

	public boolean deleteBoard(BoardInfoBean bib) {
		
		boolean result = false;
		
		String sql = "DELETE FROM SRP.BOARD WHERE BO_USERID=? AND BNUM=?";
		
		
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, bib.getBo_Userid());
			ps.setInt(2, bib.getBo_Num());
			
			result = ps.executeUpdate()==1?true:false;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}

		return result;
 

	}


}
