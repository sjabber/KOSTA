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
					System.out.println("�ȿ���");
					break;
				}
				System.out.println("�ȿ��� Ȯ��");

			case 2:
				System.out.println(c);
				break;
			}
			System.out.println("Ȯ��0");
			break;

		case 1:
			System.out.println("Ȯ��1");
			break;

		case 2:
			System.out.println("Ȯ��2");
			break;

		case 3:
			System.out.println("Ȯ��3");
			break;

		case 4:
			System.out.println("Ȯ��4");
			break;
		}

		int num_1 = 10;
		double num_2 = 10.0;
		String str = "10 string";

		sum_i(num_1); // ������ ����Ѵ�.

		sum_i(num_2); // �Ǽ��� ����Ѵ�.

		sum_i(str); // ���ڿ��� ����Ѵ�.
		
		
		
		//�ݺ��� : for�� while��
		for (int i = 1; i < 10; i++) {
			
			// ������ 2�� ���
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
