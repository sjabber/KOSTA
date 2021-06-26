package test_2.src.test_2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class swing_day_04_30 {

   private JFrame frame;
//   private JPanel menu_0;
   private JLabel lblNewLabel;
   private String repo = "";

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	swing_day_04_30  window = new swing_day_04_30 ();
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
   public swing_day_04_30 () {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(370, 0, 450, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JPanel menu_0 = new JPanel();
      menu_0.setBackground(Color.ORANGE);
      menu_0.setBounds(36, 41, 364, 481);
      frame.getContentPane().add(menu_0);
      menu_0.setLayout(null);

      lblNewLabel = new JLabel("0");
      lblNewLabel.setForeground(Color.WHITE);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("³Ø½¼Lv1°íµñ", Font.BOLD, 20));
      lblNewLabel.setBounds(20, 10, 324, 48);
      menu_0.add(lblNewLabel);

      JButton num_7 = new JButton("7");
      num_7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_7.getText());
         }
      });
      num_7.setBounds(15, 100, 72, 69);
      menu_0.add(num_7);

      JButton num_8 = new JButton("8");
      num_8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_8.getText());
         }
      });
      num_8.setBounds(102, 100, 72, 69);
      menu_0.add(num_8);

      JButton num_9 = new JButton("9");
      num_9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_9.getText());
         }
      });
      num_9.setBounds(189, 100, 72, 69);
      menu_0.add(num_9);

      JButton devide = new JButton("/");
      devide.setBounds(276, 100, 72, 69);
      menu_0.add(devide);

      JButton num_4 = new JButton("4");
      num_4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_4.getText());
         }
      });
      num_4.setBounds(15, 191, 72, 69);
      menu_0.add(num_4);

      JButton num_5 = new JButton("5");
      num_5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_5.getText());
         }
      });
      num_5.setBounds(102, 191, 72, 69);
      menu_0.add(num_5);

      JButton num_6 = new JButton("6");
      num_6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_6.getText());
         }
      });
      num_6.setBounds(189, 191, 72, 69);
      menu_0.add(num_6);

      JButton multifly = new JButton("*");
      multifly.setBounds(276, 191, 72, 69);
      menu_0.add(multifly);

      JButton num_3 = new JButton("3");
      num_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_3.getText());
         }
      });
      num_3.setBounds(189, 287, 72, 69);
      menu_0.add(num_3);

      JButton substract = new JButton("-");
      substract.setBounds(276, 287, 72, 69);
      menu_0.add(substract);

      JButton num_1 = new JButton("1");
      num_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_1.getText());
         }
      });
      num_1.setBounds(15, 287, 72, 69);
      menu_0.add(num_1);

      JButton num_2 = new JButton("2");
      num_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_2.getText());
         }
      });
      num_2.setBounds(102, 287, 72, 69);
      menu_0.add(num_2);

      JButton equal = new JButton("=");
      equal.setBounds(102, 377, 159, 69);
      menu_0.add(equal);

      JButton add = new JButton("+");
      add.setBounds(276, 377, 72, 69);
      menu_0.add(add);

      JButton num_0 = new JButton("0");
      num_0.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            btn_event(num_0.getText());
         }
      });
      num_0.setBounds(15, 377, 72, 69);
      menu_0.add(num_0);
   }

   void btn_event(String text) {
      repo += text;
      lblNewLabel.setText(String.format("%,d", Long.parseLong(repo)));

   }
}