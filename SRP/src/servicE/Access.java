package servicE;

import java.sql.Connection;

import dB.JdbcUtil;
import datA.DataAccessObject;
import datA.TeacherInfoBean;

public class Access {
	
	public Access() {
		
	}
	
	public void logic(TeacherInfoBean tib, int index) {
		
		switch (index) {
		case 1:
			Access(tib);
			break;

		default:
			break;
		}
		
	}
	
	
	private void Access(TeacherInfoBean tib) {
		
		Connection con = JdbcUtil.getConnection();
		
		DataAccessObject dao = DataAccessObject.getInstance();
		dao.getCon(con);
		
		if(dao.isAccess(tib, con)) {
			dao.getTeInfo(tib, con);
			tib.setState(true);
		}else {
			tib.setState(false);
		}
		
		JdbcUtil.close(con);
		
		
		
		
	}

}
