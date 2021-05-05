package week3.Day_04_20;

import week3.Day_04_20.I;

import java.util.ArrayList;

public class A implements I {

    @Override
    public ArrayList<String> GetList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a_test");
        list.add("a_test2");
        return list;
    }

    @Override
    public ArrayList<String> GetTuple(int n) {
        return null;
    }

    public void test() {
        System.out.println("a test ÀÔ´Ï´Ù.");
    }
}
