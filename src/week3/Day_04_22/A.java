package week3.Day_04_22;

public class A extends As {

    public static int num = 0;

    String[] name = {"ȫ�浿", "�Ż��Ӵ�", "���﹮"};
    int[] age = {62, 18, 40};
    String[] addr = {"����� ������", "����� ������", "����� ������"};
    String[] phone = {"010-3319-1234", "010-3319-1235", "010-3319-1236"};
    String[] gender = {"��", "��", "��"};

    public A() {

    }

    public A(int i) {
        setName(name[i]);
        setAge(age[i]);
        setAddr(addr[i]);
        setPhone(phone[i]);
        setGender(gender[i]);
    }

    // Override �� �ۺ��� �Ǿ����.
    @Override
    public int getLength() {
        return name.length;
    }
}
