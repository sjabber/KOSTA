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
            System.out.println(count + "    test2 ����");
            Thread.sleep(500);

        } catch (Exception e) {

        }
        System.out.println(count + "    test2 ����");

    }
}


class Test implements Runnable {

    @Override
    public void run() {

        try {

            System.out.println("test2 ����");
            Thread.sleep(500);

        } catch (Exception e) {

        }
        System.out.println("test2 ����");

    }

}

public class Day_04_29 {
    public static void main(String[] args) {

        Thread threadA = new ThreadA();
        threadA.start();
        System.out.println("�Ϸ�");

//        for (int i = 0; i < 100; i++) {
//            System.out.println("�۾�����");
//        }


        //System.out.println("�۾�����");

//        Test test = new Test();
//        test.run();
//
//        // ��Ƽ������� ��������� ���׹����� �ȴ�.
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Test2(i);
//            thread.start();
//        }
//    }
    }
}
