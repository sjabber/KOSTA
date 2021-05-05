package week1;

public class select_sort {
	
	public static void main(String[] args) {
		
	
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	static void sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) { // 부등호 방향에 따라 오름차순인지 내림차순인지 달라진다.
					index = j; // 작은 수가 담긴 인덱스가 저장된다.
				}
			}
			
			int tmp = arr[i];
			arr[i] = arr[index]; // arr[index]는 가장 작은 값이 됨.
			arr[index] = tmp;
		}
	}
}
