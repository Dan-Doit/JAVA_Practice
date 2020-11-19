package servicE;

import java.sql.Connection;

import DB.DataBean;
import DB.JdbcUtil;
import daO.InputDAO;

public class InputService {
	
	public InputService() {
		
	}
	
	public void goInto(DataBean db, int num) {
		
		switch (num) {
		case 1:
			search(db);
			break;

		default:
			break;
		}
	}
	
	
	private void search(DataBean db) {
		
		Connection con = JdbcUtil.getConnection();
		
		InputDAO id = new InputDAO();
		if(!id.search(db,con)) {
			id.insert(db,con);
			db.setAaa(true);
			db.setResult("성공적으로 등록되었습니다.");
			
			JdbcUtil.commit(con);
			JdbcUtil.close(con);
			
		}else {
			db.setAaa(false);
			db.setResult("같은 이름이 중복되었습니다.");
			JdbcUtil.rollback(con);
			JdbcUtil.close(con);
			
			
		}
	}

}
