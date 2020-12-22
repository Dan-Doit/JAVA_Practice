package servicE;

import static utilL.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import daO.DataAccessObject;
import daO.BoardInfoBean;
import daO.PageInfoBean;

public class BoardService {

	
	
	Connection con;
	DataAccessObject dao;
	
	
	public BoardService() {
		
		con = getConnection();
		dao = DataAccessObject.getInstance();
		dao.setConnection(con);
		
	}
	
	public boolean flag(ArrayList<BoardInfoBean> BoardList, PageInfoBean pig,int request) {
		boolean result = false;
		
		switch (request) {
		
		case 1:
			result = getBoardList(BoardList,pig);
			break;

		default:
			break;
		}
		
		return result;
		
	}
	// 오버로드
	public boolean flag(BoardInfoBean bib ,int request) {
		boolean result = false;
		
		switch (request) {
		case 1:
			result = insertBoard(bib);
			break;
		case 2:
			result = getDetail(bib);
			break;
		case 3:
			result = updateBoard(bib);
			break;
		case 4:
			result = deleteBoard(bib);
			break;
			
		default:
			break;

		}
		return result;
	}
	// 전체리스트
	private boolean getBoardList(ArrayList<BoardInfoBean> BoardList, PageInfoBean pig){
		boolean result  = false;
		
		if(dao.getCount(pig)) {
			if(dao.getBoardList(BoardList,pig)) result=true;
		}
		close(con);	
		
		return result;
	}
	// 삽입
	private boolean insertBoard(BoardInfoBean bib){
		boolean result  = false;
		
		if(dao.insertBoard(bib)) {
			commit(con);
			System.out.println("등록 성공");
			result = true;
		}else {
			rollback(con);
			System.out.println("등록 실패");
		}
		close(con);	
		
		return result;
	}
	// 디테일
	private boolean getDetail(BoardInfoBean bib){
		boolean result  = false;
		
		if(dao.getDetail(bib)) result = true;

		close(con);	
		
		return result;
	}
	// 업데이트
	private boolean updateBoard(BoardInfoBean bib){
		boolean result  = false;
		
		if(dao.updateBoard(bib)) {
			commit(con);
			System.out.println("수정 성공");
			result = true;
		}else {
			rollback(con);
			System.out.println("수정 실패");
		}
		close(con);	
		
		return result;
	}
	
	// 삭제
	private boolean deleteBoard(BoardInfoBean bib){
		boolean result  = false;
		
		if(dao.deleteBoard(bib)) {
			commit(con);
			System.out.println("삭제 성공");
			result = true;
		}else {
			rollback(con);
			System.out.println("삭제 실패");
		}
		close(con);	
		
		return result;
	}
	
	
	
	
	

}
