package week2_1;

public class A_04_15 extends B_04_15 {

//    int count;
//    B_04_15 b;
//    // public, private -> 패키지에 상관없다.
//    // default, protected -> 패키지와 상관있다.
//
//
//    public A_04_15() {
//        //super(3);
//        System.out.println("a 생성자입니다.");
//        // b클래스의 생성자를 호출한다.
//        // 주석처리해도 디폴트로 호출함. (안보여도 super(); 는 숨어있음)
//        // 다만 커스텀 생성자는 디폴트로 호출안해준다. (상속관계에서만)
//        //System.out.println("A 생성자입니다.");
//    }
//
//    public A_04_15(int count) {
//        //super(3);
//        B_04_15 b = new B_04_15();
//        this.count = count;
//        b.number = this.count;
//        // 생성자를 호출하고 끝나기 때문에 B의 멤버변수를 이후에 사용할 수가 없어진다.
//        // 메모리 구조를 이해해야한다.
//        // day_04_15 클래스에서 A_04_15 클래스 변수(ex. a)를 선언하면 b의 생성자가 종료된다.
//        // 하지만 A_04_15 클래스 내부에 B_04_15 b를 선언해 두었으므로
//        // a.b.number 라는 형식으로 사용이 가능하다.
//
//        // DAO => DB 서버 연결객체, DTO => 스키마 필드값을 가져올때 클래스로 긁어온다.
//        this.count = count;
//        System.out.println("a 커스텀 생성자입니다.");
//    }

    int num_a;

    // Note DTO 에 해당한다. 스키마가 있으면 DTO 다.
    String id;
    String name;
    String addr;
    String phone;
    String gender;
    String age;
//    String number;

    // 생성자를 만든다.
    public A_04_15(String id, String name, String addr, String phone, String gender, String age) {


        // 매개변수 이름이 중복됐을 때 this 를 써준다.
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
        // B_04_15 클래스는 A_04_15()클래스의 부모클래스
        // B_04_15 클래스 객체인 b
        // 이 경우 B는 자식클래스의 멤버들은 사용이 불가능하다.
        B_04_15 b = new A_04_15();
        b.num_b = 10;
        //b.id = "string";

        // A클래스는 B클래스를 확장했기 때문에
        // B b = new A(); => 지장없음.
        // A a = new B(); => 문제있음.

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
