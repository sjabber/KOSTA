package week3.Day_01_19;

import java.util.ArrayList;

public class practice3 {
    public static void main(String[] args) {
        practice2 p2 = new practice2();
        practice1 p1 = new practice1();

        ArrayList<practice2> arr2 = new ArrayList<>();
        ArrayList<practice1> arr1 = new ArrayList<>();

        arr1.add(p1); // �翬
        //arr2.add(p1); // �θ�Ŭ������ �ڽ�Ŭ������ ���� ����.

        arr1.add(p2); // �ڽ�Ŭ������ �θ�Ŭ�������� ���� �� ����
        arr2.add(p2); // �翬
    }
}
