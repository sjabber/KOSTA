package week3.Day_04_22;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Day_04_22_1 {

    // ������� �ٷ� ���� �������� �ʴ´�.
    // try catch�� Ȱ���ؼ� ����ó���� �ؾ��Ѵ�.
    public static void main(String[] args) {

        // IOException => try & catch ���� ������ �˾Ƽ� ����ó�����ش�.

        ArrayList<String> list = null;

        String text = "��Ű����� ��Ű�� �̿��Ͽ� �� ���� ������� �Բ� ������ �� ����� �پ�� ��������Դϴ�. ��Ű����� �߸����̰� ���� ������ ���� ������ ��������� ������ �������� �ϴ� ������Ʈ��, ������ �����Ͽ� ������ �����ϰ� ������ų �� �ֽ��ϴ�.\n" +
                "\n" +
                "��Ű����� �ټ� ���� �⺻ ��Ģ�� ���� ��˴ϴ�. ��� ������ ũ������Ƽ�� Ŀ���� ������ǥ��-�������Ǻ������ 3.0�� ���� ����� �� ������, ����, ������ ������ �����Ӱ� ����� ������ ��뵵 �����մϴ�.";

        // src���� ��δ� ������..?
        // ������, � Ÿ�����Ϸ� �Ұ����� ����

        text = text.replaceAll("\\.", ". \n");

        File file = new File("C:\\Users\\Taeho\\JAVA_WORK\\text\\t.txt");

        try {
            //FileReader reader = new FileReader(file);
            // ���� �� ���뿡 ���� ���θ� ����ش�. ��� ��η� ��������� ������ ������ ����
            FileWriter writer = new FileWriter(file);
            writer.write(text);

            // ������ �����ö� ���۸� ����.
            // ����
            //BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedWriter w = new BufferedWriter(writer);

            writer.close();
            w.close();
          // ����� �ƹ� �̻� ������� �����ϰ�
//            int num = 100;
//            num = (num / 0);
//            System.out.println(num);

            // list = new ArrayList<String>();
            // list.add("����");

        } catch (Exception e) {
            // e.getMessage => string ���̴�.
            // catch���� ������ (ex. e) �����ڰ� �ʿ���� �˾Ƽ� �������� �Ҵ��.


            System.out.println(e.getMessage());
            e.printStackTrace(); // => �ý��� ���� ���

            //System.out.println(System.err);
            //System.out.println(System.err); // => �ý��� ������ �ּҰ��� ���


        } finally {

            // �����ϴ� ���ϴ����� ����.*
            // ��� ������ �����ϵ��� �Ѵ�.
            //System.out.println("����1");
        }
        // �Ϸ� �´�.
        System.out.println("����");
    }
}
