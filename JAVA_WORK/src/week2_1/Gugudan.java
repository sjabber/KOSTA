package week2_1;

import java.util.ArrayList;

import static week2_1.day_04_15.arr;

public class Gugudan {

    ArrayList<Gugudan_inner> list = new ArrayList<Gugudan_inner>();

    public Gugudan() {
    }

    public void Gugudan_method() {
        System.out.println("Gugudan 생성자 입니다.");
        for (int i = 2; i < 10; i++) {
//            System.out.println("2 * " + i + "=" + i * 2);
            Gugudan_inner gugudan = new Gugudan_inner(i);
            list.add(gugudan);
            System.out.println("-----------------");
            arr += "----------------- \n";
        }
        System.out.println(list.size()); // length와 size를 찍어보는걸 생활화하자.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void Gugudan_method(int n) {
        System.out.println("Gugudan 생성자 입니다.");
        for (int i = 2; i <= n; i++) {
//            System.out.println("2 * " + i + "=" + i * 2);
            Gugudan_inner gugudan = new Gugudan_inner(i);
            System.out.println("-----------------");
            arr += "----------------- \n";
        }
    }

//    public void Gugudan_method(int n, int m) {
//        System.out.println("Gugudan 생성자 입니다.");
//        for (int i = n; i <= m; i++) {
////            System.out.println("2 * " + i + "=" + i * 2);
//            Gugudan_inner gugudan = new Gugudan_inner(i);
//
//            System.out.println("-----------------");
//            arr += "----------------- \n";
//        }
//    }


    public String Gugudan_method(String str, int n, int m) {

        String str2 = new String();
        Gugudan_inner gugudan = new Gugudan_inner();

        for (int i = n; i <= m; i++) {
            str = gugudan.Gugudan_inner(str, i);
            str2 += str;
            str = "";
        }

        return str2;
    }
}