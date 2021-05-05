package week1;

import java.util.Iterator;

public class Day_04_07 {
	public static void main(String[] args) {

		int c = 0;
		int d = 3;
//      switch (c) {
//          case 5 :
//              N += 5;
//          case 6 :
//              N += 6;
//          case 7 :
//              N += 7;
//          case 8 :
//              N += 8;
//          case 9 :
//              N += 9;
//          case 10 :
//              N += 10;
//      }
//      System.out.print(N);

		switch (c) {
		case 0:
			switch (d) {
			case 3:
				if (d == 3) {
					System.out.println("안에서");
					break;
				}
				System.out.println("안에서 확인");

			case 2:
				System.out.println(c);
				break;
			}
			System.out.println("확인0");
			break;

		case 1:
			System.out.println("확인1");
			break;

		case 2:
			System.out.println("확인2");
			break;

		case 3:
			System.out.println("확인3");
			break;

		case 4:
			System.out.println("확인4");
			break;
		}

		int num_1 = 10;
		double num_2 = 10.0;
		String str = "10 string";

		sum_i(num_1); // 정수를 출력한다.

		sum_i(num_2); // 실수를 출력한다.

		sum_i(str); // 문자열을 출력한다.
		
		
		
		//반복문 : for문 while문
		for (int i = 1; i < 10; i++) {
			
			// 구구단 2단 출력
			System.out.println("2 * " + i + " = " + i*2);
		}
		
	}

	static void sum_i(int a) {
		System.out.println(a);
	}

	static void sum_i(double b) {
		System.out.println(b);
	}

	static void sum_i(String c) {
		System.out.println(c);
	}
}
