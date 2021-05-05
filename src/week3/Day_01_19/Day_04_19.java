package week3.Day_01_19;

import java.util.*;

public class Day_04_19 {

    static Set<String> test_set;

    // jsp => 뷰
    // 로직이 짜여진 파일은 service에 해당함.
    public static void main(String[] args) {

        HashMap<String, PhoneData> name_list = new HashMap<String, PhoneData>();
        ArrayList<PhoneData> list_array = new ArrayList<PhoneData>();
        ArrayList<String> list_string = new ArrayList<String>();

        // 주제 인물,
        // 제품 핸드폰(판매자) => 이름 주소 주민번호 번호
        // 의존 객체
        for (int i = 0; i < 5; i++) {
            PhoneData data = new PhoneData(i);
            name_list.put(data.name[i], data);
            list_array.add(data);
        }

//        System.out.println(name_list.size());
        //ArrayList<String> list_stringset = new ArrayList<String>(name_list.keySet());
        //ArrayList<String> list_stringset2 = (ArrayList<String>) name_list.keySet(); // 이건 안된다.
        Object[] list_stringset = name_list.keySet().toArray(); //
        Collection<String> coll = name_list.keySet();

        list_string.addAll(name_list.keySet()); //addAll => 배열 자체를 넣어버린다. // 안에서 형변환된다. 가장 좋은 방법
        System.out.println(list_string.size());

        for (int i = 0; i < list_string.size(); i++) {
            System.out.println(list_string.get(i));
        }

        System.out.println("*********************");

        Collections.sort(list_string); // 정렬
//        Collections.sort(list_array);

//        for (int i = 0; i < list_string.size(); i++) {
            //System.out.println(list_string.get(i));

            // 정렬된 list_string 의 값 => 곧 키이다.
            // 이를 가지고 name_list 의 값인 PhoneData 객체를 가져오고
            // 해당 객체의 의존 객체인 s의 name 값을 가져온다.
//            System.out.println(name_list.get(list_string.get(i)).s.name);
//            System.out.println(name_list.get(list_string.get(i)).s.addr);

//            System.out.println(name_list.get(list_array.get(i).s.name));
//            name_list.get(list_string.get(i));
            // 주소가 찍혔다면 객체라고 봐야한다.
//        }

        System.out.println("test2 : " + list_array.size());
        for (int i = 0; i < list_array.size(); i++) {
            //System.out.println(list_array.get(i).s.name);
            for (int j = 0; j < list_array.get(i).GetList().size(); j++) {
                if (list_array.get(i).GetList().get(j).equals("송가인")) {
                    System.out.println(list_array.get(i).GetList().get(j));
                }
            }

            System.out.println(list_array.get(i).GetList().get(i));
        }

        String temp = "원빈";
        for (int i = 0; i < list_array.size(); i++) {
            if (list_array.get(i).is_true(temp)) {
                System.out.println("해당 아이디는 이미 존재합니다.");
                return;
            }

        }


        System.out.println("---------------------------");

//        System.out.println(name_list.keySet());
//        System.out.println(list_array.size());





//        test_set = name_list.keySet();
//
//        List set = new ArrayList(test_set);




//        Collections.sort(set, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//
//                // 원래 값이 최신 값보다 길이가 짧으면
//                // 앞으로 땡기기 => 오름차순.
//                if (o1.length() < o2.length()) {
//                    return -1;
//                } else if (o1.length() > o2.length()) {
//                    return 1;
//                } else {
//                    return o1.compareTo(o2);
//                }
//            }
//        });




//        for (Object string : set) {
//            System.out.println(string);
//            System.out.println(name_list.get(string));
//        }




//        test_set = name_list.keySet();
//        for (String string : test_set) {
//            System.out.println(string);
//        }




//        Static_test test_a = new Static_test();
//        Static_test test_b = new Static_test();
//
//        System.out.println(test_a.count);
//        test_a.count = 300;
//
//        System.out.println(test_a.count);
//        System.out.println(test_b.count);
//        System.out.println(Static_test.count);
//
//        System.out.println(test_a.int_array);
//        System.out.println(test_b.int_array);
//        System.out.println(Static_test.int_array);

//        PhoneData data = new PhoneData();
//        PhoneS s = new PhoneS(data.name[0], data.addr[0], data.number[0],
//                data.phoneNum[0], data.email[0], data.service[0], data.plan[0], data.serial[0]
//        );
    }
}
