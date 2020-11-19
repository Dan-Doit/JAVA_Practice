package dtO;

import javax.sound.midi.MidiDevice.Info;

import DB.DataBean;
import servicE.InputService;

public class Inputback {

	public Inputback() {
		
	}
	
	public String[] input(String id, String pw) {
		DataBean db = new DataBean();
		
		db.setId(id);
		db.setPw(pw);
		
		InputService is = new InputService();
		is.goInto(db, 1);
		
		String[] info = new String[3];
		if(db.isAaa()) {		
			info[0] = db.getId();
			info[1] = db.getPw();
			info[2] = db.getResult();
		}else {
			info[2] = db.getResult();
		}
		
		return info;
	}

}
