package week1;

import java.util.Scanner;

public class Day_04_08 {
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			
//			System.out.println("���ڸ� �Է��ϼ���. ");
//			int c = sc.nextInt();
//			
//			System.out.println(c);
//			if(c == -100) {
//				break;
//			}
//			gugudan2(c);
//		}
		
		
//		int N = sc.nextInt();
//		
//		System.out.println(N);
//		
//		sc.close();
		
		//gugudan2(19);
		
		System.out.println("�ڳ� ����������ǰ�?");
		System.out.println("�� : 1, �ƴϿ� : 2");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) {
			do {
				System.out.println("���ö� ����������� ���ö� �ƴ϶���.");
			} while(true);
		} else {
			do {
				System.out.println("�ڳ� ���� ����.");
			} while(false);
		}
		
		
	}
	
	static void gugudan2(int m) {
		
		if (m < 10) {
			m = 10;
		} else if (m > 21) {
			m = 20;
		}
		
//		m = 10;
		System.out.println(m);
		
		//String name = "helloworld";
		//System.out.println(name.length());
		int max = m;
		
//		for	(int i = 2; i <= max; i++) {
//			gugudan(i);
//		}
		
		for (int i = 2; i < max; i++) {
			gugudan_0(i);
			System.out.println("------------");
		}
		
		
		//gugudan_0(max);
		
	}
	
	static void gugudan(int i) {
		for (int j = 1; j < 10; j++) {
			System.out.print(i + " * " + j + " = " + i*j + "\t");
		}
		System.out.println("------------");
	}
	
	static void gugudan_0 (int i) {
		
		for (int j = 1; j < 10 || j < i; j++) {
			System.out.print((i) + "*" + j + "=" + (i)*j+"\t" );			
		}
	}
}
