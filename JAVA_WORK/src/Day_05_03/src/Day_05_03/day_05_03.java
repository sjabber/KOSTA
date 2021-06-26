package Day_05_03.src.Day_05_03;
class test implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("test");
	}
	
}

public class day_05_03 {
	
	public static void main(String[] args) {
		
		new Runnable() {
			public void run() {
				System.out.println("Runnable");
			}
		};
		
		test t = new test();
		t.run();
	}
}
