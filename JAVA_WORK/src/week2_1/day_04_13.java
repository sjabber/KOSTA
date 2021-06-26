package week2_1;

import java.util.ArrayList;

public class day_04_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String text = "위키백과는 종이 기반 참고 자료와는 아주 다르게 실시간으로"
//				+ "위키백과는 끊임없이 만들어지고 갱신되므로 역사적 "
//				+ "사건에 관한 항목은 수분 내에 생성됩니다. 반면에 종이 기반"
//				+ "백과사전에서는 이와 같은 과정이 수개월이나 수년이 걸립니다."
//				+ "오래 전에 생성된 항목은 시간이 가면서 점점 더 일반화되고 "
//				+ "중립적 시각으로 변합니다. 새로 만들어진 항목은 잘못된 정보, "
//				+ "백과사전에 싣기에 부적절한 내용 또는 문서를 훼손하는 "
//				+ "내용을 포함할 수 있습니다. 이 점을 주의하면 유용한 정보를 취하고"   
//				+ " 잘못된 정보를 피하는 데 도움이 됩니다.";
//		
//		//System.out.println(text.length());
//		
//		int result = 0;
//		for(int i = 0; i < text.length() - 1; i++) {
//			if (text.charAt(i) == '는' || text.charAt(i) == '으') {
//				result++;
//			}
//		}
//		 
//		System.out.println(result);
//		
//		for(int i = 0; i < text.length() - 1; i++) {
//			System.out.print(text.charAt(i));
//		}

		// 제네릭(generic)에는 원시데이터를 넣어야한다.
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		ArrayList<String> str = new ArrayList<String>();
//		list.add(100);
//		list.add(200);
//		list.add(300);

//		list.remove(1); // 200 삭제
//		System.out.println(list.get(1)); // 300출력

//		str.add("가");
//		str.add("나");
//		str.add("다");

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
		// 내림차순 출력
//			System.out.println(list.get(i-1));
//			list.remove(i-1); 

		// 오름차순 출력 출력
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
