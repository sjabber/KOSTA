package week2_1;

public class A_04_14 {

	// 생성자
	// 별도의 생성자가 없을경우엔 디폴트 생성자를 만들어준다.

	// 디폴트 생성자
	public A_04_14() {
		System.out.println("디폴트 생성자");
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
