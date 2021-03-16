package com.schoolmanage.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.schoolmanageapp.model.User;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private User currentUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(null);
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
	public MainFrame(User loginedUser) {
		this.currentUser=loginedUser;
		setTitle("\u6559\u5B66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 365);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		
		JMenu menu = new JMenu("\u7CFB\u7EDF");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MainFrame.this,"您确定要退出教学管理系统？（是/否）","提示",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u57FA\u7840\u8D44\u6599");
		menuBar.add(menu_1);
		
		JMenu menu_6 = new JMenu("\u8BFE\u7A0B\u8D44\u6599");
		menu_1.add(menu_6);
		
		JMenuItem menuItem_1 = new JMenuItem("\u589E\u52A0\u8BFE\u7A0B");
		menu_6.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8BFE\u7A0B\u7BA1\u7406");
		menu_6.add(menuItem_2);
		
		JMenu menu_8 = new JMenu("\u73ED\u7EA7\u8D44\u6599");
		menu_1.add(menu_8);
		
		JMenuItem menuItem_10 = new JMenuItem("\u589E\u52A0\u73ED\u7EA7");
		menu_8.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		menu_8.add(menuItem_11);
		
		JMenu menu_7 = new JMenu("\u6559\u5E08\u8D44\u6599");
		menu_1.add(menu_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u589E\u52A0\u6559\u5E08");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrame frm=new AddTeacherFrame(null);
				frm.setAlwaysOnTop(true);
				frm.setVisible(true);
			}
		});
		menu_7.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("\u6559\u5E08\u7BA1\u7406");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDialog dlg=new TeacherDialog(MainFrame.this);		
				dlg.SetButtonPaneVisible(true);
				dlg.setModal(false);
				dlg.setVisible(true);
			}
		});
		menu_7.add(menuItem_9);
		
		JMenu menu_10 = new JMenu("\u5B66\u751F\u8D44\u6599");
		menu_1.add(menu_10);
		
		JMenuItem menuItem_14 = new JMenuItem("\u589E\u52A0\u5B66\u751F");
		menu_10.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("\u5B66\u751F\u7BA1\u7406");
		menu_10.add(menuItem_15);
		
		JMenu menu_2 = new JMenu("\u4EFB\u8BFE\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("\u4EFB\u8BFE\u767B\u8BB0");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTeacherLessonFrame frm=new AddTeacherLessonFrame(null);
				frm.setAlwaysOnTop(true);
				frm.setVisible(true);
			}
		});
		menu_2.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u4EFB\u8BFE\u67E5\u8BE2");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLessonFrame frm=new TeacherLessonFrame();
				frm.setAlwaysOnTop(true);
				frm.setVisible(true);
			}
		});
		menu_2.add(menuItem_6);
		
		JMenu menu_5 = new JMenu("\u6210\u7EE9\u7BA1\u7406");
		menuBar.add(menu_5);
		
		JMenuItem menuItem_3 = new JMenuItem("\u6210\u7EE9\u767B\u8BB0");
		menu_5.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6210\u7EE9\u67E5\u8BE2");
		menu_5.add(menuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbCurrentUser = new JLabel("\u5F53\u524D\u7528\u6237");
		lbCurrentUser.setHorizontalAlignment(SwingConstants.LEFT);
		if(currentUser!=null) {
		lbCurrentUser.setText("当前用户："+currentUser.getName());	
		}		
		contentPane.add(lbCurrentUser, BorderLayout.SOUTH);
		
	
	}

}
