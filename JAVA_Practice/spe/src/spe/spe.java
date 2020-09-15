package spe;

public class spe {
	
	public static void main(String[] args) {
		
		//특수문자 서식
		
		/*
		 * 이거는 이렇게 해야
		 * 여러줄 가능
		 */
		
		//순서 대로 탭, 엔터, 작은따운표, 큰따움표, 역슬래쉬임                           ln메소드는 그냥 엔터처리됨
		System.out.println("good\tmorning");
		System.out.println("good\n\nmorning");
		System.out.println("good \'morning\'");
		System.out.println("\"good\" morning");
		System.out.println("\\\\good \\morning");
		
		/*다음은 일반문자가 아닌 서식문자에 대해 알아보겠음
		 * printf("안에") f=format 임                                                           F매소드는 /n을 안해주면 엔터 처리 안해줌
		 * %d 10진수 %o 8진수 %x 16진수 %c 문자 %s 문자열 %f 실수 
		 */
		
		// 이거 게임 대사만들때 케릭터 이름으로 하면 좋을듯함
		
		//숫자 10진수
		System.out.printf("오늘의 온도는 %d도 입니다.\n",27);
		int num;
		num = 30;
		System.out.printf("오늘의 온도는 %d도 입니다.\n",num);
		//문자
		char ch;
		ch = 'A';
		System.out.printf("오늘 학점은 \'%c\' 받음..\n",ch);
		//문자열
		String str = "뭐로하지";
		System.out.printf("오늘 저녁은 %s 흠..\n",str);
		
		//실수
		float fl = 1.22f;
		double dou = 1.440003d;
		System.out.printf("지금 실수는 %f 와 %f 입니다.\n",fl,dou);
		
		//정열하기 10짜리 로 칸을 만듬 오른쪽 가운데 정열가능, 소수점 제한도 가능
		System.out.printf("%10f\n",dou);
		System.out.printf("%.2f\n",dou);
	
		//산술 연산을 해보자 +,-,*,/,%(나머지)
		int x = 37;
		int y = 5;
		
		System.out.println("37 과 5 의 합은 " +(x+y) +"이고 나눈 값의 몫은 " +(x/y) +"이고 나머지는" +(x%y) +" 입니다.");
		//이항연산 <,>,<=,>=,!=(같지않다),==(같다) 는 비교 값에 따라 ture or false 로 값이나온다 
		System.out.println("x 와 y의 숫자는 같지 않아요 하지만 != 에서는 " +(x!=y) +" 랍니다?");
		
		int xx = 10;
		System.out.println("x ++은 = 37 ->"+ ++x); // x+1과 같음 --x 는 x-1과 같음
		System.out.println("x =" + x++); // 1은 더했지만 결과는 그대고 메모리상에는 1이 더해짐 다음번에는 더해진 값이 나옴
		System.out.println("x =" + x); //더한값 추출을 위해
	
		//논리 연산 && || ! 순서대로 AND OR NOT이됨
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println("b1 b2 모두 참이면 참 하지만 다르므로" +(b1&&b2));
		System.out.println("b1 b2 둘중에 하나라도 참이면 " +(b1||b2));
		System.out.println("b1 부정 b2 부정 시킴\t" +!b1 +"\t" +!b2); //부정의 부정은 참 트루라 트루됨 !b2 부정의 부정임 그럼 트루
		
		//삼항 연산 조건식 ? 식1 : 식2 트루면 식1 거짓이면 식2 계산
		x=10;
		y=20;
		int result = 0;
		result = (x > y) ? 100 : 200;
		System.out.println("result = " +result); //x가 y보다 크면 100을출력
		result = (x < y) ? 100 : 200;
		System.out.println("result = " +result);
		
		/* 중요!!!! 배열!
		 * 배열의 기호는 []이가 정수형 int [] arr1 = new int[5]
		 * 라고 하면    정수형 데이터 배열 arr1 생성 = 새로운 정수형 5개이다 0~4
		 */
		int [] arr1 = new int[3];
		arr1[0] = 100;
		arr1[1] = 200;
		arr1[2] = 300;
		
		System.out.println(arr1[0] +"\t" +arr1[1] +"\t" +arr1[2] +"\t");
		
		//하지만 너무 식이 길어지므로 한방에 만드는 방법이 있다.
		int[] arr2 = {10, 20, 30};
		System.out.println(arr2[0] +"\t" + arr2[1] +"\t" + arr2[2]);
		 
		
	}
}
