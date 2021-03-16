package Ex1109;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Num extends JFrame {

	private JPanel contentPane;
	private JTextField textA;
	private JTextField textB;
	private JTextField textC;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Num frame = new Num();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Num() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5224\u65AD\u4E09\u89D2\u5F62");
		lblNewLabel.setBounds(156, 10, 71, 15);
		contentPane.add(lblNewLabel);
		
		textA = new JTextField();
		textA.setBounds(137, 35, 90, 21);
		contentPane.add(textA);
		textA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("a:");
		lblNewLabel_1.setBounds(79, 38, 27, 15);
		contentPane.add(lblNewLabel_1);
		
		textB = new JTextField();
		textB.setBounds(137, 78, 90, 21);
		contentPane.add(textB);
		textB.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("b:");
		lblNewLabel_2.setBounds(79, 81, 27, 15);
		contentPane.add(lblNewLabel_2);
		
		textC = new JTextField();
		textC.setBounds(137, 125, 90, 21);
		contentPane.add(textC);
		textC.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("c:");
		lblNewLabel_3.setBounds(79, 128, 27, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b,c;
				a = Integer.parseInt(textA.getText());
				b = Integer.parseInt(textB.getText());
				c = Integer.parseInt(textC.getText());
				if (a + b > c && b + c > a && c + a > b) {
					if (a == b || a == c || b == c) {
						if (a == b && b == c) {
//							System.out.println("等边三角形");
							text.setText("等边三角形");
						} else {
//							System.out.println("等腰三角形");
							text.setText("等腰三角形");
						}
					} else {
//						System.out.println("一般三角形");
						text.setText("一般三角形");
					}
				} else {
//					System.out.println("不构成三角形");
					text.setText("不构成三角形");
				}
			}
		});
		btnNewButton.setBounds(137, 162, 93, 23);
		contentPane.add(btnNewButton);
		
		text = new JTextField();
		text.setBounds(137, 206, 90, 21);
		contentPane.add(text);
		text.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7ED3\u679C");
		lblNewLabel_4.setBounds(79, 209, 27, 15);
		contentPane.add(lblNewLabel_4);
	}
}
