package week1;

public class Day_04_06 {

	public static void main(String[] args) {
//      ���ʺ��� ������ �ϴµ�
		// ���� ���� true �̸� || �̹Ƿ� �������� ������ ����
		// �� ��� a()�� true �� ��ȯ�ϸ� b()�� ������.
		System.out.print((a() || b()) && c());

		// sid ��ü�μ� �޸��� �� ������ �����Ҵ�
		String sid = new String("1234");

		// abc �� ���ͷ������� �޸��� ���� ������ �Ҵ��
		String abc = "1234";

		if (sid == "1234") {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}

		if (abc == "1234") {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}

	static boolean a() {
		System.out.println("a �Դϴ�.");
		return true;
	}

	static boolean b() {
		System.out.println("b �Դϴ�.");
		return false;
	}

	static boolean c() {
		System.out.println("c �Դϴ�.");
		return true;
	}

}
