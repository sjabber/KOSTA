package week4;

class Test2 extends Thread {

    public Test2() {
        System.out.println("default");
    }

    int count;
    public Test2(int count) {
        this.count = count;
        System.out.println("custom");
    }

    @Override
    public void run() {
        try {
            System.out.println(count + "    test2 이전");
            Thread.sleep(500);

        } catch (Exception e) {

        }
        System.out.println(count + "    test2 이후");

    }
}


class Test implements Runnable {

    @Override
    public void run() {

        try {

            System.out.println("test2 이전");
            Thread.sleep(500);

        } catch (Exception e) {

        }
        System.out.println("test2 이후");

    }

}

public class Day_04_29 {
    public static void main(String[] args) {

        Thread threadA = new ThreadA();
        threadA.start();
        System.out.println("완료");

//        for (int i = 0; i < 100; i++) {
//            System.out.println("작업종료");
//        }


        //System.out.println("작업종료");

//        Test test = new Test();
//        test.run();
//
//        // 멀티스레드로 실행순서가 뒤죽박죽이 된다.
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Test2(i);
//            thread.start();
//        }
//    }
    }
}
