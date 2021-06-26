package week4;

import java.io.*;
import java.util.ArrayList;

public class Day_04_28 {
    public static void main(String[] args) throws InterruptedException, IOException {

        ArrayList<String> calender = new ArrayList<String>();

        Calendar car = new Calendar();

        String path = "C:\\Users\\Taeho\\JAVA_WORK\\text\\calendar.txt";
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader r = new BufferedReader(reader);

        int num = 2020;
        int count = 0;
        String str = "";
        String str_0 = "";
        String s_str = "\t===================================================";

        try {
            for (int i = 0; i < 10; i++) {

                while(true) {
                    str_0 = r.readLine();
                    if(str_0.equals(s_str)) {
                        count++;
                    }
                    str += str_0;
                    str += "\n";

                    if (count >= 24) {
                        for (int j = 0; j < 6; j++) {
                            str += r.readLine();
                            str += "\n";
                        }
                        count = 0;
                        break;
                    }
                }

                String path2 = "C:\\Users\\Taeho\\JAVA_WORK\\text\\calendar" + (num + i) + ".txt";
                File file2 = new File(path2);
                FileWriter writer = new FileWriter(file2);
                writer.write(str);
                BufferedWriter bw = new BufferedWriter(writer); //wrapping
                bw.close();

                str = "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        String str = "";
//        try {
//            for (int i = 0; i < 10; i++) {
//                for (int j = 1; j < 13; j++) {
//                    str += car.printCalender2(2020 + i, j);
//                }
//
//            }
//
//            String path = "C:\\Users\\Taeho\\JAVA_WORK\\text\\calendar.txt";
//            File file = new File(path);
//            FileWriter writer = new FileWriter(file);
//            writer.write(str);
//            BufferedWriter bw = new BufferedWriter(writer); //wrapping
//            bw.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



//        System.out.println(calender.size());
//        System.out.println();
//        int year = 2020;
//        for (int i = 0; i < calender.size(); i++) {
//        String path = "C:\\Users\\Taeho\\JAVA_WORK\\text\\" + (2020 + i) + ".txt";
//        File file = new File(path);
//        FileWriter writer = new FileWriter(file);
//        writer.write(calender.get(i));
//        BufferedWriter bw = new BufferedWriter(writer); //wrapping
//        bw.close();
//        }
    }
}
