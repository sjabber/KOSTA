package week3.Day_04_20;

import week3.Day_04_20.I;

import java.util.ArrayList;

public class C implements I {

    String[] title = {"����", "���鷯����Ʈ", "Ÿ��Ÿ��", "�����", "Ŭ����"};
    String[] director = {"�󺣼�", "���ʹ���", "ī�޷�", "����ȣ", "�����"};
    String[] genre = {"�׼�", "���", "���", "������", "���"};
    String[] count = {"100��", "300��", "900��", "1000��", "150��"}; // ������
    String[] actor = {"�帣��", "���� �Ͻ�", "��ī������", "�۰�ȣ", "���¿�"};
    String[] actress = {"��Ż��", "������", "����Ʈ", "������", "�տ���"};
    String[] time = {"120��", "200��", "160��", "120��", "120��"};

    @Override
    public ArrayList<String> GetList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("c_test");
        return list;
    }

    @Override
    public ArrayList<String> GetTuple(int n) {
        ArrayList<String> tuple = new ArrayList<>();
        tuple.add(title[n]);
        tuple.add(director[n]);
        tuple.add(genre[n]);
        tuple.add(count[n]);
        tuple.add(actor[n]);
        tuple.add(actress[n]);
        tuple.add(time[n]);

        return tuple;
    }
}
