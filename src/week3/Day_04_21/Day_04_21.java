package week3.Day_04_21;


import java.util.ArrayList;

public class Day_04_21 {
    public static void main(String[] args) {
//        A a = new A();
//        ArrayList<A> list = new ArrayList<>();
//
//        for (int i = 0; i < a.name.length; i++) {
//            A a2 = new A(i);
//            list.add(a2);
//        }
//
//        //As as = new As("name");
//        //list�� �� �� AŬ���� ��ü.
//        // AŬ���� ��ü�� as�� ASŬ���� ��ü
//        //
//        System.out.println(list.get(0).as.getList().size());
//
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).as.getList().size(); j++) {
//                System.out.print(list.get(i).as.getList().get(j) + " ");
//            }
//            System.out.println();
//        }


        A a = new A();
        ArrayList<I> list = new ArrayList<I>();

        for (int i = 0; i < a.name.length; i++) {
            A a2 = new A(i);
            list.add(a2);
        }

        //As as = new As("name");
        // list�� �� �� AŬ���� ��ü.
        // AŬ���� ��ü�� as�� ASŬ���� ��ü

        // list.get(i) �� ���� ���� => AŬ���� ��ü
        // list.get(i).getList() => AŬ������ getList()�� ���
        // AŬ������ getList()�� as ��ü�� ���� getter�� ������ ����.

        System.out.println(list.get(0).getList().get(0));
        System.out.println(list.get(0));

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                System.out.print(list.get(i).getList().get(j) + " ");
            }
            System.out.println();
        }
    }
}
