package week3.Day_04_22;

import java.util.ArrayList;

public class Day_04_22 {
    public static void main(String[] args) {

        ArrayList<I> list = new ArrayList<>();
        ArrayList<ArrayList<I>> list2 = new ArrayList<>();

        A a = new A();
        B b = new B();
        C c = new C();

        list.add(a);
        list.add(b);
        list.add(c);
        //list2.add(list);

        for (int i = 0; i < list.size(); i++) {

            ArrayList<I> list_a = new ArrayList<I>();

            for (int j = 0; j < list.get(i).getLength(); j++) {
                if (i == 0) {
                    I a2 = new A(j);
                    list_a.add(a2);
                } else if (i == 1) {
                    I b2 = new B(j);
                    list_a.add(b2);
                } else if (i == 2) {
                    I c2 = new C(j);
                    list_a.add(c2);
                }

            }
            list2.add(list_a);
        }

        // list2.get(0) => ArrayList<I>
        // list2.get(0).get(0) => I a
        // list2.get(0).get(0).getList() => ArrayList<String>
        //
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list2.get(i).size(); j++) {
                for (int k = 0; k < list2.get(i).get(j).getList().size(); k++) {
                    System.out.print(list2.get(i).get(j).getList().get(k) + " ");
                }
                System.out.println();
            }
        }
//        System.out.println(list2.get(0).get(0).getList());
//        System.out.println(list2.get(1).get(0).getList());
//        System.out.println(list2.get(2).get(0).getList());


//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).getList().size(); j++) {
//                System.out.print(list.get(i).getList().get(j) + " ");
//            }
//            System.out.println();
//        }


    }
}
