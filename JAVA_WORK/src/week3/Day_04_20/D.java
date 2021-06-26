package week3.Day_04_20;

import java.util.ArrayList;

public class D extends Abs {

    @Override
    public void getTest() {
        System.out.println("test");
    }

    @Override
    public ArrayList<String> GetList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("D class");
        return list;
    }

    @Override
    public ArrayList<String> GetTuple(int n) {
        return null;
    }

    public void list() {
        System.out.println("list");
    }
}
