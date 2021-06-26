package week1;

public class Day_04_09 {
	
	public static void main(String[] args) {
		
		int a = 3;
		int b = 6;
		int c = 11;
		int d = 100;
		int e = 2;
		int f = 300;
		
		int[] array_int = {a, b, c, d, e, f};
		
		for (int i = 0; i < array_int.length; i++) {
			for (int j = i+1; j < array_int.length; j++) {
				if(array_int[i] >= array_int[j]) {
					
					int temp = array_int[i];
					array_int[i] = array_int[j];
					array_int[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < array_int.length; i++) {
			System.out.println(array_int[i]);
		}
		
	}
}
