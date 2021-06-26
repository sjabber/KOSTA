package Day_05_06.src.Day_05_06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

class ButtonEventTest implements ActionListener {
	JTextField textField = null;
	String s = "";
	String[] sa = {""};
	boolean[] is_op = {true};
	
	public ButtonEventTest() {
		
	}
	
	
	public ButtonEventTest(JTextField textField) {
		this.textField = textField;
	}

	public ButtonEventTest(JTextField textField, String s) {
		this.textField = textField;
		this.s = s;

	}

	
	public ButtonEventTest(JTextField textField, String[] s) {
		this.textField = textField;
		this.sa = s;
	}
	
	public ButtonEventTest(JTextField textField, boolean[] is_op) {
		this.textField = textField;
		this.is_op = is_op;

	}

	@Override
	public void actionPerformed(ActionEvent e) { // e는 클릭 시, 클릭한 버튼의 객체이다.

		System.out.println(e.getActionCommand());
		System.out.println(is_op[0]);
		
		if (!textField.getText().equals("0")) {
			
			if(is_op[0] == true) {
				textField.setText(textField.getText() + e.getActionCommand());
			} else {
				is_op[0] = true;
				textField.setText(e.getActionCommand());
			}
//			if (sa[0] == null || sa[0].equals("")) {
//				textField.setText(textField.getText() + e.getActionCommand());
//			} else {
//				sa[0] = "";
//				textField.setText(e.getActionCommand());
//			}
//			textField.setText(e.getActionCommand());
		} else {
			textField.setText(e.getActionCommand());
		}

	}

}

class t implements Actiontest {

	@Override
	public void Eventtest() {
		// TODO Auto-generated method stub

	}
}