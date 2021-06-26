package week1;

public class Day_04_06 {

	public static void main(String[] args) {
//      왼쪽부터 연산을 하는데
		// 왼쪽 값이 true 이면 || 이므로 오른쪽은 가지도 않음
		// 이 경우 a()가 true 를 반환하면 b()는 사용안함.
		System.out.print((a() || b()) && c());

		// sid 객체로서 메모리의 힙 영역에 동적할당
		String sid = new String("1234");

		// abc 는 리터럴값으로 메모리의 스택 영역에 할당당
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
		System.out.println("a 입니다.");
		return true;
	}

	static boolean b() {
		System.out.println("b 입니다.");
		return false;
	}

	static boolean c() {
		System.out.println("c 입니다.");
		return true;
	}

}
