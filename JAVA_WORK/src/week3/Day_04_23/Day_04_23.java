package week3.Day_04_23;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Day_04_23 {
    public static void main(String[] args) {

        String text = "";
        String url = "C:\\Users\\Taeho\\JAVA_WORK\\text\\t";

        File file = new File("C:\\Users\\Taeho\\JAVA_WORK\\text\\t.txt");
        String test = "";

        ArrayList<String> str = new ArrayList<String>();
        A a = new A();
        B b = new B();

        ArrayList<I> classes = new ArrayList<I>();

        classes.add(a);
        classes.add(b);



//        for (int i = 0; i < object.size(); i++) {
//            A a2 = new A(i);
//            for (int j = 0; j < a2.str.size(); j++) {
//                text += a2.str.get(j);
//            }
//        }


        // throw => 에러났을 때 처리해줄 준비가 되어있는지 물어보는 것.
        try {

            for (int i = 0; i < classes.size(); i++) {
                for (int j = 0; j < classes.get(i).getLenth(); j++) {
                    text += classes.get(i).getStr(j);
                }
                // 덮어 씌우기 방식
                //FileWriter writer = new FileWriter(url + i + ".txt", true);
                FileWriter writer = new FileWriter(url + i + ".txt");
                writer.write(text);
                BufferedWriter w = new BufferedWriter(writer);
                w.close();
                test = "정상적으로 처리되었습니다.";
                text = "";
            }


//            FileWriter writer = new FileWriter(file);
//            writer.write(text);
//            BufferedWriter w = new BufferedWriter(writer);
//            w.close();
//            test = "정상적으로 처리되었습니다.";


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            test =" 비정상적으로 처리되었습니다. : "  + e.getMessage();
        } finally {
            System.out.println(test);
        }
        System.out.println("도달");

    }
}
