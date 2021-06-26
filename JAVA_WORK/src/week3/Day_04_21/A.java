package week3.Day_04_21;

public class A extends As {

    As as = new As();

    public static int num = 0;

    String[] name = {"홍길동", "신사임당", "성삼문"};
    int[] age = {62, 18, 40};
    String[] addr = {"서울시 강남구", "서울시 강서구", "서울시 강동구"};
    String[] phone = {"010-3319-1234", "010-3319-1235", "010-3319-1236"};
    String[] gender = {"남", "여", "남"};

    // Override 는 퍼블릭이 되어야함.

    public A() {

    }


    public A(int i) {
        setName(name[i]);
        setAge(age[i]);
        setAddr(addr[i]);
        setPhone(phone[i]);
        setGender(gender[i]);

        //System.out.println(as.getName());

//        ArrayList a = as.getList(as);
//        for(int j = 0; j < a.size(); j++) {
//            System.out.print(a.get(j) + " ");
//        }
//        System.out.println();
    }

//    @Override
//    public ArrayList<String> getList() {
//        ArrayList<String> list = new ArrayList<>();
//        list.add(as.getName());
//        list.add(String.valueOf(as.getAge()));
//        list.add(as.getAddr());
//        list.add(as.getPhone());
//        list.add(as.getGender());
//        return list;
//    }
}
