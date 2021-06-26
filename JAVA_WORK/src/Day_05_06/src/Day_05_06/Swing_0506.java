package Day_05_06.src.Day_05_06;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Swing_0506 {

	private JFrame frame;
	private JTextField textField;
	private boolean[] is_op = {true};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing_0506 window = new Swing_0506();
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
	public Swing_0506() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(23, 31, 519, 635);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.BOLD, 30));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(41, 31, 428, 66);
		panel.add(textField);
		textField.setColumns(10);
		
		createNumberButton(panel);
		createNumOp(panel);

//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBounds(28, 105, 97, 93);
//		panel.add(btnNewButton);

		

		JButton btt_7 = new JButton("0");
		btt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btt_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btt_7.setBackground(Color.WHITE);
		btt_7.setBounds(41, 436, 98, 94);
		panel.add(btt_7);
	}
	
	String op = "";
	int p = 0;
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	String getOp() {
		System.out.println(getP());
		return op;
	}
	
	void setOp(String op) {
		System.out.println("이전 값" + getP());
		setP(Integer.parseInt(textField.getText()));
		is_op[0] = false;
		this.op = op;
	}

	void calcurator() {
		switch(getOp()) {
		case "*":
			textField.setText((getP()*Integer.parseInt(textField.getText()))+"");
			break;
		case "/":
			textField.setText((getP()/Integer.parseInt(textField.getText()))+"");
			break;
		case "-":
			textField.setText((getP()-Integer.parseInt(textField.getText()))+"");
			break;
		case "+":
			textField.setText((getP()+Integer.parseInt(textField.getText()))+"");
			break;
		}
	}

	
	void createNumberButton(JPanel panel) {
		// for문으로 버튼을 배치한다.
		int[] nums = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};
		ButtonEventTest button = new ButtonEventTest(textField, is_op);

		for (int i = 0; i < 3; i++) {
//			System.out.println("test");
			for (int j = 0; j < 3; j++) {
				JButton btt_7 = new JButton(nums[i + (j * 3)] + "");
				btt_7.addActionListener(button);
				btt_7.setBackground(Color.WHITE);
				btt_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
				btt_7.setBounds(41 + (110 * i), 106 + (110 * j), 98, 94);
				panel.add(btt_7);
			}
			System.out.println("test");
		}
		JButton btt_0 = new JButton(nums[9] + "");
		btt_0.addActionListener(button);
		btt_0.setBackground(Color.WHITE);
		btt_0.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btt_0.setBounds(41, 436, 98, 94);
		panel.add(btt_0);
	}

	void createNumOp(JPanel panel) {
		String[] op = {"*", "/", "-", "+", "=", "C"};
		for(int i = 0;  i < 6; i++) {
			
			JButton btt_7 = new JButton (op[i]);
			btt_7.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			btt_7.setBackground(Color.WHITE);
			if (i == 4) {
				btt_7.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						calcurator();
					}
				});
				btt_7.setBounds(260, 436, 98, 94);
			}
			else if (i == 5) {
				btt_7.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						textField.setText("0");
					}
				});
				btt_7.setBounds(150, 436, 98, 94);
			}
			else {
				btt_7.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//is_op[0] = false;
						setOp(e.getActionCommand());
					}
				});
				btt_7.setBounds(370, 106+(110*i), 98, 94);
			}
				
			panel.add(btt_7);
		}
	}

}
