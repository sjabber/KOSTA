package week2_1;

public class A_04_15 extends B_04_15 {

//    int count;
//    B_04_15 b;
//    // public, private -> ��Ű���� �������.
//    // default, protected -> ��Ű���� ����ִ�.
//
//
//    public A_04_15() {
//        //super(3);
//        System.out.println("a �������Դϴ�.");
//        // bŬ������ �����ڸ� ȣ���Ѵ�.
//        // �ּ�ó���ص� ����Ʈ�� ȣ����. (�Ⱥ����� super(); �� ��������)
//        // �ٸ� Ŀ���� �����ڴ� ����Ʈ�� ȣ������ش�. (��Ӱ��迡����)
//        //System.out.println("A �������Դϴ�.");
//    }
//
//    public A_04_15(int count) {
//        //super(3);
//        B_04_15 b = new B_04_15();
//        this.count = count;
//        b.number = this.count;
//        // �����ڸ� ȣ���ϰ� ������ ������ B�� ��������� ���Ŀ� ����� ���� ��������.
//        // �޸� ������ �����ؾ��Ѵ�.
//        // day_04_15 Ŭ�������� A_04_15 Ŭ���� ����(ex. a)�� �����ϸ� b�� �����ڰ� ����ȴ�.
//        // ������ A_04_15 Ŭ���� ���ο� B_04_15 b�� ������ �ξ����Ƿ�
//        // a.b.number ��� �������� ����� �����ϴ�.
//
//        // DAO => DB ���� ���ᰴü, DTO => ��Ű�� �ʵ尪�� �����ö� Ŭ������ �ܾ�´�.
//        this.count = count;
//        System.out.println("a Ŀ���� �������Դϴ�.");
//    }

    int num_a;

    // Note DTO �� �ش��Ѵ�. ��Ű���� ������ DTO ��.
    String id;
    String name;
    String addr;
    String phone;
    String gender;
    String age;
//    String number;

    // �����ڸ� �����.
    public A_04_15(String id, String name, String addr, String phone, String gender, String age) {


        // �Ű����� �̸��� �ߺ����� �� this �� ���ش�.
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
//        this.number = number;
    }

    public A_04_15(String[] str) {
        this.id = str[0];
        this.name = str[1];
        this.addr = str[2];
        this.phone = str[3];
        this.gender = str[4];
        this.age = str[5];
    }

    public A_04_15() {
        //super();
    }

    public void test() {
        // B_04_15 Ŭ������ A_04_15()Ŭ������ �θ�Ŭ����
        // B_04_15 Ŭ���� ��ü�� b
        // �� ��� B�� �ڽ�Ŭ������ ������� ����� �Ұ����ϴ�.
        B_04_15 b = new A_04_15();
        b.num_b = 10;
        //b.id = "string";

        // AŬ������ BŬ������ Ȯ���߱� ������
        // B b = new A(); => �������.
        // A a = new B(); => ��������.

        B_04_15 b2 = new B_04_15();
        b2.num_b = 10;

        A_04_15 a = (A_04_15) new B_04_15();
        a.id = "10";
        a.num_b = 10;

        A_04_15 a2 = new A_04_15();
        a2.id = "10";
        a2.num_b = 10;
    }
}
