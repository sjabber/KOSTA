package test_2.src.test_2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class test2 {

	private JFrame frame;
	static int count = 0;
	private JTextField textField;
	private JTextField txtTop;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 window = new test2();
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
	public test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 688, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setBounds(78, 111, 506, 219);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38\uD560 \uBA54\uB274\uB97C \uC120\uD0DD\uD558\uC138\uC694.");
		lblNewLabel.setBounds(122, 46, 409, 55);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("100");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count += Integer.parseInt(btnNewButton.getText());
				lblNewLabel.setText("현재 누적액 : " + count);
			}
		});
		btnNewButton.setBounds(49, 28, 96, 133);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("200");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count += Integer.parseInt(btnNewButton_1.getText());
				lblNewLabel.setText("현재 누적액 : " + count);
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 21));
		btnNewButton_1.setBounds(218, 29, 96, 130);
		
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("300");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count += Integer.parseInt(btnNewButton_2.getText());
				lblNewLabel.setText("현재 누적액 : " + count);
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 21));
		btnNewButton_2.setBounds(367, 29, 96, 130);
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\uB808\uC2A4\uBE44");
		textField.setBounds(49, 169, 96, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		txtTop = new JTextField();
		txtTop.setText("TOP");
		txtTop.setHorizontalAlignment(SwingConstants.CENTER);
		txtTop.setBounds(218, 169, 96, 21);
		panel.add(txtTop);
		txtTop.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("\uC2A4\uD0C0\uBC85\uC2A4");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(367, 169, 96, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton btnNewButton_3 = new JButton("\uACB0\uC81C");
		btnNewButton_3.setFont(new Font("나눔고딕", Font.BOLD, 21));
		btnNewButton_3.addActionListener(new ActionListener() {
//			boolean as = true;
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("결제 금액 : " + count);
				btnNewButton_3.setText("카드 넣어주세요.");
				count = 0;
//				panel.setVisible(!panel.isVisible());
			}
		});
		btnNewButton_3.setBounds(305, 363, 278, 86);
		frame.getContentPane().add(btnNewButton_3);
		
		
	}
}
