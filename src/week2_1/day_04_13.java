package week2_1;

import java.util.ArrayList;

public class day_04_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String text = "��Ű����� ���� ��� ���� �ڷ�ʹ� ���� �ٸ��� �ǽð�����"
//				+ "��Ű����� ���Ӿ��� ��������� ���ŵǹǷ� ������ "
//				+ "��ǿ� ���� �׸��� ���� ���� �����˴ϴ�. �ݸ鿡 ���� ���"
//				+ "������������� �̿� ���� ������ �������̳� ������ �ɸ��ϴ�."
//				+ "���� ���� ������ �׸��� �ð��� ���鼭 ���� �� �Ϲ�ȭ�ǰ� "
//				+ "�߸��� �ð����� ���մϴ�. ���� ������� �׸��� �߸��� ����, "
//				+ "��������� �Ʊ⿡ �������� ���� �Ǵ� ������ �Ѽ��ϴ� "
//				+ "������ ������ �� �ֽ��ϴ�. �� ���� �����ϸ� ������ ������ ���ϰ�"   
//				+ " �߸��� ������ ���ϴ� �� ������ �˴ϴ�.";
//		
//		//System.out.println(text.length());
//		
//		int result = 0;
//		for(int i = 0; i < text.length() - 1; i++) {
//			if (text.charAt(i) == '��' || text.charAt(i) == '��') {
//				result++;
//			}
//		}
//		 
//		System.out.println(result);
//		
//		for(int i = 0; i < text.length() - 1; i++) {
//			System.out.print(text.charAt(i));
//		}

		// ���׸�(generic)���� ���õ����͸� �־���Ѵ�.
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		ArrayList<String> str = new ArrayList<String>();
//		list.add(100);
//		list.add(200);
//		list.add(300);

//		list.remove(1); // 200 ����
//		System.out.println(list.get(1)); // 300���

//		str.add("��");
//		str.add("��");
//		str.add("��");

//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

//		for (int i = 0; i < str.size(); i++) {
//			System.out.println(str.get(i));			
//		}

//		for (int i = 0; i < 100; i++) {
//			list.add(10*(i+1)); // 10, 20, 30, ... 1000
//		}

//		for (int i = 0; i < 100; i++) {
//			System.out.println(list.get(i));
//		}
//		
//		for (int i = list.size(); i > 0; i--) {
		// �������� ���
//			System.out.println(list.get(i-1));
//			list.remove(i-1); 

		// �������� ��� ���
//			System.out.println(list.get(0));
//			list.remove(0);

		ArrayList<int[]> list_array = new ArrayList<int[]>();
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;

		list_array.add(arr);
		System.out.println(list_array.get(0)[2]);
		
		for (int j = 0; j < 3; j++) {
			int[] arr2 = list_array.get(0);
			System.out.println(arr2[j]);
		}
		
	}

	static int test(int c) {
		System.out.println(c);
		if (c == 0)
			return 0;
		else
			return test(--c);
	}

}
