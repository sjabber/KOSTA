package week2_1;

import static week2_1.day_04_15.arr;

public class Gugudan_inner {

    // ¸â¹ö ÇÊµå (º¯¼ö)
    // ¸â¹ö ¸Þ¼­µå

//    int count; // ¸â¹ö º¯¼ö
//    void test() { }; // ¸â¹ö ¸Þ¼­µå

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
