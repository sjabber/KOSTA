package week2_1;

public class A_04_14 {

	// ������
	// ������ �����ڰ� ������쿣 ����Ʈ �����ڸ� ������ش�.

	// ����Ʈ ������
	public A_04_14() {
		System.out.println("����Ʈ ������");
	}

	public A_04_14(String n) {
		System.out.println(n);
	}

	public A_04_14(int n) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(n + "*" + i + " = " + i*n);
		}
	}

}
