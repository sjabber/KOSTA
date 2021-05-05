package week4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ThreadA extends Thread {

    public ThreadA() {
        Calendar car = new Calendar();

        try {
            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < 13; j++) {
                    car.printCalender(2020 + i, j);
                }
                car.test = "";
                String path = "C:\\Users\\Taeho\\JAVA_WORK\\text\\" + (2020 + i) + ".txt";
                File file = new File(path);
                FileWriter writer = new FileWriter(file);
                writer.write(car.test);
                BufferedWriter bw = new BufferedWriter(writer); //wrapping
                bw.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int c;
    public ThreadA(int c) {
        this.c = c;
    }

    @Override
    public void run() {
        String text = "helloworld";
        File file1 = new File("C:\\Users\\Taeho\\JAVA_WORK\\text\\t.txt");
        File file2 = new File("C:\\Users\\Taeho\\JAVA_WORK\\text2");

        try {
            if (file2.exists()) {
                System.out.println("폴더 있음");
            } else {
                System.out.println("폴더 없음");
                file2.mkdir();
            }

            Calendar car = new Calendar();

            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < 13; j++) {
                    car.printCalender(2020 + i, j);
                }

                String path = "C:\\Users\\Taeho\\JAVA_WORK\\text2\\" + (2020 + i) + ".txt";
                File file = new File(path);
                FileWriter writer = new FileWriter(file);
                writer.write(car.test);
                BufferedWriter bw = new BufferedWriter(writer); //wrapping
                bw.close();
                car.test = "";
            }

//            while(true) {
//                System.out.println(c + "    출력 이전");
//                Thread.sleep(500);
//                c++;
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(c + "    출력이후");
    }
}
