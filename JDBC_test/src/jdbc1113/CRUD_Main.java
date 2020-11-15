package jdbc1113;

import java.util.Scanner;


public class CRUD_Main {
	public static void main(String[] args) {

		// SQL문을 실행하기위한 crud객체 선언
		CRUD_SQL crud = new CRUD_SQL();

		// 학생 정보를 담아오는 stu 객체선언
		CRUD_DTO stu = new CRUD_DTO();

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int menu = 0;


		while(run) {
			System.out.println(" ========================= ");
			System.out.println(" 1.DB접속      2.DB해제");
			System.out.println(" 3.학생등록    4.학생조회");
			System.out.println(" 5.데이터수정  6.학생삭제");
			System.out.println(" 0.종료");
			System.out.println(" ========================= ");
			System.out.print(" 메뉴를 선택해 주세요 :  ");
			menu = sc.nextInt();
			if (menu==0) {
				System.out.println(" 이용해주셔서 감사합니다.");
				break;
			}


			switch (menu) {
			case 1:
				crud.connect();
				break;
			case 2:
				crud.conClose();
				break;
			case 3:
				System.out.println(" 학생정보를 입력해 주세요");
				System.out.print(" 이름 : ");
				stu.setStuName(sc.next());
				System.out.print(" 나이 : ");
				stu.setStuAge(sc.nextInt());
				
				crud.stuIns(stu);
				break;
			case 4:
				System.out.println(" 이름을 입력해주세요");
				System.out.print(" 이름 : ");
				stu.setStuName(sc.next());
				
				crud.stuInfo(stu);
				
				if(stu.getStuAge()==0) {
				System.out.println(" 등록된 학생이 없습니다.");
				}else {
				System.out.println(" 이름 : " + stu.getStuName());
				System.out.println(" 나이 : "+stu.getStuAge());
				}
				break;
			case 5:
				System.out.print(" 이름을 입력해주세요 :");
				stu.setStuName(sc.next());
				System.out.print(" 수정할 나이를 입력해주세요 :");
				stu.setStuAge(sc.nextInt());
				crud.modInfo(stu);

				System.out.println(" 수정된 이름 : " + stu.getStuName());
				System.out.println(" 수정된 나이 : "+stu.getStuAge());
				
				break;
			case 6:
				System.out.println(" 삭제할 이름 : " + stu.getStuName());
				stu.setStuName(sc.next());
				crud.delstu(stu);
				break;
			case 7:

				break;

			default:
				System.out.println("입력을 잘못하셨습니다.");
				break;
			}
		};

	}
}
