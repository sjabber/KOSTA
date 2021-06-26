package week4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ThreadT extends Thread {

    @Override
    public void run() {

        String text = "hello world!";
        System.out.println("ThreadT 이전출력");
        String path = "C:\\Users\\Taeho\\JAVA_WORK\\Image\\t.txt";
        String path2;

        File file = null;
        FileWriter writer = null;
        BufferedWriter w = null;
        for (int i = 0; i < 10; i++) {
            try {
                path2 = ".\\Image_" + i;
                file = new File(path2);
                System.out.println(file.exists());
                if (file.exists()) {

                } else {
                    file.mkdir();
                }
                path2 = ".\\Image_" + i + "\\t.txt";
                file = new File(path2);
                writer = new FileWriter(file);
                writer.write(text);
                w = new BufferedWriter(writer);
                w.close();
                Thread.sleep(10);
                System.out.println(i);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("ThreadT 이후출력");
    }
}
