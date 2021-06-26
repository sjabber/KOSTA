package week3.Day_04_21;

import week2_1.A;

import java.util.ArrayList;

public class As implements I {
    A a = null;
    String name;
    int age;
    String addr;
    String phone;
    String gender;

    public As() {

    }

    public As(String name, int age, String addr, String phone, String gender) {
        this();
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.phone = phone;
        this.gender = gender;
    }

    public As(String name) {
        this(); // default 생성자
        this.name = name;
        System.out.println("as custom");
        // this(); // 순서가 중요 여기서 호출하면 에러가 난다.
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(getName());
        list.add(String.valueOf(getAge()));
        list.add(getAddr());
        list.add(getPhone());
        list.add(getGender());
        return list;
    }

    @Override
    public int length() {
        return 0;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
