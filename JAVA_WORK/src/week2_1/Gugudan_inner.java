package week2_1;

import static week2_1.day_04_15.arr;

public class Gugudan_inner {

    // ��� �ʵ� (����)
    // ��� �޼���

//    int count; // ��� ����
//    void test() { }; // ��� �޼���

    public Gugudan_inner() {
    }

    public Gugudan_inner(int n) {
        for (int i = 1; i < 10; i++) {

            System.out.println(n + " * " + i + " = " + i * n);
            arr += n + " * " + i + " = " + i * n + "\n";

        }
    }

    public String Gugudan_inner(String str, int n) {

        for (int i = 1; i < 10; i++) {

            //System.out.println(n + " * " + i + " = " + i * n);
            str += n + " * " + i + " = " + i * n + "\n";

        }
        str += "---------------\n";

        return str;
    }
}
