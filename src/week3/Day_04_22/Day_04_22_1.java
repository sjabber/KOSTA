package week3.Day_04_22;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Day_04_22_1 {

    // 통신쪽은 바로 값을 가져오지 않는다.
    // try catch를 활용해서 예외처리를 해야한다.
    public static void main(String[] args) {

        // IOException => try & catch 문이 없으면 알아서 예외처리해준다.

        ArrayList<String> list = null;

        String text = "위키백과는 위키를 이용하여 전 세계 사람들이 함께 만들어가는 웹 기반의 다언어 백과사전입니다. 위키백과는 중립적이고 검증 가능한 자유 콘텐츠 백과사전의 제공을 목적으로 하는 프로젝트로, 누구나 참여하여 문서를 수정하고 발전시킬 수 있습니다.\n" +
                "\n" +
                "위키백과는 다섯 가지 기본 원칙에 따라 운영됩니다. 모든 문서는 크리에이티브 커먼즈 저작자표시-동일조건변경허락 3.0에 따라 사용할 수 있으며, 복사, 수정과 배포가 자유롭고 상업적 목적의 사용도 가능합니다.";

        // src파일 경로는 못들어간다..?
        // 목적지, 어떤 타입파일로 할것인지 결정

        text = text.replaceAll("\\.", ". \n");

        File file = new File("C:\\Users\\Taeho\\JAVA_WORK\\text\\t.txt");

        try {
            //FileReader reader = new FileReader(file);
            // 글을 쓴 내용에 대한 선로를 깔아준다. 어느 경로로 어느파일을 생성할 것인지 연결
            FileWriter writer = new FileWriter(file);
            writer.write(text);

            // 파일을 가져올때 버퍼를 쓴다.
            // 피켓
            //BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedWriter w = new BufferedWriter(writer);

            writer.close();
            w.close();
          // 제어문이 아무 이상 없을경우 수행하고
//            int num = 100;
//            num = (num / 0);
//            System.out.println(num);

            // list = new ArrayList<String>();
            // list.add("성공");

        } catch (Exception e) {
            // e.getMessage => string 값이다.
            // catch문의 변수는 (ex. e) 생성자가 필요없이 알아서 힙영역에 할당됨.


            System.out.println(e.getMessage());
            e.printStackTrace(); // => 시스템 에러 출력

            //System.out.println(System.err);
            //System.out.println(System.err); // => 시스템 에러의 주소값을 출력


        } finally {

            // 성공하던 못하던간에 띄운다.*
            // 어떠한 경우더라도 수행하도록 한다.
            //System.out.println("성공1");
        }
        // 일로 온다.
        System.out.println("도달");
    }
}
