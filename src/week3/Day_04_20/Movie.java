package week3.Day_04_20;

import java.util.ArrayList;

public class Movie implements Comparable<Movie>, key, I {
    MovieS s; // ���̺� ��Ű���� ��� ��ü ����

    String[] title = {"����", "���鷯����Ʈ", "Ÿ��Ÿ��", "�����", "Ŭ����"};
    String[] director = {"�󺣼�", "���ʹ���", "ī�޷�", "����ȣ", "�����"};
    String[] genre = {"�׼�", "���", "���", "������", "���"};
    String[] count = {"100��", "300��", "900��", "1000��", "150��"}; // ������
    String[] actor = {"�帣��", "���� �Ͻ�", "��ī������", "�۰�ȣ", "���¿�"};
    String[] actress = {"��Ż��", "������", "����Ʈ", "������", "�տ���"};
    String[] time = {"120��", "200��", "160��", "120��", "120��"};

    public Movie() {

        s = new MovieS();
        s.setTitle(title[0]);
        s.setDirector(director[0]);
        s.setGenre(genre[0]);
        s.setCount(count[0]);
        s.setActor(actor[0]);
        s.setActress(actress[0]);
        s.setTime(time[0]);

    }

    public Movie(int n) {

        s = new MovieS();
        s.setTitle(title[n]);
        s.setDirector(director[n]);
        s.setGenre(genre[n]);
        s.setCount(count[n]);
        s.setActor(actor[n]);
        s.setActress(actress[n]);
        s.setTime(time[n]);

    }

    @Override
    public int compareTo(Movie o) {
        // �ڿ��� ����
        return this.s.getTitle().compareTo(o.s.getTitle());
    }

    @Override
    public String[] print_key() {
        String[] str = title;
        return str;
    }

    @Override
    public ArrayList<String> GetList() {
        return null;
    }

    @Override
    public ArrayList<String> GetTuple(int n) {
        return null;
    }
}
