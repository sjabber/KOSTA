package week2_1;

import java.util.Map;

public class A implements Comparable<A> {

    int age;
    String addr;
    String phone;
    boolean gender; // 0 여자, 1남자

    public A() {

    }

    public A(int age, String addr, String phone, boolean gender) {
        this.age = age;
        this.addr = addr;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public int compareTo(A o) {
        if (o.age > this.age) {
            return 1;
        } else {
            return 0;
        }
    }

    //    int count;
//    String str;
//
//    public A() {
//        super();
//    }
//
//    public A(int count, String str) {
//        super();
//        this.count = count;
//        this.str = str;
//    }
//
//    @Override
//    public int compareTo(A o) {
//        return o.str.compareTo(this.str);
//    }


//    @Override
//    public int compareTo(A o) {
//        if (o.count < this.count) {
//            System.out.println("true 0 : " + this.count);
//            return 1;
//        } else if (o.count > this.count) {
//            System.out.println("true 1 : " + o.count);
//            return -1;
//        } else {
//            return 0;
//        }
//    }

//    @Override
//    public int compareTo(A o) {
//// Note
////        이런 방법으로 정렬하는 것도 있음.
////        return (o.count -this.count);
//
//// Note
////        if (o.count < this.count) {
////            // 오름차순
////            // o.count 는 기존값, this.count 는 이후 들어온 값
////            return 1; // 기존값 < 새로들어온 값 인 경우 => 새로들어온값이 뒤에 들어가도록 (오름차순)
////        } else {
////            return -1; // 0으로하면 중복처리된다.
////        }
//
//        if (o.str.length() < this.str.length()) {
//
//            // this가 바로 직전에 들어온값.
//
//            // 오름차순
//            // o.count 는 기존값, this.count 는 이후 들어온 값
//            return 1; // 기존값 < 새로들어온 값 인 경우 => 새로들어온값이 뒤에 들어가도록 (오름차순)
//        } else if (o.str.length() > this.str.length()) {
//            return -1;
//        } else {
////            return 0; // 0일 경우엔 값을 넣지 않는다.
//            // 글자 길이가 같은 경우 자연어로 정렬한다.
//            return this.str.compareTo(o.str);
//        }
////    }
//    }
}
