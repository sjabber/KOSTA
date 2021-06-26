package week3.Day_01_19;

import java.util.ArrayList;

public class practice3 {
    public static void main(String[] args) {
        practice2 p2 = new practice2();
        practice1 p1 = new practice1();

        ArrayList<practice2> arr2 = new ArrayList<>();
        ArrayList<practice1> arr1 = new ArrayList<>();

        arr1.add(p1); // 당연
        //arr2.add(p1); // 부모클래스는 자식클래스에 들어가지 못함.

        arr1.add(p2); // 자식클래스는 부모클래스형에 넣을 수 있음
        arr2.add(p2); // 당연
    }
}
