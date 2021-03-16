package com.schoolmanage.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.schoolmanage.service.UserService;
import com.schoolmanageapp.dao.UserDao;
import com.schoolmanageapp.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginName;
	private JPasswordField txtPassword;

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
		setResizable(false);
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblv = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u6559\u5B66\u7BA1\u7406\u7CFB\u7EDFV1.0");
		
		JLabel label = new JLabel("\u7528\u6237\u540D\u79F0");
		
		txtLoginName = new JTextField();
		txtLoginName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u5BC6\u7801");
		
		JButton btOk = new JButton("\u786E\u5B9A");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String loginName=txtLoginName.getText();
			String password=String.valueOf(txtPassword.getPassword());
			UserService usrService=new UserService();
			User loginedUser;
			try {
				loginedUser = usrService.loginCheck(loginName, password);
				if(loginedUser!=null) {					
					JOptionPane.showMessageDialog(LoginFrame.this,"登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);				
					MainFrame frm=new MainFrame(loginedUser);
					LoginFrame.this.dispose();
					frm.setExtendedState(MAXIMIZED_BOTH);
					frm.setVisible(true);
				}else
				{JOptionPane.showMessageDialog(LoginFrame.this,"登录失败！请确认账号密码无误！", "提示", JOptionPane.ERROR_MESSAGE);
					txtLoginName.selectAll();
					txtLoginName.requestFocus();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		btOk.setIcon(new ImageIcon(LoginFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		
		JButton btCancel = new JButton("\u53D6\u6D88");
		btCancel.setIcon(new ImageIcon(LoginFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		
		txtPassword = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(btOk, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(lblv))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtPassword))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtLoginName, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblv)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtLoginName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btCancel)
						.addComponent(btOk))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
