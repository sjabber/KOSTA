package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private JFrame frame;
    private JLabel lblNewLabel;
    private String[] save = new String[1]; // 문장이 담길 배열
    private String[] k_sign = new String[2];
    private int[] numbers = new int[1];
    private boolean[] check = new boolean[1];

    private JTextField textField; // 입력창은 전역변수로 만들어진다.

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculator window = new Calculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Calculator() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 526, 758);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        panel.setBounds(12, 10, 493, 704);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setText("0");
        textField.setFont(new Font("굴림", Font.BOLD, 21));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBounds(12, 91, 467, 65);
        textField.setColumns(10);
        panel.add(textField);

        lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(13, 16, 466, 53);
        panel.add(lblNewLabel);

        JButton btn_7 = new JButton("7");
        btn_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn_7.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_7.setBackground(Color.WHITE);
        btn_7.setBounds(13, 182, 106, 99);
        panel.add(btn_7);

        JButton btn_8 = new JButton("8");
        btn_8.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_8.setBackground(Color.WHITE);
        btn_8.setBounds(133, 182, 106, 99);
        panel.add(btn_8);

        JButton btn_9 = new JButton("9");
        btn_9.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_9.setBackground(Color.WHITE);
        btn_9.setBounds(253, 182, 106, 99);
        panel.add(btn_9);

        JButton btn_multiply = new JButton("*");
        btn_multiply.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_multiply.setBackground(Color.WHITE);
        btn_multiply.setBounds(373, 182, 106, 99);
        panel.add(btn_multiply);

        JButton btn_4 = new JButton("4");
        btn_4.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_4.setBackground(Color.WHITE);
        btn_4.setBounds(13, 313, 106, 99);
        panel.add(btn_4);

        JButton btn_5 = new JButton("5");
        btn_5.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_5.setBackground(Color.WHITE);
        btn_5.setBounds(133, 313, 106, 99);
        panel.add(btn_5);

        JButton btn_6 = new JButton("6");
        btn_6.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_6.setBackground(Color.WHITE);
        btn_6.setBounds(253, 313, 106, 99);
        panel.add(btn_6);

        JButton btn_1 = new JButton("1");
        btn_1.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_1.setBackground(Color.WHITE);
        btn_1.setBounds(13, 444, 106, 99);
        panel.add(btn_1);

        JButton btn_2 = new JButton("2");
        btn_2.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_2.setBackground(Color.WHITE);
        btn_2.setBounds(133, 444, 106, 99);
        panel.add(btn_2);

        JButton btn_3 = new JButton("3");
        btn_3.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_3.setBackground(Color.WHITE);
        btn_3.setBounds(253, 444, 106, 99);
        panel.add(btn_3);

        JButton btn_0 = new JButton("0");
        btn_0.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_0.setBackground(Color.WHITE);
        btn_0.setBounds(13, 575, 106, 99);
        panel.add(btn_0);

        JButton btn_clear = new JButton("c");
        btn_clear.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_clear.setBackground(Color.WHITE);
        btn_clear.setBounds(133, 575, 106, 99);
        panel.add(btn_clear);

        JButton btn_equal = new JButton("=");
        btn_equal.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_equal.setBackground(Color.WHITE);
        btn_equal.setBounds(253, 575, 106, 99);
        panel.add(btn_equal);

        JButton btn_divide = new JButton("/");
        btn_divide.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_divide.setBackground(Color.WHITE);
        btn_divide.setBounds(373, 313, 106, 99);
        panel.add(btn_divide);

        JButton btn_minus = new JButton("-");
        btn_minus.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_minus.setBackground(Color.WHITE);
        btn_minus.setBounds(373, 444, 106, 99);
        panel.add(btn_minus);

        JButton btn_plus = new JButton("+");
        btn_plus.setFont(new Font("나눔고딕", Font.BOLD, 21));
        btn_plus.setBackground(Color.WHITE);
        btn_plus.setBounds(373, 575, 106, 99);
        panel.add(btn_plus);

        // 기호 (+, -, /, *)
        ButtonSign sign = new ButtonSign(save, k_sign, textField, lblNewLabel, numbers);

        btn_plus.addActionListener(sign);
        btn_multiply.addActionListener(sign);
        btn_minus.addActionListener(sign);
        btn_divide.addActionListener(sign);

        // =
        btn_equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText() == "") {
                    textField.setText(String.valueOf(numbers));
                } else {
                    save[0] += " " + textField.getText() + " =";
                    lblNewLabel.setText(save[0]);

                    int num = Integer.parseInt(textField.getText());
                    numbers[0] = calcurator(k_sign[0], numbers[0], num);
                    textField.setText(String.valueOf(numbers[0]));
                    k_sign[1] = k_sign[0];

                    save[0] = null;
                    numbers[0] = 0;
                    check[0] = true;
                }
            }
        });

        // clear
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save[0] = null;
                k_sign[0] = "";
                k_sign[1] = "";
                numbers[0] = 0;

                textField.setText("");
                lblNewLabel.setText("");
            }
        });

        // 숫자
        ButtonEventTest number = new ButtonEventTest(save, k_sign, textField, lblNewLabel, check);

        btn_0.addActionListener(number);
        btn_1.addActionListener(number);
        btn_2.addActionListener(number);
        btn_3.addActionListener(number);
        btn_4.addActionListener(number);
        btn_5.addActionListener(number);
        btn_6.addActionListener(number);
        btn_7.addActionListener(number);
        btn_8.addActionListener(number);
        btn_9.addActionListener(number);
    }

    void num(String text) {
        textField.setText("test");
    }

    int calcurator(String c, int number1, int number2) {
        int number = 0;
        switch (c) {
            case "+":
                number = number1 + number2;
                System.out.println(number);
                return number;
            case "-":
                number = number1 - number2;
                System.out.println(number);
                return number;
            case "/":
                number = number1 / number2;
                System.out.println(number);
                return number;
            case "*":
                number = number1 * number2;
                System.out.println(number);
                return number;
        }

        // 오류발생상황
        System.out.println("오류 발생");
        return number1;
    }
}

// Note 기호 눌렀을 경우
class ButtonSign implements ActionListener {

    String[] save;
    String[] k_sign;
    JTextField textField;
    JLabel label;
    int[] numbers;
    char mark;

    public ButtonSign() {

    }

    public ButtonSign(String[] save, String[] k_sign, JTextField textField, JLabel lblNewLabel, int[] numbers) {
        this.save = save;
        this.k_sign = k_sign;
        this.textField = textField;
        this.label = lblNewLabel;
        this.numbers = numbers;
    }

    int calcurator(String c, int number1, int number2) {
        int number = 0;
        switch (c) {
            case "+":
                number = number1 + number2;
                System.out.println(number);
                return number;
            case "-":
                number = number1 - number2;
                System.out.println(number);
                return number;
            case "/":
                number = number1 / number2;
                System.out.println(number);
                return number;
            case "*":
                number = number1 * number2;
                System.out.println(number);
                return number;
        }

        // 오류발생상황
        System.out.println("오류 발생");
        return number1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 맨 처음 숫자입력인 경우
        if (save[0] == null) {
            numbers[0] = Integer.parseInt(textField.getText());

            // ex) 123 +
            save[0] = textField.getText() + " " + e.getActionCommand().charAt(0);

            // ex) 123 +
            label.setText(save[0]);

            k_sign[0] = e.getActionCommand(); // 계산에 사용될 부호가 담긴다.
            k_sign[1] = e.getActionCommand(); // 텍스트 필드를 갱신하기 위한 용도.

        } else {
            if (textField.getText() != "") {
                int num = Integer.parseInt(textField.getText());
                numbers[0] = calcurator(k_sign[0], numbers[0], num);

                save[0] += " " + textField.getText();

                label.setText(save[0]);

                textField.setText(String.valueOf(numbers[0]));

                k_sign[0] = e.getActionCommand(); // 계산에 사용될 부호가 담긴다.
                k_sign[1] = e.getActionCommand(); // 텍스트 필드를 갱신하기 위한 용도.

                save[0] += " " + k_sign[0];

            } else {
                System.out.println("비어있음");
            }
        }
    }
}

// Note 숫자 눌렀을 경우
class ButtonEventTest implements ActionListener {

    String[] save;
    String[] k_sign;
    JTextField textField;
    JLabel label;
    boolean[] check;

    public ButtonEventTest(JTextField textField) {
        this.textField = textField;
    }

    public ButtonEventTest(String temp) {
        temp = temp;
    }

    public ButtonEventTest(String[] save, String[] k_sign, JTextField textField, JLabel label, boolean[] check) {
        this.save = save;
        this.k_sign = k_sign;
        this.textField = textField;
        this.label = label;
        this.check = check;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String n = e.getActionCommand();
        //System.out.println(!n.equals(textField.getText()));

        if (check[0]) {
            label.setText("");
            check[0] = false;
        }

        // 맨처음 입력
        if (k_sign[1] == "") {
            if (!textField.getText().equals("0")) {
                textField.setText(textField.getText() + n);
            } else {
                textField.setText(n);
            }
        } else {
            k_sign[1] = "";
            textField.setText("");

            if (!textField.getText().equals("0")) {
                textField.setText(textField.getText() + n);
            } else {
                textField.setText(n);
            }
        }


    }

}
