package week3.Day_04_20;

// Note
//  추상클래스 = 인터페이스 + 클래스
//  왜 다른 인터페이스를 상속하고 오버라이딩 하지않아도 빨간줄이 안뜨는가?
//  답 => 추상화니까. 그냥 추상클래스니까. 추상화처리해서 내부적으로 헤드만 있다.
//  인터페이스를 패스하고 자신을 상속받는 클래스에게 오버라이딩을 넘긴다.
public abstract class Abs implements I { // Abs 추상클래스를 상속받은 클래스는 I와 Abs 둘다 오버라이딩해야함.

    // 메서드를 넣을수도
    // 헤드(키워드)만 넣을수도 있다.

    public void test() {

    }

    // 키워드, 단 메서드를 추상화 해야할 때는 abstract 를 앞에 적어줘야한다.
    public abstract void getTest();



}
