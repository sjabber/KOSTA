package week3.Day_04_23;

import java.util.ArrayList;

public class A implements I {

    String[] name = {"홍길동", "신사임당", "성삼문"};
    String[] phone = {"010", "011", "012"};
    String[] addr = {"서울", "부산", "강원도"};
    int[] age = {40, 18, 62};
    String[] gender = {"남", "여", "남"};

    ArrayList<String> str = new ArrayList<String>();

    public A(int i) {
        str.add(name[i] + " ");
        str.add(phone[i] + " ");
        str.add(addr[i] + " ");
        str.add(age[i] + " ");
        str.add(gender[i] + " ");
        str.add("\n");
    }

    public A() {

    }

    @Override
    public int getLenth() {
        return name.length;
    }

    @Override
    public String getStr(int i) {
        String info = "";
        info = name[i]  + " " + phone[i] + " " + addr[i] + " " + age[i] + " " + gender[i] + "\n";
        return info;
    }
}
