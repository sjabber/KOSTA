package week2_1;

public class Data {
    // DTO
    int age;
    String addr;
    String phone;
    String gender;

    public Data(int age, String addr, String phone, String gender) {
        this.age = age;
        this.addr = addr;
        this.phone = phone;
        this.gender = gender;
    }

    public Data() {
        super();
    }
}
