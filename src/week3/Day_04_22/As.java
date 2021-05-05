package week3.Day_04_22;

import java.util.ArrayList;

public abstract class As implements I {
//    A a = null;
    String name;
    int age;
    String addr;
    String phone;
    String gender;

    public As() {

    }

    public As(String name, int age, String addr, String phone, String gender) {
//        this();
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

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(name);
        list.add(String.valueOf(age));
        list.add(addr);
        list.add(phone);
        list.add(gender);

        return list;
    }
}
