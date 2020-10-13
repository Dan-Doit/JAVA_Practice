package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class DataAccessObject {
	private String[] filePath = { 
			"C:\\Users\\zmffh\\OneDrive\\Desktop\\JAVA\\pos2\\src\\data\\saler.txt",
			"C:\\Users\\zmffh\\OneDrive\\Desktop\\JAVA\\pos2\\src\\data\\history.txt" , 
			"C:\\Users\\zmffh\\OneDrive\\Desktop\\JAVA\\pos2\\src\\data\\salesInfo.txt", 
	"C:\\Users\\zmffh\\OneDrive\\Desktop\\JAVA\\pos2\\src\\data\\goods.txt"};
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;

	public DataAccessObject(){}

	// 직원코드 여부 확인
	public boolean isEmployee(int fileIndex, UserInfoBean uib) {
		boolean result = false;
		file = new File(filePath[fileIndex]);
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String record = null;
			while ((record = br.readLine()) !=null) { // 괄호에 있는거 먼저 실행하고 트루인지 판단함.

				if (uib.getEmployeeCode().equals(record.substring(0,4))) {
					result = true;
					br.close();
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	// 패스워드 여부 확인
	public boolean isAccess(int fileIndex, UserInfoBean uib) { 
		boolean result = false;
		file = new File(filePath[fileIndex]);
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String record;
			while ((record = br.readLine()) !=null) {
				if (uib.getEmployeeCode().equals(record.substring(0,4))) {
					String pass = record.substring(5);
					if (uib.getAccessCode().equals(pass.substring(0,pass.indexOf(",")))) {
						result = true; //*참인걸 구별해 줘야 하기 때문에 true를 입력해줘야함
						br.close();
						break;
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	// 특정 직원정보 가져오기
	public void getUserInfo(int fileIndex, UserInfoBean uib) {
		file = new File(filePath[fileIndex]);
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String record;
			while ((record=br.readLine()) != null) {
				if (uib.getEmployeeCode().equals(record.substring(0,4))) {
					String pass = record.substring(5);
					if (uib.getAccessCode().equals(pass.substring(0,pass.indexOf(",")))) {
						pass = pass.substring(pass.indexOf(",")+1);

						uib.setUserName(pass.substring(0, pass.indexOf(",")));

						pass = pass.substring(pass.indexOf(",")+1);


						pass = pass.substring(pass.indexOf(",")+1);

						uib.setUserLevel(pass.equals("M")? true:false);
						//  	스플릿을 이용한 방식
						//   	String arr[]=record.split(",");
						//		uib.setUserName(arr[2]);
						//		uib.setAccessTime(arr[3]);
						//		uib.setUserLevel(arr[4].equals("M")? true:false);	
						br.close();
						break;
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 로그인기록 남기기
	public void setLogInInfo(int fileIndex, UserInfoBean uib) {
		file = new File(filePath[fileIndex]);
		String info = uib.getEmployeeCode()+","+uib.getAccessTime()+","+"1"+"\n";
		//코드 시간 1, -1저장
		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);

			bw.write(info);// 줄바꿈을 하고싶을땐 반드시 +"\n"을 해줘야함
			bw.flush(); // 저장되어있던 메모리를 삭제해줌 write를 쓰고나서 메모리가 남아있기 때문에,write를 많이쓸떄 사용 
			bw.close();//원칙상 써줘야함

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사용자 정보 저장
	public boolean setUserReg(int fileIndex, UserInfoBean uib) {
		boolean result = false;
		file = new File(filePath[fileIndex]);
		String info = uib.getEmployeeCode() +","+ uib.getAccessCode() +","+ uib.getUserName()
		+","+uib.getUserPhone() +","+(uib.isUserLevel()?"M":"A")+"\n";
		//코드 시간 1, -1저장
		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);

			bw.write(info);// 줄바꿈을 하고싶을땐 반드시 +"\n"을 해줘야함
			bw.flush(); // 저장되어있던 메모리를 삭제해줌 write를 쓰고나서 메모리가 남아있기 때문에,write를 많이쓸떄 사용 
			bw.close();//원칙상 써줘야함

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 빈 리스트 안에 값넣기
	public ArrayList<UserInfoBean> getUserInfoMod(int fileIndex) {
		UserInfoBean uib;
		ArrayList<UserInfoBean> al = new ArrayList<UserInfoBean>();
		file = new File(filePath[fileIndex]);
		String record;
		String[] temp;

		try {
			br = new BufferedReader(new FileReader(file));

			while((record = br.readLine())!=null) {
				uib = new UserInfoBean();
				temp = record.split(",");
				uib.setEmployeeCode(temp[0]);
				uib.setAccessCode(temp[1]);
				uib.setUserName(temp[2]);
				uib.setUserPhone(temp[3]);
				uib.setUserLevel((temp[4]).equals("M")?true:false);

				al.add(uib);
			}
			br.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return al;
	}
	// 빈 리스트값 덮어씌우기
	public boolean setUserInfoMod(int fileIndex,ArrayList<UserInfoBean> al) {
		boolean result = false;
		file = new File(filePath[fileIndex]);
		String info;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for(UserInfoBean uib : al) {
				info = uib.getEmployeeCode() +","+ uib.getAccessCode() +","+ uib.getUserName()
				+","+uib.getUserPhone() +","+(uib.isUserLevel()?"M":"A")+"\n";

				bw.write(info);
				bw.flush(); 
			}
			bw.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void getGoodsInfo(int fileIndex, GoodsInfoBean gib) {
		file = new File(filePath[fileIndex]);
		String[] temp;

		try {
			br = new BufferedReader(new FileReader(file));
			while((temp=(br.readLine().split(",")))!= null) {

				if (temp[0].equals(gib.getGoodsCode())) {
					gib.setGoodsName(temp[1]);
					gib.setGoodsPrice(Integer.parseInt(temp[2]));
					gib.setGoodsqty(1);
					gib.setExpireDate(temp[3]);
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println("\n [ 등록된 상품이 없습니다 상품을 먼저 등록해 주세요 ] ");
		}
	}

	public boolean stackSalesInfo(int fileIndex, ArrayList<GoodsInfoBean> goodsStack) {
		boolean result = false;
		String record;
		file = new File(filePath[fileIndex]);

		try {
			bw = new BufferedWriter(new FileWriter(file,true));

			for (GoodsInfoBean gib : goodsStack) {
				record = gib.getUniqCode() + "," + gib.getGoodsCode() + "," +
						gib.getGoodsName() + "," + gib.getGoodsPrice() + "," +
						gib.getGoodsqty() + "\n";
				bw.write(record);
				bw.flush();
			}
			bw.close();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean stackSalesInfo(int fileIndex,GoodsInfoBean gib) {
		boolean result = false;
		String record;
		file = new File(filePath[fileIndex]);

		try {
			bw = new BufferedWriter(new FileWriter(file,true));

			record = gib.getUniqCode() + "," + gib.getGoodsCode() + "," +
					gib.getGoodsName() + "," + gib.getGoodsPrice() + "," +
					gib.getGoodsqty() + "\n";
			bw.write(record);
			bw.flush();
			bw.close();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<GoodsInfoBean> getSalesList(GoodsInfoBean gib,int fileIndex) {
		ArrayList<GoodsInfoBean> salesList = new ArrayList<GoodsInfoBean>();
		String record;
		String[] temp;
		file = new File(filePath[fileIndex]);	
		String uniqCode = gib.getUniqCode();
		try {
			br = new BufferedReader(new FileReader(file));

			while((record=br.readLine())!=null) {
				temp = record.split(",");
				// 20201007132918,3001,안성탕면팩,3000,1
				if(uniqCode.equals(temp[0])) {
					gib = new GoodsInfoBean();
					gib.setGoodsCode(temp[1]);
					gib.setGoodsName(temp[2]);
					gib.setGoodsPrice(Integer.parseInt(temp[3]));
					gib.setGoodsqty(Integer.parseInt(temp[4]));

					salesList.add(gib);
				}
			}
			br.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return salesList;
	}

	public void goodsReg(int fileIndex, GoodsInfoBean gib) {
		file = new File(filePath[fileIndex]);
		String record;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			record = gib.getGoodsCode() + "," +
					gib.getGoodsName()  + "," +
					gib.getGoodsPrice()  + "," +
					gib.getExpireDate()  + "," +
					gib.getGoodsqty()  + "," +
					gib.getSafetyQty() + "\n";

			bw.write(record);
			bw.flush();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<GoodsInfoBean> goodsGetAll(int fileIndex) {

		ArrayList<GoodsInfoBean> goodsList = new ArrayList<GoodsInfoBean>();
		file = new File(filePath[fileIndex]);
		GoodsInfoBean gib;
		String temp;
		String[] record;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while((temp = br.readLine())!=null) {
				record = temp.split(",") ;
				gib = new GoodsInfoBean();

				gib.setGoodsCode(record[0]);
				gib.setGoodsName(record[1]);
				gib.setGoodsPrice(Integer.parseInt(record[2]));
				gib.setExpireDate(record[3]);
				gib.setGoodsqty(Integer.parseInt(record[4]));
				gib.setSafetyQty(record[5]);

				goodsList.add(gib);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(" [ 등록된 정보가 없습니다 상품을 먼저 등록해주세요 ]");
		}
		return goodsList;
	}

	public ArrayList<GoodsInfoBean> goodsGetHis(int fileIndex,GoodsInfoBean gib) {

		ArrayList<GoodsInfoBean> goodsList = new ArrayList<GoodsInfoBean>();
		file = new File(filePath[fileIndex]);
		String compare = gib.getUniqCode();
		String temp;
		String[] record;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			// 20201007132918,1001,새우깡,1500,1
			while((temp = br.readLine())!=null) {
				record = temp.split(",") ;
				if(record[0].substring(0,compare.length()).equals(compare)) {
					gib = new GoodsInfoBean();
					
					gib.setGoodsCode(record[1]);
					gib.setGoodsName(record[2]);
					gib.setGoodsPrice(Integer.parseInt(record[3]));
					gib.setGoodsqty(Integer.parseInt(record[4]));

					goodsList.add(gib);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(" [ 등록된 정보가 없습니다 상품을 먼저 등록해주세요 ]");
		}
		return goodsList;
	}


	public void goodsPriceMod(int fileIndex, ArrayList<GoodsInfoBean> goodsList) {

		file = new File(filePath[fileIndex]);
		String record;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < goodsList.size(); i++) {
				record = goodsList.get(i).getGoodsCode() + "," +
						goodsList.get(i).getGoodsName() + "," +
						goodsList.get(i).getGoodsPrice() + "," +
						goodsList.get(i).getExpireDate() + "," +
						goodsList.get(i).getGoodsqty() + "," +
						goodsList.get(i).getSafetyQty() + "\n";

				bw.write(record);
				bw.flush();
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}



