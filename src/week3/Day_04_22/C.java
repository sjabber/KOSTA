package week3.Day_04_22;

public class C extends Cs {

    String[] name = {"�۰���", "����", "�����", "������", "���缮"};
    private String[] addr = {"��⵵ ������", "���� Ư����", "�λ� ������", "��õ ������", "���� ������"};
    private String[] number = {"00000-123456", "00000-123456", "00000-123456", "00000-123456", "00000-123456"};
    private String[] phoneNum = {"010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234"};
    private String[] email = {"sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com"};
    private String[] service = {"sk-0000-1234", "1g-0000-1234", "kt-0000-1234", "sk-1125-1234", "sk-1125-1234"};
    private String[] plan = {"20000", "20000", "20000", "20000", "20000"};
    private String[] serial = {"����ȣ_0000", "����ȣ_0000", "����ȣ_0000", "����ȣ_0000", "����ȣ_0000"};

    public C() {

    }

    public C (int i) {
        setName(name[i]);
        setAddr(addr[i]);
        setNumber(number[i]);
        setPhoneNum(phoneNum[i]);
        setEmail(email[i]);
        setService(service[i]);
        setPlan(plan[i]);
        setSerial(serial[i]);
    }

    @Override
    public int getLength() {
        return name.length;
    }
}
