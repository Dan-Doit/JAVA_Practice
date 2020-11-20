package bacK;

import datA.TeacherInfoBean;
import servicE.Access;

public class Back {
	
	public Back() {
		
	}
	
	public String[] login(String id, String pwd) {
		
		TeacherInfoBean tib = new TeacherInfoBean();
		
		tib.setId(id);
		tib.setPwd(pwd);
		
		Access ac = new Access();
		
		ac.logic(tib, 1);
		String[] info = null;
		if (tib.isState()) {
			info = new String[6];
			info[0] = tib.getName();
			info[1] = tib.getSubject();
			info[2] = tib.getLevel();
			info[3] = tib.getGrade();
			info[4] = tib.getTeclass();
			info[5] = tib.getStudents();
		}
		
		return info;
	}
	
	
	
}
