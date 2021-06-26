package week2_1;

import java.util.ArrayList;

public class day_04_14 {

    public static void main(String[] args) {

        ArrayList<int[][]> list_a2 = new ArrayList<int[][]>();
        int[] array_int = {100, 200, 300};
        int[][] array_int2 = {{1, 2, 3}, {4, 5, 6, 7}, array_int};
        list_a2.add(array_int2);
        System.out.println(list_a2); // [] 출력 => 주소를 담는 주소를 의미한다.
        System.out.println(list_a2.get(0)); // array_int2 의 주소가 출력된다.
        System.out.println(list_a2.get(0)[1]); // array_int2[1] 의 주소가 출력된다.
        System.out.println(list_a2.get(0)[1][0]); // 값

        // list_a2 에 더 많이 추가되었다면 for문 한번 더 써야함
        int[][] tmp = list_a2.get(0);
        for (int j = 0; j < tmp.length; j++) {
            for (int k = 0; k < tmp[j].length; k++) {
                System.out.print(tmp[j][k] + " ");
            }
        }
//        for문 한번 더 쓴 경우.
//        for (int i = 0; i < list_a2.size(); i++) {
//            int[][] tmp = list_a2.get(0);
//            for (int j = 0; j < tmp.length; j++) {
//                for (int k = 0; k < tmp[j].length; k++) {
//                    System.out.print(tmp[j][k] + " ");
//                }
//            }
//        }

        System.out.println();

        // list_a2.size() => 사이즈가 1
        int[][][] int_a3 = new int[list_a2.size()][][];
        int_a3[0] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8}};

        // int_a3.length = list_a2.size()
        for (int i = 0; i < int_a3.length; i++) {
            for (int j = 0; j < int_a3[0].length; j++) {
                for (int k = 0; k < int_a3[j].length; k++) {
                    System.out.print(int_a3[j][k] + " ");
                }
            }
        }

        // 선생님 방식
        int[][][] int_a4 = new int[list_a2.size()][][];

        for (int i = 0; i < list_a2.size(); i++) {
            // list_a2.get(i).lenth => 3
            for (int j = 0; j < list_a2.get(i).length; j++) {
                int_a4[i][j] = new int[list_a2.get(i)[j].length];
                for (int k = 0; k < list_a2.get(i)[j].length; k++) {
                    int_a4[i][j][k] = list_a2.get(i)[j][k];
                    System.out.println(int_a4[i][j][k]);
                }
            }
        }
        



        //list_a2.add(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});

//		A_04_14 a = new A_04_14(3); // 구구단 출력
//		A_04_14 aa = new A_04_14(); // 디폴트 생성자 출력
//		A_04_14 aaa = new A_04_14("hello"); // hello 출력
//
//		String n1 = new String();
//		String n2 = new String("hello");
//
//        day_04_14 day = new day_04_14();
//
//        ArrayList<Integer> list = new ArrayList<Integer>();
//		LinkedList<Integer> list_i = new LinkedList<Integer>();
//
//		System.out.println("ArrayList");
//        timeCurrents(list);
//        // ArrayList
//        // 삽입 2315.0 ms (2.315초)
//        // 삭제 425.0 (0.425초)
//        System.out.println("**********");
//
//		System.out.println("LinkedList");
//        timeCurrents(list_i);
//        // LinkedList
//        // 삽입 6176.0 ms (6.176초)
//        // 삭제 16.0 (0.016초)
//
//		ArrayList<int[]> int_a_list = new ArrayList<int[]>();
//		int[] array_int = new int[10];
//		for (int i = 0; i < array_int.length; i++) {
//		    array_int[i] = 1;
//        }
//		int_a_list.add(array_int);
//        int_a_list.add(array_int); // 같은걸 삽입함
//        System.out.println(int_a_list.size());
//        System.out.println(int_a_list.get(0).length);
//
//        // int_a_list.size() => 2
//        int[][] list2 = new int[int_a_list.size()][];
//        list2[0] = new int[2];
//
//        String text = "hello;world;test;counts";
//        String[] tp = text.split(";"); // length => 4
//        char[][] ca = new char[tp.length][];
//
//        System.out.println(tp.length);
//        for (int i = 0; i < tp.length; i++) {
//            ca[i] = new char[tp[i].length()];
//            for (int j = 0; j < ca[i].length; j++) {
//                ca[i][j] = tp[i].charAt(j);
//            }
    }


//        for (int i = 0; i < int_a_list.size(); i++) {
//            System.out.println("주소가 출력됩니다. : " + int_a_list.get(i));
//            System.out.println(int_a_list.get(i).length);
//        }


// 거듭제곱으로 증가하도록
//        int result = 1;
//
//        for (int i = 1; i <= 31; i++) {
//            System.out.println(result * 100);
//            result *= 2;
//        }


//    public static int multiple(int n) {
//        int result = 2;
//        for (int i = 0; i < n; i++) {
//            result = result * 2;
//        }
//
//        return result;
//    }

//    public static void timeCurrents(List<Integer> l) {
//
//    	double startTime = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            l.add(i);
//        }
//        double endTime = System.currentTimeMillis();
//
//        System.out.println("List : " + (endTime - startTime));
//
//	}

//    @Override
//    public void timeCurrents(LinkedList<Integer> l) {
//        double startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            l.add(i);
//        }
//        double endTime = System.currentTimeMillis();
//
//        System.out.println("LinkedList : " + (endTime - startTime));
//    }
//
//    @Override
//    public void timeCurrents(ArrayList<Integer> l) {
//        double startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            l.add(i);
//        }
//        double endTime = System.currentTimeMillis();
//
//        System.out.println("ArrayList : " + (endTime - startTime));
//    }
}
