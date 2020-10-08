package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class FrontController {
	Scanner sc;

	public FrontController() {
		sc = new Scanner(System.in);
		this.controlTower(this.makeTitle(),regTitle());
		sc.close();
	}

	// Job Control
	private void controlTower(String Main,String[] regMain) {		// Request : controlTower --> Server
		String[] logInfo;
		String[] goodsInfo;
		String[][] goodsList = null;
		String[][] salesList = null;
		String select;
		String ordCode;
		String goodsCode;
		BackController bc = new BackController();
		while (true) {	                   	        //1. logIn  : 성공 --> 2.    실패 --> 1.
			String[] user = logIn(Main);
			// Good Bye 탈출문
			if (user==null) {break;}
			logInfo = bc.logIn(user);

			if (logInfo != null) {   //BackController 방만 만들어 놔도 몇번째 방이 null인지 모르기 때문에 null이 아닌걸로 인식됨.
				while(true) {
					select = this.selectService(Main,logInfo);		//2. selectService
					// select 탈출문
					if(select.equals("0")) {break;}

					switch (select) {

					case "1":
						while(true) {
							goodsCode = this.sales(Main, logInfo);
							if(goodsCode.equals("0")) {break;}
							while(true) {
								goodsInfo = bc.getGoodsInfo(goodsCode);
								// 굿즈 세탁기 돌리기
								if(goodsInfo!=null) {goodsList = summaryGoods(goodsInfo, goodsList);}
								// 오버로딩
								goodsCode = sales(Main, logInfo, goodsList);

								if(goodsCode.equals("n")) {break;}
							}
							if(payments(goodsList)) {
								// 주문코드 작성(yyyyMMddhhmmss)
								Date now = new Date();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
								String uniCode = sdf.format(now);

								for (int i = 0; i < goodsList.length; i++) {
									goodsList[i][5] = uniCode;
								}
								// 판매정보 저장
								bc.stackGoodsInfo(goodsList);

								goodsCode = null;
								goodsList = null;
								goodsInfo = null;
							}else {
								goodsCode = null;
								goodsList = null;
								goodsInfo = null;
							}
						}
						break;
					case "2":
						byte count = 0; 
						ordCode = salesCancel(Main, logInfo);
						salesList = bc.searchOrder(ordCode);
						while(true) {

							goodsCode = salesCancel(Main, logInfo, salesList, count);
							count = 1;
							if(goodsCode.equals("0")) {break;}
							else if(goodsCode.equals("A")){
								 salesList = allCancel(Main,logInfo,salesList);
								 bc.cancelInfo(ordCode, salesList);
								 salesList = null;
								 break;
							}
							else {
								salesList = countCancel(goodsCode, salesList, bc, ordCode);
							}
						}
						break;
					case "3":
						while(true) {
							if((select = userManagement(Main,logInfo)).equals("1")){
								user = bc.userRegistration(userRegistration(Main, logInfo, regMain));
							}else if(select.equals("2")){
								user = bc.userAccMod(userAccMod(Main, logInfo));
							}else {break;}
						}

					case "4":

						break;

					}
				}		
				logInfo = null;
			}
		}
		print("\n\n [ POS를 종료합니다 ] ");
	}
	
	
	
	

	// 반품구현
	private String salesCancel(String Main, String[] logInfo) {
		String uniqCode;
		this.print(Main);

		this.print(" [ ");
		for(int i=0; i<logInfo.length; i++) {
			this.print(logInfo[i]);
			if(i!=logInfo.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [ 상품반품 ]\n\n");
		print(" [ 코드입력 ] : ");
		uniqCode = sc.next();

		return uniqCode;
	}
	// 반품구현 오버로드
	private String salesCancel(String Main, String[] logInfo, String[][] salesList, byte count) {
		String goodsCode;
		int tot = 0;
		this.print(Main);

		this.print(" [ ");
		for(int i=0; i<logInfo.length; i++) {
			this.print(logInfo[i]);
			if(i!=logInfo.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [ 상품반품 ] \n\n");
		// 상품리스트 다차원 배열
		print(" -------------------------------------------------- \n"+
				" 상품코드           상품명            단가            수량 \n" +
				" -------------------------------------------------- \n");
		if(salesList != null) {
			for (int i = 0; i < salesList.length; i++) {
				for (int j = 0; j < salesList[0].length; j++) {
					print(" " + salesList[i][j] + "\t\t");

				}
				tot += (Integer.parseInt(salesList[i][2])*Integer.parseInt(salesList[i][3]));
				print("\n");
			}
		}
		print(" -------------------------------------------------- \n");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
		String uniCode = sdf.format(now);
		print(" [ 합계 금액 ] : " + tot + "        [ 현재 시간 ] : " + uniCode + "\n" );
		print(" -------------------------------------------------- \n");

		print(" [ 상품반품 ]\n\n");
		if(count==0) {
		print(" [ 전부 반품은 A를 입력해주세요 ]\n");}else {

		print(" [ 반품을 끝내시려면 n을 입력해주세요 ]\n");
		}
		print(" [ 반품상품코드 입력 ] : ");
		goodsCode = sc.next();

		return goodsCode;
	}
	
	// 한번에 캔슬하기
	private String[][] allCancel(String Main, String[] logInfo ,String[][] salesList) {
		for (int i = 0; i < salesList.length; i++) {
			salesList[i][3] = "-"+salesList[i][3];
		}
		int tot = 0;
		this.print(Main);

		this.print(" [ ");
		for(int i=0; i<logInfo.length; i++) {
			this.print(logInfo[i]);
			if(i!=logInfo.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [ 상품반품 ] \n\n");
		// 상품리스트 다차원 배열
		print(" -------------------------------------------------- \n"+
				" 상품코드           상품명            단가            수량 \n" +
				" -------------------------------------------------- \n");
		if(salesList != null) {
			for (int i = 0; i < salesList.length; i++) {
				for (int j = 0; j < salesList[0].length; j++) {
					print(" " + salesList[i][j] + "\t\t");

				}
				tot += (Integer.parseInt(salesList[i][2])*Integer.parseInt(salesList[i][3]));
				print("\n");
			}
		}
		print(" -------------------------------------------------- \n");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
		String uniCode = sdf.format(now);
		print(" [ 합계 금액 ] : " + tot + "        [ 현재 시간 ] : " + uniCode + "\n" );
		print(" -------------------------------------------------- \n");

		print(" [ 상품반품 ]\n\n");
		print(" [ 정상적으로 판품처리 되었습니다 ]");
		return salesList;
	}
	
	// 캔슬 하나씩
	private String[][] countCancel(String goodsCode, String[][] salesList, BackController bc,String ordCode) {
		
		for (int i = 0; i < salesList.length; i++) {
			if(goodsCode.equals(salesList[i][0])) {
				salesList[i][3] = (Integer.parseInt(salesList[i][3])-1)+"";
				bc.cancelInfo(ordCode, salesList[i]);
				return salesList;
			}
		}
		return salesList;
	}

	// LogIn Job Contol
	private String[] logIn(String title) {
		String[] userInfo = new String[3];
		userInfo[0] = "A1";

		this.print(title);
		this.print(" [ Log In ]\n\n"); 
		this.print(" [ Employee Code ] : ");
		userInfo[1] = sc.next();

		if(userInfo[1].equals("0")) {
			userInfo = null;
		}else {		
			this.print(" [ Access Code ]   : ");
			userInfo[2] = sc.next();
		}
		return userInfo;
	}

	// Services Selection Job Control
	private String selectService(String title, String[] logInfo) {

		print(title);
		this.print(" [ ");
		for(int i=0; i<logInfo.length; i++) {
			this.print(logInfo[i]);
			if(i!=logInfo.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [서비스 선택]\n\n");
		this.print(" 1. 상품판매           2. 상품반품 \n");

		if(logInfo[2].equals("Manager")) {
			this.print(" 3. 직원관리           4. 영업관리\n");
		}
		print(" 0. 뒤로가기\n\n");

		this.print(" ________________________________ Select : ");
		return sc.next();
	}

	// User Registration Main
	private String userManagement(String title, String[] result) {
		this.print(title);

		this.print(" [ ");
		for(int i=0; i<result.length; i++) {
			this.print(result[i]);
			if(i!=result.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [직원관리]\n\n");
		this.print(" 1. 직원등록           2. 정보수정\n");
		this.print(" 0. 뒤로가기\n\n");

		this.print(" ________________________________ Select : ");

		return sc.next();
	}

	// User Registration
	private String[] userRegistration(String title, String[] result, String[] regMain) {
		String[] userInfo = new String[5];

		this.print(title);

		this.print(" [ ");
		for(int i=0; i<result.length; i++) {
			this.print(result[i]);
			if(i!=result.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [직원등록]\n\n");

		for (int i = 0; i < regMain.length; i++) {
			print(regMain[i]);
			userInfo[i] = sc.next();
		}

		return userInfo;
	}

	// userPassModify
	private String[] userAccMod(String title,String[] result) {
		String[] userInfo = new String[3];

		this.print(title);

		this.print(" [ ");
		for(int i=0; i<result.length; i++) {
			this.print(result[i]);
			if(i!=result.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		userInfo[0] = "A3";
		this.print(" [ 직원 비밀번호 수정 ]\n\n"); 
		this.print(" [ Employee Code ] : ");
		userInfo[1] = sc.next();
		this.print(" [ Access Code Of Mpdify ]   : ");
		userInfo[2] = sc.next();

		return userInfo;
	}


	// Sales
	private String sales(String Main, String[] logInfo) {
		print(Main);

		this.print(" [ ");
		for(int i=0; i<logInfo.length; i++) {
			this.print(logInfo[i]);
			if(i!=logInfo.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");
		this.print(" [ 상품판매 ] \n\n");
		// 상품리스트 다차원 배열
		print("\n [ 뒤로가려면 0 을 입력해주세요 ]");
		this.print(" [ 상품코드 입력 ] : ");
		String goodsCode = sc.next();
		return goodsCode;
	}	

	// Sales overoading
	private String sales(String Main, String[] logInfo, String[][] goodsList) {
		int tot = 0;
		String goodsCode;
		print(Main);

		this.print(" [ ");
		for(int i=0; i<logInfo.length; i++) {
			this.print(logInfo[i]);
			if(i!=logInfo.length-1) {this.print("    ");}
		}
		this.print(" ]\n\n");

		this.print(" [ 상품판매 ] \n\n");
		// 상품리스트 다차원 배열
		print(" -------------------------------------------------- \n"+
				" 상품코드           상품명            단가            수량 \n" +
				" -------------------------------------------------- \n");
		if(goodsList != null) {
			for (int i = 0; i < goodsList.length; i++) {
				for (int j = 0; j < goodsList[0].length-2; j++) {
					print(" " + goodsList[i][j] + "\t\t");

				}
				tot += (Integer.parseInt(goodsList[i][2])*Integer.parseInt(goodsList[i][3]));
				print("\n");
			}
		}
		print(" -------------------------------------------------- \n");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
		String uniCode = sdf.format(now);
		print(" [ 합계 금액 ] : " + tot + "        [ 현재 시간 ] : " + uniCode + "\n" );
		print(" -------------------------------------------------- \n");

		print("\n [ 결제하려면 n 을 입력해주세요 ]");
		this.print(" [ 상품코드 입력 ] : ");
		goodsCode = sc.next();

		return goodsCode;
	}
	// 데이터 스택쌓기
	private String[][] summaryGoods(String[] newGoods, String[][] goodsList) {

		// 유통기한 처리
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(now);
		// 유통기한이 오늘보다 크면 스택 아니면 그대로 반출
		if (Integer.parseInt(newGoods[4])>=Integer.parseInt(today)) {

			String[][] temp = null;
			if (goodsList==null) {
				goodsList = new String[1][];
			}else {

				// 중복값 처리
				for (int i = 0; i < goodsList.length; i++) {
					if(newGoods[0].equals(goodsList[i][0])) {
						goodsList[i][3] = (Integer.parseInt(goodsList[i][3]) + 1) + "";
						return goodsList;
					}
				}


				temp = new String[goodsList.length][];
				for (int i = 0; i < goodsList.length; i++) {
					temp[i] = goodsList[i];
				}
				goodsList = null;
				goodsList = new String[temp.length+1][];

				for (int i = 0; i < temp.length; i++) {
					goodsList[i] =  temp[i];
				}
			}
			goodsList[goodsList.length-1] = newGoods;
		}
		return goodsList;
	}


	// payment
	private boolean payments(String[][] goodsInfoList) {
		boolean isPayment;
		int tot = 0;
		int money = 0;

		for(int i=0; i<goodsInfoList.length; i++) {
			tot += (Integer.parseInt(goodsInfoList[i][2]) * Integer.parseInt(goodsInfoList[i][3]));		
		}

		this.print(" [ 받은금액 ] : ");
		money = Integer.parseInt(this.sc.next());
		this.print(" [ 거스름돈 ] : " + (money - tot)+"\n");

		this.print("\n [ 결제하시겠습니까 ] [ Yes(y) / No(n) ] : ");
		isPayment = this.sc.next().equals("y")? true : false;

		return isPayment;
	}


	// 타이틀 작성
	private String makeTitle() {
		StringBuffer sb = new StringBuffer();

		sb.append("\n\n");
		sb.append(" *************************************************\n");
		sb.append("\n");
		sb.append("         Point Of Sales System v1.0\n");
		sb.append("\n");
		sb.append("                     ★★★★\n");
		sb.append("                     ☆☆☆☆\n");
		sb.append("                     ☆☆☆☆\n");
		sb.append("\n");   
		sb.append("                      Designed by AbJul\n");
		sb.append("\n");
		sb.append(" *************************************************\n");


		return sb.toString();
	}
	// 질문 생성
	private String[] regTitle() {
		String[] Questions = new String[5];
		Questions[0] = " [ Employee  Code ] : ";
		Questions[1] = " [  Access  Code  ] : ";
		Questions[2] = " [ Employee  Name ] : ";
		Questions[3] = " [ Employee Phone ] : ";
		Questions[4] = " [ Employee Level ] : ";
		return Questions;
	}

	// 화면 출력
	private void print(String text) {
		System.out.print(text);
	}
}