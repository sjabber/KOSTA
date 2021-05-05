package week3.Day_04_23;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String str = br.readLine();
//        br.close();
//        bw.write(str);
//        bw.newLine();
//        bw.flush();
//        bw.close();


        File file = new File("C:\\Users\\가족PC\\IdeaProjects\\practice\\text\\t0.txt");


        String url = "C:\\Users\\가족PC\\IdeaProjects\\practice\\text\\t";

        for (int i = 0; i < 2; i++) {
            url += i + ".txt";
            File file2 = new File(url);
            FileReader reader = new FileReader(file2);
            BufferedReader r = new BufferedReader(reader);
            String rc22 = "";
            while((rc22 = r.readLine()) != null) {
                System.out.println(rc22);
            }
            System.out.println();
            url = "C:\\Users\\가족PC\\IdeaProjects\\practice\\text\\t";
        }



//        FileReader reader = new FileReader(file);
//        BufferedReader r = new BufferedReader(reader);
//        int num = 0 ;// r.read();
//        while((num = r.read()) != -1) {
//            System.out.println(r.readLine());
//        }
//
//        String rc = "";
//        while((rc = r.readLine()) != null) {
//            System.out.println(rc);
//        }
//
//        reader.close();
//        r.close();

//        Stack<Integer> st = new Stack<Integer>();
//
//        // 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
//        st.push(5);
//        st.push(2);
//        st.push(3);
//        st.push(7);
//        st.pop();
//        st.push(1);
//        st.push(4);
//        st.pop();
//
//        int N = st.size();
//
//        for (int i = 0; i < N; i++) {
//            System.out.print(st.peek() + " ");
//            st.pop();
//        }
    }
}