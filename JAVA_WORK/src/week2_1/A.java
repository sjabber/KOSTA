package week2_1;

import java.util.Map;

public class A implements Comparable<A> {

    int age;
    String addr;
    String phone;
    boolean gender; // 0 ����, 1����

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
////        �̷� ������� �����ϴ� �͵� ����.
////        return (o.count -this.count);
//
//// Note
////        if (o.count < this.count) {
////            // ��������
////            // o.count �� ������, this.count �� ���� ���� ��
////            return 1; // ������ < ���ε��� �� �� ��� => ���ε��°��� �ڿ� ������ (��������)
////        } else {
////            return -1; // 0�����ϸ� �ߺ�ó���ȴ�.
////        }
//
//        if (o.str.length() < this.str.length()) {
//
//            // this�� �ٷ� ������ ���°�.
//
//            // ��������
//            // o.count �� ������, this.count �� ���� ���� ��
//            return 1; // ������ < ���ε��� �� �� ��� => ���ε��°��� �ڿ� ������ (��������)
//        } else if (o.str.length() > this.str.length()) {
//            return -1;
//        } else {
////            return 0; // 0�� ��쿣 ���� ���� �ʴ´�.
//            // ���� ���̰� ���� ��� �ڿ���� �����Ѵ�.
//            return this.str.compareTo(o.str);
//        }
////    }
//    }
}
