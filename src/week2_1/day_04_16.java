package week2_1;

import java.util.*;

public class day_04_16 {
    // Service ����
    // key : �̸�, value : class ���� �ּ� �ڵ�����ȣ ����
    public static void main(String[] args) {

            HashMap<String, Data> map = new HashMap<String, Data>();
            Data_in data = new Data_in();
        for (int i = 0; i < data.name.length; i++) {
            Data p_data = new Data(data.age[i], data.addr[i], data.phone[i], data.gender[i]);
            map.put(data.name[i], p_data);
        }

        for (String string : map.keySet()) {
            Data p_data = map.get(string);
            System.out.print(map.get(string) + "\t\t");
            System.out.print(string  + "\t\t");
            System.out.print(p_data.age  + "\t\t");
            System.out.print(p_data.addr  + "\t\t");
            System.out.print(p_data.phone  + "\t\t");
            System.out.print(p_data.gender  + "\t\t");
            System.out.println();
        }
        System.out.println("��ճ��� : " + data.avg());

        System.out.println(map.keySet());
    }

    static void set_test() {
        HashSet<Integer> set_list = new HashSet<Integer>();
        TreeSet<Integer> tree_set = new TreeSet<Integer>();

        set_list.add(100);
        set_list.add(200);
        set_list.add(300);
        set_list.add(400);
        set_list.add(400); // �ߺ����� ������� �ʴ´�.

        System.out.println(set_list.size());
        for (int item : set_list) {
            // ������� ��µ��� �ʴ´�. (= �ε����� ����.)
            System.out.println(item);
        }

        tree_set.add(100);
        tree_set.add(200);
        tree_set.add(300);
        tree_set.add(400);
        tree_set.add(400); // �ߺ��� ������� �ʴ´�.
        System.out.println(tree_set.size());
        for (int item : tree_set) {
            // ������� ��µȴ�.
            System.out.println(item);
        }
    }
}
