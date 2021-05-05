package week3.Day_04_23;

import java.util.ArrayList;

public class B implements I {
    String[] name = {"송가인", "현빈", "김수현", "아이유", "유재석"};
    String[] number = {"경기도 수원시", "서울특별시", "부산 광역시", "인천 광역시", "대구광역시"};
    String[] phoneNum = {"010-9999-1234", "010-9999-1234", "010-9999-1234", "010-9999-1234", "010-9999-1234"};
    String[] email = {"kmgc18@naver.com", "kmgc18@naver.com", "kmgc18@naver.com", "kmgc18@naver.com", "kmgc18@naver.com"};
    String[] service = {"sk", "kt", "u+", "알뜰폰", "kt"};
    String[] plan = {"20000", "50000", "10000", "30000", "40000"};
    String[] serial = {"기계번호_0000", "기계번호_0000", "기계번호_0000", "기계번호_0000", "기계번호_0000"};

    ArrayList<String> str = new ArrayList<String>();

    public B(int i) {
        str.add(name[i] + " ");
        str.add(number[i] + " ");
        str.add(phoneNum[i] + " ");
        str.add(email[i] + " ");
        str.add(service[i] + " ");
        str.add(plan[i] + " ");
        str.add(serial[i] + " ");
        str.add("\n");
    }

    public B() {

    }

    @Override
    public int getLenth() {
        return name.length;
    }

    @Override
    public String getStr(int i) {
        String info = new String();
        info = name[i]  + " " + number[i] + " " + phoneNum[i] + " " + email[i] + " " + service[i] + " " +
                plan[i] + " " + serial[i] + "\n";
        return info;
    }
}
