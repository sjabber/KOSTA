package week4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Day_04_26 {
    public static void main(String[] args) {

        int year = 0, month = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("년도 입력: ");
        year = scan.nextInt();

        System.out.println("월 입력: ");
        month = scan.nextInt();

        //출력
        String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
        System.out.println(year + "년도 " + month + "월");

        for (String week : strWeek) {
            System.out.print(week + "\t");
        }

        int total = (year - 1) * 365
                + (year - 1) / 4
                - (year - 1) / 100
                + (year - 1) / 400;

        //전달
        int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) //윤년 => 2월 29일
            lastDay[1] = 29;
        else
            lastDay[1] = 28;
        for (int i = 0; i < month - 1; i++) {
            total += lastDay[i];
        }
        //1일자의 요일
        total++;

        int week = total % 7;
        //달력 출력
        System.out.println();
        for (int i = 1; i <= lastDay[month - 1]; i++) {
            if (i == 1) {
                for (int j = 0; j < week; j++) {
                    System.out.print("\t");
                }
            }
            System.out.printf("%2d\t", i);
            week++;
            if (week > 6) {
                week = 0;
                System.out.println();
            }
        }
        Date date = new Date();
        String path = "C:\\Users\\Taeho\\JAVA_WORK\\text\\t.txt";
        File file = new File(path);

        try {
            while (true) {
                System.out.println("이전");
                //date = new Date();
                Calendar cal = Calendar.getInstance();
                String dateString = new SimpleDateFormat("yyyy-MM-dd // HH:mm:ss").format(cal.getTime());
                dateString += "\n";

                FileWriter writer = new FileWriter(file, true);
                writer.write(dateString);

                BufferedWriter bw = new BufferedWriter(writer); //wrapping
                bw.close();

                System.out.println("이후");
                System.out.println(date);
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test");

    }


//    public static boolean isNumber(String str) {
//
//
//    }

    static void calendar_test() {
        Calendar calendar = Calendar.getInstance();
        Calendar calender2 = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        // 월은 배열로 처리하기 때문에 +1 을 해줘야 지금 몇달인지 알 수 있다.
        System.out.println(calender2.get(Calendar.MONTH) + 1);
        System.out.println(calender2.get(Calendar.DATE));
        System.out.println(calender2.get(Calendar.HOUR));
        System.out.println(calender2.get(Calendar.MINUTE));
        System.out.println(calender2.get(Calendar.SECOND));

        Date date = new Date();
        System.out.println(date);

        // 내가 이렇게 날짜를 지정해줄 수도 있다.
        calendar.set(2021, 4, 1);

        // mm => 분, MM => 월  대소문자 구분 잘하도록.
        String format = "yyy / MM / dd // HH:mm:ss";

        SimpleDateFormat s = new SimpleDateFormat(format);
        String datedata = s.format(calendar.getTime());
        System.out.println(datedata);
    }

    static void file_stream() {
        String text = "helloworld!!";
        String path = "C:\\Users\\Taeho\\JAVA_WORK\\text\\t.txt";
        File file = new File(path);

        try {
            FileOutputStream output = new FileOutputStream(file);
            byte[] b = text.getBytes();
            output.write(b);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            FileInputStream input = new FileInputStream(file);

//            System.out.println(input.available());
//            System.out.println((char) input.read());
//            System.out.println(input.available());
            int n = 0;
            // available => 전체글자수
            // read => 잘라내기
            while ((n = input.available()) > 0) {
                byte[] b = input.readAllBytes();
                // InputStream 으로부터 남아있는 모든 바이트들을 읽어들인다.

                for (int i = 0; i < b.length; i++) {
                    System.out.println((char) b[i]);
                }

                System.out.println((char) input.read());
                // 읽은 내용을 다시 다른파일로 저장.
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(); // 오류를 출력한다.
        }

        System.out.println("도달");
    }

    static void file_test() {
        String text = "helloworld";
        String path = "C:\\Users\\Taeho\\JAVA_WORK\\text";
        File file = new File(path);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            BufferedWriter bw = new BufferedWriter(writer); //wrapping
            bw.close();

            System.out.println("test");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            FileReader reader = new FileReader(file);
            BufferedReader r = new BufferedReader(reader);
            System.out.println(r.read());
            System.out.println(r.readLine());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
