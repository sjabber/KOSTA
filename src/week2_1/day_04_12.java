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
//		System.out.println("�迭��.");
//		System.out.println(array2[1][0]);
//		
//		// string�� ���
//		// ���빰�� ������ �Ȱ��� �ּҸ� �Ѱ��ش�.
//		// �ٸ� new �����ڸ� �̿��ϸ� �ּҰ� �޶�����. 
//		text = text_f();
//		String text2 = "helloworld";
//		
//		if (text_t() == text2) {
//			System.out.println(text);
//		} else {
//			System.out.println("�ּҰ� �ٸ���.");
//		}
//		
//		if (text2.equals("helloworld")) {
//			System.out.println("value ��");
//		}
//		
//		char c = text2.charAt(text2.length() - 1);
//		System.out.println(c); // d�� ���
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
//		System.out.println(string_text[0]); // null ���
//		System.out.println(text_int[0]); // 0 ���
//		
//		
//		String texts = "test1";
//		
//		if (texts.contains("tes")) System.out.println("��߻�");
//		if (texts.equals("tes")) System.out.println("��������");
		
//		String A;
//		String B = "A";
//		A = B; // A�� B�� �ּҸ� ����Ű���� �Ѵ�.
//		
//		if(A == B) {
//			System.out.println("����");
//		} else {
//			System.out.println("�޶�");
//		}
//		System.out.println();
//		
//		B = "B";
//		
//		System.out.println(A);
//		System.out.println();
//		if(A == B) {
//			System.out.println("����");
//		} else {
//			System.out.println("�޶�");
//		}
		
//		
//		String texts = "hello world test count";
//		String[] array_string = texts.split(" ");
//		System.out.println(array_string.length); // 4���
		
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
		System.out.println(c[0]); // a ���
		System.out.println((int) c[0]); // 97 ���
		System.out.println(c[0] + 2); // 99 ���
		System.out.println((char) (c[0] + 2)); // c ���
	}
	
	// ������ �޴´�.
	static void is_test(boolean b) {
		System.out.println("��");
		//System.out.println(b);
//		b = false;
//		System.out.println(b);
	}
	
	// ���۷����� �޴´�.
	static void is_test(boolean[] b) {
		System.out.println("���۷���");
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
