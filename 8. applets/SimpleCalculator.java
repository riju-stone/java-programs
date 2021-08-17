import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class SimpleCalculator {

	private JFrame frame;
	private JTextField textR;
	double n1;
	double n2;
	double result;
	String Op;
	String Ans;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator window = new SimpleCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimpleCalculator() {
		initialize();
	}

	private void initialize() {
		Color lightGreen = new Color(172, 255, 193);
		Color lightBlue = new Color(172, 234, 255);
		Color dG = new Color(32, 33, 33);
		frame = new JFrame();
		frame.isResizable();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(dG);
		frame.setBounds(100, 100, 370, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textR = new JTextField();
		textR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textR.setForeground(Color.BLACK);
		textR.setBackground(Color.white);
		textR.setHorizontalAlignment(SwingConstants.RIGHT);
		textR.setBounds(15, 15, 327, 80);
		frame.getContentPane().add(textR);
		textR.setColumns(10);

		/// ---------ROW 1-------------
		JButton btnAC = new JButton("CLEAR");
		btnAC.setBackground(Color.RED);
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textR.setText(null);
			}
		});

		btnAC.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAC.setBorder(null);
		btnAC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAC.setForeground(new Color(255, 255, 255));
		btnAC.setBounds(15, 105, 158, 70);
		frame.getContentPane().add(btnAC);

		JButton btnOps = new JButton("+/-");
		btnOps.setBackground(lightGreen);
		btnOps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textR.getText()));
				ops = ops * (-1);
				textR.setText(String.valueOf(ops));

			}
		});
		btnOps.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOps.setBounds(185, 105, 70, 70);
		frame.getContentPane().add(btnOps);

		JButton btnD = new JButton("/");
		btnD.setBackground(lightGreen);

		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textR.getText());
				textR.setText("");
				Op = "/";

			}
		});
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnD.setBounds(270, 105, 70, 70);
		frame.getContentPane().add(btnD);
		// -----------ROW 2------------
		JButton btn7 = new JButton("7");
		btn7.setBackground(lightBlue);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn7.getText();
				textR.setText(EnterNumber);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn7.setBounds(15, 185, 70, 70);
		frame.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setBackground(lightBlue);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn8.getText();
				textR.setText(EnterNumber);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn8.setBounds(100, 185, 70, 70);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBackground(lightBlue);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn9.getText();
				textR.setText(EnterNumber);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn9.setBounds(185, 185, 70, 70);
		frame.getContentPane().add(btn9);

		JButton btnMulti = new JButton("*");
		btnMulti.setBackground(lightGreen);

		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textR.getText());
				textR.setText("");
				Op = "*";

			}
		});
		btnMulti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMulti.setBounds(270, 185, 70, 70);
		frame.getContentPane().add(btnMulti);

		// -----------ROW 3------------

		JButton btn4 = new JButton("4");
		btn4.setBackground(lightBlue);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn4.getText();
				textR.setText(EnterNumber);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn4.setBounds(15, 270, 70, 70);
		frame.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBackground(lightBlue);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn5.getText();
				textR.setText(EnterNumber);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn5.setBounds(100, 270, 70, 70);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setBackground(lightBlue);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn6.getText();
				textR.setText(EnterNumber);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn6.setBounds(185, 270, 70, 70);
		frame.getContentPane().add(btn6);

		JButton btnSub = new JButton("-");
		btnSub.setBackground(lightGreen);

		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textR.getText());
				textR.setText("");
				Op = "-";

			}
		});
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSub.setBounds(270, 270, 70, 70);
		frame.getContentPane().add(btnSub);

		// -----------ROW 4------------
		JButton btn1 = new JButton("1");
		btn1.setBackground(lightBlue);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn1.getText();
				textR.setText(EnterNumber);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn1.setBounds(15, 355, 70, 70);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setBackground(lightBlue);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn2.getText();
				textR.setText(EnterNumber);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.setBounds(100, 355, 70, 70);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBackground(lightBlue);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn3.getText();
				textR.setText(EnterNumber);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn3.setBounds(185, 355, 70, 70);
		frame.getContentPane().add(btn3);

		JButton btnAdd = new JButton("+");
		btnAdd.setBackground(lightGreen);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textR.getText());
				textR.setText("");
				Op = "+";

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(270, 355, 70, 70);
		frame.getContentPane().add(btnAdd);

		// -----------ROW 5------------
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textR.getText() + btn0.getText();
				textR.setText(EnterNumber);
			}

		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn0.setBounds(15, 435, 155, 70);
		btn0.setBackground(lightBlue);
		frame.getContentPane().add(btn0);

		JButton btnP = new JButton(".");
		btnP.setBackground(lightBlue);
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textR.getText().contains(".")) {
					textR.setText(textR.getText() + btnP.getText());
				}
			}

		});
		btnP.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnP.setBounds(185, 435, 70, 70);
		frame.getContentPane().add(btnP);

		JButton btnE = new JButton("=");
		btnE.setBackground(lightGreen);

		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n2 = Double.parseDouble(textR.getText());
				if (Op == "+") {
					result = n1 + n2;
					Ans = String.format("%.2f", result);
					textR.setText(Ans);

				}
				if (Op == "-") {
					result = n1 - n2;
					Ans = String.format("%.2f", result);
					textR.setText(Ans);

				}
				if (Op == "*") {
					result = n1 * n2;
					Ans = String.format("%.2f", result);
					textR.setText(Ans);

				}
				if (Op == "/") {
					result = n1 / n2;
					Ans = String.format("%.4f", result);
					textR.setText(Ans);

				}

			}
		});
		btnE.setForeground(Color.BLACK);
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnE.setBounds(270, 435, 70, 70);
		frame.getContentPane().add(btnE);
	}
}