package guiapp.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guiapp.data.UserDao;
import guiapp.pojo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLoginName;
	private JTextField txtPassword;
	private User loginedUser = null;// 用于记录登录成功的用户信息

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setTitle("\u767B\u5F55\u7A97\u4F53");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
			lblNewLabel.setBounds(154, 54, 126, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\u79F0");
			lblNewLabel_1.setBounds(102, 94, 54, 15);
			contentPanel.add(lblNewLabel_1);
		}

		txtLoginName = new JTextField();
		txtLoginName.setBounds(166, 91, 126, 21);
		contentPanel.add(txtLoginName);
		txtLoginName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u5BC6\u7801");
		lblNewLabel_2.setBounds(102, 134, 54, 15);
		contentPanel.add(lblNewLabel_2);

		txtPassword = new JTextField();
		txtPassword.setBounds(166, 131, 126, 21);
		contentPanel.add(txtPassword);
		txtPassword.setColumns(10);
		{
			JButton okButton = new JButton("\u767B\u5F55");
			okButton.setBounds(131, 176, 67, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = txtLoginName.getText();
					String password = txtPassword.getText();
					UserDao userDao = new UserDao();
					User user = userDao.login(name, password);
					if (user != null) {// 登录成功！
						setLoginedUser(user);
						JOptionPane.showMessageDialog(null, "登录成功！欢迎使用学生管理系统。", "信息", JOptionPane.INFORMATION_MESSAGE);
						LoginDialog.this.setVisible(false);
					}
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("\u9000\u51FA");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			cancelButton.setBounds(226, 176, 69, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
	}
	public User getLoginedUser() {
		return loginedUser;
	}
	
	public void setLoginedUser(User loginedUser) {
		this.loginedUser = loginedUser;
	}
}
