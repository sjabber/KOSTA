package week2_1;

import week2_2.TA;

import java.util.ArrayList;

public class day_04_15 extends TA {

    public static String arr;

    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        list.clear(); // list를 쓰려할때 통상적으로 클리어해주는게 관례이다. (안에 데이터가 들어있을 수 있기 때문에)
//        list.add(200);
//        list.add(200);
//        list2.add(200);
//        list2.add(300);
//        list.equals(list);
//        System.out.println(list.equals(list2)); // value 비교
//        System.out.println(list.contains(400)); // 리스트 안의 개별적인 비교를 할때 사용한다. false 반환
//        list.set(0, 400); // update 의 기능을 수행한다.
//        System.out.println(list.contains(400)); // true 반환
//        System.out.println(list.size()); // 사이즈 2 반환
//        System.out.println(list.get(0)); // 400출력
//
//
////        A_04_15 a = new A_04_15(3);
////        a.count = 0; // 멤버변수
////        a.b.number = 10; // 상속을 사용하지 않은 케이스
////        a.number = 200;
////        System.out.println("a 클래스의 맴버변수 : " + a.count);
//
//        // 스프링에선 어노테이션만으로 컨테이너 박스에 객체가 들어간다.
//        // jsp 사용하는 이유 => 어려워서 안한다. (서블릿, 스프링보다 빠르다.)
//        // jsp 를 이해하면 spring 이해가 빠르다.
//        // jsp 로 만들어진 레거시 코드들이 많으므로 현업에 갔을때 jsp를 쓸 줄 알아야한다.
//
//        A_04_15 a = new A_04_15();
//        a.num_a = 100;
////        TA ta = new TA(); // import를 통해 가져와야 한다. 패키지가 다르다면 import 사용
////        ta.num_ta = 600;
//
//        day_04_15_1 day = new day_04_15_1();
//        TA ttt = new day_04_15_1();
//
//
//        day.num_ta = 600;
////        day.num_ta2 = 700; // 접근이 안된다.
//
//        A_04_15 aa = new A_04_15();
//        Data data = new Data();
//        String[] text_data = data.text_data;
////        String[] text_data = new String[] {"unity", "홍길동", "강남구", "01012345678", "남여", "43"};
//        // 이건 일종의 DAO 이다.
//        // A_04_15 ac = new A_04_15(text_data[0], text_data[1], text_data[2], text_data[3], text_data[4], text_data[5]);
//        A_04_15 ac = new A_04_15(text_data);
//
//        System.out.println(ac.id);
//        System.out.println(ac.name);
//        System.out.println(ac.addr);
//        System.out.println(ac.phone);
//        System.out.println(ac.gender);
//        System.out.println(ac.age);
//
//        System.out.println("---------------------------------");
//        ArrayList<A_04_15> list_a = new ArrayList<>();
//
//        list_a.add(ac);
//        System.out.println(list_a.get(0).id);
//        System.out.println(list_a.get(0).name);
//        System.out.println(list_a.get(0).addr);
//        System.out.println(list_a.get(0).phone);

        // 객체 생성
        Gugudan gugudan = new Gugudan();
        //gugudan.Gugudan_method();
        //gugudan.Gugudan_method(4);

        //gugudan.Gugudan_method(2, 7);

        String str = new String();
        System.out.print(gugudan.Gugudan_method(str, 2, 7));


        //System.out.println(arr);
    }
}
