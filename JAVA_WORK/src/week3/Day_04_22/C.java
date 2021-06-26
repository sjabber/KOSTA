package week3.Day_04_22;

public class C extends Cs {

    String[] name = {"송가인", "현빈", "김수현", "아이유", "유재석"};
    private String[] addr = {"경기도 수원시", "서울 특별시", "부산 광역시", "인천 광역시", "대전 광역시"};
    private String[] number = {"00000-123456", "00000-123456", "00000-123456", "00000-123456", "00000-123456"};
    private String[] phoneNum = {"010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234", "010-0000-1234"};
    private String[] email = {"sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com", "sjabber@naver.com"};
    private String[] service = {"sk-0000-1234", "1g-0000-1234", "kt-0000-1234", "sk-1125-1234", "sk-1125-1234"};
    private String[] plan = {"20000", "20000", "20000", "20000", "20000"};
    private String[] serial = {"기계번호_0000", "기계번호_0000", "기계번호_0000", "기계번호_0000", "기계번호_0000"};

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
