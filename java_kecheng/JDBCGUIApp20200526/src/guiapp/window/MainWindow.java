package guiapp.window;

import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import guiapp.pojo.Student;
import guiapp.pojo.User;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void show() {
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // 绐椾綋鏈�澶у寲
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		LoginDialog loginDialog = new LoginDialog();
		loginDialog.setModalityType(ModalityType.APPLICATION_MODAL);
		loginDialog.setVisible(true);
		User user = loginDialog.getLoginedUser();
		if (user != null) {
			// 登录成功
			currentUser = user;
		}else {
			System.exit(0);// 退出程序
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u7CFB\u7EDF");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(MainWindow.this.frame, "您确定要退出程序吗？(是／否)", "提示",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		menu.add(menuItem);

		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(menu_1);

		JMenuItem menuItem_1 = new JMenuItem("\u5B66\u751F\u6CE8\u518C");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRegWindow studentRegWindow = new StudentRegWindow();
				studentRegWindow.show();
			}
		});
		menu_1.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u4FE1\u606F\u68C0\u7D22");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//显示学生信息检索窗体
				StudentManageWindow studentManageWindow=new StudentManageWindow();
				studentManageWindow.show();
			}
		});
		menu_1.add(menuItem_2);
	}

}
