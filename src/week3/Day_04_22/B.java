package week3.Day_04_22;

public class B extends Bs {
    String[] title = {"����", "���鷯����Ʈ", "Ÿ��Ÿ��", "�����", "Ŭ����"};
    String[] director = {"�󺣼�", "���ʹ���", "ī�޷�", "����ȣ", "�����"};
    String[] genre = {"�׼�", "���", "���", "������", "���"};
    String[] count = {"100��", "300��", "900��", "1000��", "150��"}; // ������
    String[] actor = {"�帣��", "���� �Ͻ�", "��ī������", "�۰�ȣ", "���¿�"};
    String[] actress = {"��Ż��", "������", "����Ʈ", "������", "�տ���"};
    String[] time = {"120��", "200��", "160��", "120��", "120��"};

    public B() {
        super();
    }

    public B (int i) {
        setTitle(title[i]);
        setDirector(director[i]);
        setGenre(genre[i]);
        setCount(count[i]);
        setActor(actor[i]);
        setActress(actress[i]);
        setTime(time[i]);
    }


    @Override
    public int getLength() {
        return title.length;
    }
}
