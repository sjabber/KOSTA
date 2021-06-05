package week5_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing_day_05_06 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_day_05_06 window = new swing_day_05_06();
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
	public swing_day_05_06() {
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
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(41, 31, 440, 66);
		panel.add(textField);
		textField.setColumns(10);
		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBounds(28, 105, 97, 93);
//		panel.add(btnNewButton);
		
		
		// for문으로 버튼을 배치한다.
		int[] nums = {7, 8, 9, 4, 5, 6, 1, 2, 3};
		for(int i = 0; i < 3; i++) {
			System.out.println("test");
			for(int j = 0; j < 3; j++) {
				JButton btt_7 = new JButton(nums[i + (j*3)] + "");
				btt_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btt_7.setBackground(Color.WHITE);
				btt_7.setBounds(41+(110*i), 106 + (110*j), 98, 94);
				panel.add(btt_7);
			}
			System.out.println("test");
		}
		
		
		JButton btt_7 = new JButton("7");
		btt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btt_7.setBackground(Color.WHITE);
		btt_7.setBounds(41, 436, 98, 94);
		panel.add(btt_7);
	}
}
