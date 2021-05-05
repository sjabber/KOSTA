package week2_1;

public class day_04_12 {

	static String text;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] array = new int[3];
//		array[0] = 100;
//		array[1] = 200;
//		array[2] = 300;
//		
//		int[][] array2 = new int[3][];
//		
//		array2[0] = new int[3];
//		array2[1] = new int[3];
//		array2[2] = new int[3];
//		
//		array2[0][0] = 100;
//		array2[0][1] = 100;
//		array2[0][2] = 100;
//		
//		System.out.println("배열임.");
//		System.out.println(array2[1][0]);
//		
//		// string의 경우
//		// 내용물이 같으면 똑같은 주소를 넘겨준다.
//		// 다만 new 연산자를 이용하면 주소가 달라진다. 
//		text = text_f();
//		String text2 = "helloworld";
//		
//		if (text_t() == text2) {
//			System.out.println(text);
//		} else {
//			System.out.println("주소가 다르다.");
//		}
//		
//		if (text2.equals("helloworld")) {
//			System.out.println("value 비교");
//		}
//		
//		char c = text2.charAt(text2.length() - 1);
//		System.out.println(c); // d를 출력
//	
//		
//		String[] string_text = new String[3];
//		int[] text_int = new int[3];
//		string_text[0] = "hello";
//		
//		String n = string_text[0];
//		string_text[0] = "world";
//		if(n == string_text[0]) {
//			 
//		}
//		
//		System.out.println(string_text[0]); // null 출력
//		System.out.println(text_int[0]); // 0 출력
//		
//		
//		String texts = "test1";
//		
//		if (texts.contains("tes")) System.out.println("루삐뽕");
//		if (texts.equals("tes")) System.out.println("빵구빵구");
		
//		String A;
//		String B = "A";
//		A = B; // A에 B의 주소를 가리키도록 한다.
//		
//		if(A == B) {
//			System.out.println("같아");
//		} else {
//			System.out.println("달라");
//		}
//		System.out.println();
//		
//		B = "B";
//		
//		System.out.println(A);
//		System.out.println();
//		if(A == B) {
//			System.out.println("같아");
//		} else {
//			System.out.println("달라");
//		}
		
//		
//		String texts = "hello world test count";
//		String[] array_string = texts.split(" ");
//		System.out.println(array_string.length); // 4출력
		
//		boolean[] is_b = new boolean[2];
//		boolean[][] is_b2 = new boolean[2][];
//		
//		is_test(is_b[0]);
//		is_test(is_b);
//		
//		System.out.println(is_b2[0]);
//		System.out.println(is_b2[0][0]);
//		
//		String text = "hello; world;te;countss";
//		String[] sp = text.split(";");
//		char[][] css = new char[sp.length][];
//		for (int i = 0; i < sp.length; i++) {
//			
//			css[i] = new char[sp[i].length()];
//			System.out.println(css[i].length);
//			
//			for(int j = 0; j < css[i].length; j++) {
//				css[i][j] = sp[i].charAt(j);
//			}
//		}
//		System.out.println(is_b);
		
		String text = "helloworld!"; 
		char[] c = new char[text.length()];
		System.out.println(c.length);
		c[0] = 'a';
		System.out.println(c[0]); // a 출력
		System.out.println((int) c[0]); // 97 출력
		System.out.println(c[0] + 2); // 99 출력
		System.out.println((char) (c[0] + 2)); // c 출력
	}
	
	// 값으로 받는다.
	static void is_test(boolean b) {
		System.out.println("값");
		//System.out.println(b);
//		b = false;
//		System.out.println(b);
	}
	
	// 레퍼런스로 받는다.
	static void is_test(boolean[] b) {
		System.out.println("레퍼런스");
		boolean nb = true;
		b[0] = nb;
	}
	
	static String text_f() {
		return "helloworld";
	}
	
	static String text_f2() {
		return new String("helloworld");
	}
	
	static String text_t() {
		return text;
	}

}
