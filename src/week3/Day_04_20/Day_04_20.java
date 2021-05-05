package week3.Day_04_20;

import java.util.*;

public class Day_04_20 {

    public static void main(String[] args) {

        ArrayList<I> list = new ArrayList<I>();
        LinkedList<I> Linkedlist = new LinkedList<>();

        ArrayList<ArrayList> list2 = new ArrayList<>();

        A a = new A();
        B b = new B();
        C c = new C();

        for (int i = 0; i < c.title.length; i++) {
            list2.add(c.GetTuple(i));
            for (int j = 0; j < list2.get(i).size(); j++) {
                System.out.print(list2.get(i).get(j) + " ");
            }
            System.out.println();
        }


        list.add(a);
        list.add(b);
        list.add(c);

        print_test(a);
        System.out.println("----");
        print_test(b);
        System.out.println("----");
        print_test(c);


        // ������ (polymorphism)
        // �������̽��� �����ϸ� �߻�ȭ�� �ٷ� �����Ѵ�.
        // Ŭ������ �ٸ��� �ϳ��� �������̽��� ����� ���� ������ �ִ��ؼ� �������̶� �Ѵ�.
        // �ϳ��� Ŭ������ �ٸ� �̸��� Ŭ������ ó���ϰ��� �� ��� ���, �ſ� �����ϴ�.

        // �������̽��� ��ɰ� �Ϲ� Ŭ������ ����� �Ѵ� ���� => �߻�ȭ(�߻�Ŭ����)

        // ���� �ǹ��� ������ => �����ε�

//        ArrayList<I> list = new ArrayList<I>();
//        LinkedList<I> linked = new LinkedList<>();
//
//
//        Data_in data = new Data_in();
//        Movie movie = new Movie();
//        PhoneData phone = new PhoneData();
//
//
//        A a = new A();
//        B b = new B();
//        C c = new C();
//
//        // ������
//        list.add(a);
//        list.add(b);
//        list.add(c);
//
//        linked.add(data);
//        linked.add(movie);
//        linked.add(phone);
//
//        //������
//        print_test2(linked);
////        print_test2(movie);
////        print_test2(phone);
//
//        D d = new D();
//        d.test();
//        d.GetList();
//        d.list();
//
//        // �������̽� �����
////        for (int i = 0; i < a.GetList().size(); i++) {
////            System.out.println(a.GetList().get(i));
////            System.out.println(b.GetList().get(i));
////        }
//
//        // �������̽� ��� ��
//        for (int i = 0; i < list.size(); i++) {
//            //System.out.println(list.get(i).GetList().size());
//
//            for (int j = 0; j < list.get(i).GetList().size(); j++) {
//                System.out.println(list.get(i).GetList().get(j));
//            }
//            System.out.println("---------------");
//        }
//
//        // Ŭ������ �ٸ������� ����и� �ִٸ� �������̽��� ����Ѵ�.
////        System.out.println(a.GetList().size());
////        System.out.println(b.GetList().size());
//
////        System.out.println(a.GetList().get(0));
////        System.out.println(b.GetList().get(0));
//
//        print_test(a);
//        print_test(b);
//        print_test(c);
////        a.test();
////        b.test();
//
//        ArrayList<key> keys = new ArrayList<>();
//        Movie movie2 = new Movie();
//        PhoneData phoneData = new PhoneData();
//
//        keys.add(movie2);
//        keys.add(phoneData);
//
//        System.out.println( );
//        System.out.println("���� Ǭ Ǯ��");
//        System.out.println("-----------------------------");
//
//        for (int i = 0; i < keys.size(); i++) {
//            for (int j = 0; j < keys.get(i).print_key().length; j++) {
//                System.out.print(keys.get(i).print_key()[j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("-----------------------------");

    }


    static void print_test(I a) {

        for (int i = 0; i < a.GetList().size(); i++) {
            System.out.println(a.GetList().get(i));
        }

        a.GetList().size();

    }

    static void print_test2(List<I> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).GetList().size());
            for (int j = 0; j < list.get(i).GetList().size(); j++) {
                System.out.println(list.get(i).GetList().size());
            }
        }
    }

    static void map_test() {
        // ������ü
        // ��ȭ����
        // ���� ���� �帣 ������ ������� ������� �󿵽ð�
        HashMap<String, Movie> map = new HashMap<>();
        ArrayList<Movie> list_movie = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Movie movie = new Movie(i);
            map.put(movie.s.getTitle(), movie);

            list_movie.add(movie);

            System.out.println(movie.s.getTitle());
        }

        // �� �� ����� �ϳ� �����ϸ� ��.
        ArrayList<String> list = new ArrayList<String>(map.keySet()); // ���ϵ�ī�� �������� map.keySet()�� ���԰���������.
        //list.addAll(map.keySet());

        //Map �� set�� �ƴϴ�. ������ Ÿ��, Map�� set�� Ű������ ������ �ִ°�.
        Collections.sort(list);
        Collections.sort(list_movie); // Movie Ŭ������ Comparator�� ����ؼ� �������̵��� �����ؾ���.

        System.out.println(map.size());
        for (String string : map.keySet()) {
            System.out.println(string);
        }

        System.out.println("--------------------------");
        for (int i = 0; i < list_movie.size(); i++) {
            System.out.println(list_movie.get(i).s.getTitle());
        }
    }
}
