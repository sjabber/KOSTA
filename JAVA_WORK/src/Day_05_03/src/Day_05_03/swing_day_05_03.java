package Day_05_03.src.Day_05_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing_day_05_03 {

    private JFrame frame;
    private String temp = new String();
    private int numbers = 0;
    private JLabel lblNewLabel;

    private JTextField textField; // 입력창은 전역변수로 만들어진다.

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    swing_day_05_03 window = new swing_day_05_03();
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
    public swing_day_05_03() {
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
        ButtonSign sign = new ButtonSign(temp, textField, lblNewLabel, numbers);

        btn_plus.addActionListener(sign);
        btn_multiply.addActionListener(sign);
        btn_minus.addActionListener(sign);
        btn_divide.addActionListener(sign);

        // =
        btn_equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(numbers));
            }
        });

        // clear
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numbers = 0;
                textField.setText("0");
                lblNewLabel.setText("");
                temp = "";
            }
        });

        // 숫자
        ButtonEventTest number = new ButtonEventTest(temp, textField);

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
}

// Note 기호 눌렀을 경우
class ButtonSign implements ActionListener {

    String temp;
    JTextField textField;
    JLabel label;
    int numbers;
    char mark;

    public ButtonSign() {

    }

    public ButtonSign(String temp, JTextField textField, JLabel lblNewLabel, int numbers) {
        this.temp = temp;
        this.textField = textField;
        this.label = lblNewLabel;
        this.numbers = numbers;
    }

    int calcurator(char c, int number1, int number2) {
        int number = 0;
        switch (c) {
            case '+':
                number = number1 + number2;
                System.out.println(number);
                return number;
            case '-':
                number = number1 - number2;
                System.out.println(number);
                return number;
            case '/':
                number = number1 / number2;
                System.out.println(number);
                return number;
            case '*':
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

        if (temp.length() != 0) {
            char last = temp.charAt(temp.length() - 1);

//            if (last == '+' || last == '-' || last == '*' || last == '/') { // 두번째 이상 수를 입력한 경우
            temp += textField.getText();
            int num = Integer.parseInt(textField.getText()); //현재 입력창에 있는 숫자

            // 계산한다.
            char c = e.getActionCommand().charAt(0);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                temp += e.getActionCommand(); // 기호를 더한다.
//                label.setText(temp); // 라벨에 표시한다.

                numbers = calcurator(c, numbers, num);
                label.setText(String.valueOf(numbers));
                textField.setText("0");
            }
            //}
        } else {
            // 맨 처음 수를 입력한 경우
            // 텍스트 필드의 숫자를 변수에 담는다.
            temp += textField.getText();
            numbers = Integer.parseInt(textField.getText()); // 최근에 들어온 숫자

            // 계산한다
            char c = e.getActionCommand().charAt(0);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                temp += e.getActionCommand(); // 기호를 더한다.
                label.setText(temp); // 라벨에 표시한다.
                textField.setText("0");
            }
        }
    }

}

// Note 숫자 눌렀을 경우
class ButtonEventTest implements ActionListener {

    String temp;
    JTextField textField;

    public ButtonEventTest(JTextField textField) {
        this.textField = textField;
    }

    public ButtonEventTest(String temp) {
        temp = temp;
    }

    public ButtonEventTest(String temp, JTextField textField) {
        this.temp = temp;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String n = e.getActionCommand();
        //System.out.println(!n.equals(textField.getText()));

        if (!textField.getText().equals("0")) {
            textField.setText(textField.getText() + n);
        } else {
            textField.setText(n);
        }

    }

}
