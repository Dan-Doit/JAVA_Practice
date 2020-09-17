package frontend.calculator;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FrontEnd {
	public FrontEnd() {
		
	}

	/*
	public void title() {
		System.out.println("******************************************\n"+
							"\n"+
							"     Four Arithmetical Operator v1.0\n"+
							"\n"+
							"			 Designed by DAN\n"+
							"\n"+
							"******************************************"
							);
	}
	*/

	public void sum() {
		StringBuffer n = new StringBuffer();
				n.append("******************************************\n");
				n.append("\n");
				n.append("     Four Arithmetical Operator v1.0\n");
				n.append("\n");
				n.append("			 Designed by DAN\n");
				n.append("\n"); 
				n.append("******************************************");
		this.print(n.toString());
	}
	
	public void print(String n) {
		System.out.println(n);
	}
}
