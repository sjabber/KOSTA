package week3.Day_01_19;

import week3.Day_04_20.I;
import week3.Day_04_20.key;

import java.util.ArrayList;

public class PhoneData implements key, I
        //implements Comparable<PhoneData>
    {

    //public PhoneS s; // �ʵ� => �迭, ������ü => s

    // DAO
    String[] name = {"�۰���", "����", "�����", "������", "���缮"};
    private String[] addr = {"��⵵ ������", "���� Ư����", "�λ� ������", "��õ ������", "���� ������"};
    private String[] number = {"00000-123456", "00000-123456", "00000-123456", "00000-123456", "00000-123456"};
    private String[] phoneNum = {"010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234"};
    private String[] email = {"sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com"};
    private String[] service = {"sk-0000-1234", "1g-0000-1234", "kt-0000-1234", "sk-1125-1234", "sk-1125-1234"};
    private String[] plan = {"20000", "20000", "20000", "20000", "20000"};
    private String[] serial = {"����ȣ_0000", "����ȣ_0000", "����ȣ_0000", "����ȣ_0000", "����ȣ_0000"};

    public PhoneData(int index) {
        // ������ü, ������ Ŀ�ؼ� Ǯ�� �ϳ��� ����ɵ�.
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
