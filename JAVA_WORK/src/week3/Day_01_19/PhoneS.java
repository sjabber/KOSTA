package week3.Day_01_19;

public class PhoneS {

    // DTO
    String name;
    String addr;
    String number;
    String phoneNum;
    String email;
    String service; // 통신사
    String plan; // 요금제
    String serial;

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getNumber() {
        return number;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getService() {
        return service;
    }

    public String getPlan() {
        return plan;
    }

    public String getSerial() {
        return serial;
    }

    public PhoneS() {
        super();
    }

    public PhoneS(String name, String addr, String number, String phoneNum, String email, String service, String plan, String serial) {
        this.name = name;
        this.addr = addr;
        this.number = number;
        this.phoneNum = phoneNum;
        this.email = email;
        this.service = service;
        this.plan = plan;
        this.serial = serial;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
