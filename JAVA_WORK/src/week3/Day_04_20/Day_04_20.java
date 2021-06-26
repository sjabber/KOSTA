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


        // 다형성 (polymorphism)
        // 인터페이스를 이해하면 추상화도 바로 이해한다.
        // 클래스는 다르나 하나의 인터페이스가 모양을 많이 가지고 있다해서 다형성이라 한다.
        // 하나의 클래스로 다른 이름의 클래스를 처리하고자 할 경우 사용, 매우 유용하다.

        // 인터페이스의 기능과 일반 클래스의 기능을 둘다 소유 => 추상화(추상클래스)

        // 넓은 의미의 다형성 => 오버로딩

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
//        // 다형성
//        list.add(a);
//        list.add(b);
//        list.add(c);
//
//        linked.add(data);
//        linked.add(movie);
//        linked.add(phone);
//
//        //다형성
//        print_test2(linked);
////        print_test2(movie);
////        print_test2(phone);
//
//        D d = new D();
//        d.test();
//        d.GetList();
//        d.list();
//
//        // 인터페이스 사용전
////        for (int i = 0; i < a.GetList().size(); i++) {
////            System.out.println(a.GetList().get(i));
////            System.out.println(b.GetList().get(i));
////        }
//
//        // 인터페이스 사용 후
//        for (int i = 0; i < list.size(); i++) {
//            //System.out.println(list.get(i).GetList().size());
//
//            for (int j = 0; j < list.get(i).GetList().size(); j++) {
//                System.out.println(list.get(i).GetList().get(j));
//            }
//            System.out.println("---------------");
//        }
//
//        // 클래스가 다를때에도 공통분모가 있다면 인터페이스를 사용한다.
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
//        System.out.println("내가 푼 풀이");
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
        // 의존객체
        // 영화정보
        // 제목 감독 장르 관객수 남성배우 여성배우 상영시간
        HashMap<String, Movie> map = new HashMap<>();
        ArrayList<Movie> list_movie = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Movie movie = new Movie(i);
            map.put(movie.s.getTitle(), movie);

            list_movie.add(movie);

            System.out.println(movie.s.getTitle());
        }

        // 이 두 방법중 하나 선택하면 됨.
        ArrayList<String> list = new ArrayList<String>(map.keySet()); // 와일드카드 적용으로 map.keySet()이 삽입가능해진다.
        //list.addAll(map.keySet());

        //Map 은 set이 아니다. 별도의 타입, Map이 set을 키값으로 가지고 있는것.
        Collections.sort(list);
        Collections.sort(list_movie); // Movie 클래스가 Comparator를 상속해서 오버라이딩을 정의해야함.

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
