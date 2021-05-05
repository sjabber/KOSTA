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
				if (arr[index] > arr[j]) { // �ε�ȣ ���⿡ ���� ������������ ������������ �޶�����.
					index = j; // ���� ���� ��� �ε����� ����ȴ�.
				}
			}
			
			int tmp = arr[i];
			arr[i] = arr[index]; // arr[index]�� ���� ���� ���� ��.
			arr[index] = tmp;
		}
	}
}
