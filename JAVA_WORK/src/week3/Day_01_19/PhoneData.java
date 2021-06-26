package week3.Day_01_19;

import week3.Day_04_20.I;
import week3.Day_04_20.key;

import java.util.ArrayList;

public class PhoneData implements key, I
        //implements Comparable<PhoneData>
    {

    //public PhoneS s; // 필드 => 배열, 의존객체 => s

    // DAO
    String[] name = {"송가인", "현빈", "김수현", "아이유", "유재석"};
    private String[] addr = {"경기도 수원시", "서울 특별시", "부산 광역시", "인천 광역시", "대전 광역시"};
    private String[] number = {"00000-123456", "00000-123456", "00000-123456", "00000-123456", "00000-123456"};
    private String[] phoneNum = {"010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234"};
    private String[] email = {"sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com"};
    private String[] service = {"sk-0000-1234", "1g-0000-1234", "kt-0000-1234", "sk-1125-1234", "sk-1125-1234"};
    private String[] plan = {"20000", "20000", "20000", "20000", "20000"};
    private String[] serial = {"기계번호_0000", "기계번호_0000", "기계번호_0000", "기계번호_0000", "기계번호_0000"};

    public PhoneData(int index) {
        // 의존객체, 일종의 커넥션 풀중 하나로 보면될듯.
//        s = new PhoneS(name[index], addr[index], number[index],
//                phoneNum[index], email[index], service[index], plan[index], serial[index]
//        );
//        System.out.println(s);
    }

    public PhoneData() {

    }



//    public PhoneData(String n, String a, String num,  String phNum, String e, String se, String p, String seri) {
//        super();
//        s = new PhoneS(n, a, num, phNum, e, se, p, seri);
//    }

//    @Override
//    public int compareTo(PhoneData o) {
//         return o.s.name.compareTo(this.s.name);
//    }

    public boolean is_true(String names) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < name.length; i++) {
            list.add(name[i]);
        }

        if (list.contains(names)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> GetList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < name.length; i++) {
            list.add(name[i]);
        }
        return list;
    }

        @Override
        public ArrayList<String> GetTuple(int n) {
            return null;
        }

        @Override
        public String[] print_key() {
            String[] str = name;
            return str;
        }
    }
