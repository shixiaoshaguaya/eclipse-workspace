package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wmsapp.dao.UserDao;
import com.wmsapp.model.User;
import com.wmsapp.service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginName;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF1.0");
		lblNewLabel.setBounds(145, 37, 144, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\u79F0");
		lblNewLabel_1.setBounds(95, 70, 54, 15);
		contentPane.add(lblNewLabel_1);

		txtLoginName = new JTextField();
		txtLoginName.setBounds(157, 67, 132, 21);
		contentPane.add(txtLoginName);
		txtLoginName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u5BC6\u7801");
		lblNewLabel_2.setBounds(95, 101, 54, 15);
		contentPane.add(lblNewLabel_2);

		txtPassword = new JTextField();
		txtPassword.setBounds(157, 98, 132, 21);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btOk = new JButton("\u767B\u5F55");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginName = txtLoginName.getText();
				String password = txtPassword.getText();
				UserService userService = new UserService();
				User loginedUser = null;
				try {
					loginedUser = userService.loginCheck(loginName, password);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (loginedUser != null) {
					JOptionPane.showMessageDialog(LoginFrame.this, "登录成功!欢迎使用仓库管理系统", "提示", JOptionPane.INFORMATION_MESSAGE);
					MainFrame frm = new MainFrame();
					LoginFrame.this.dispose();
					frm.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(LoginFrame.this, "登录失败！", "提示", JOptionPane.ERROR_MESSAGE);
					txtLoginName.selectAll();
					txtLoginName.requestFocus();
				}
			}
		});
		btOk.setBounds(95, 144, 93, 23);
		contentPane.add(btOk);

		JButton btCancel = new JButton("\u9000\u51FA");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btCancel.setBounds(196, 144, 93, 23);
		contentPane.add(btCancel);

		JLabel lblNewLabel_3 = new JLabel("1905230340 \u9648\u5586");
		lblNewLabel_3.setBounds(293, 225, 99, 15);
		contentPane.add(lblNewLabel_3);
	}
}
