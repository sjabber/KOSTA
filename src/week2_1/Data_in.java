package week2_1;

import week3.Day_04_20.I;

import java.util.ArrayList;

public class Data_in implements I {
    // DAO
    String[] name = {"ȫ�浿", "�Ż��Ӵ�", "���﹮"};
    int[] age = {62, 18, 40};
    String[] addr = {"����� ������", "����� ������", "����� ������"};
    String[] phone = {"010-3319-1234", "010-3319-1235", "010-3319-1236"};
    String[] gender = {"��", "��", "��"};

    int avg() {
        int result = 0;
        int num = age.length;
        for (int i = 0; i < num; i++) {
            result += age[i];
        }

        result = result / num;

        return result;
    }

    @Override
    public ArrayList<String> GetList() {
        return null;
    }

    @Override
    public ArrayList<String> GetTuple(int n) {
        return null;
    }
}
