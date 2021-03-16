package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wmsapp.dao.StaffDao;
import com.wmsapp.model.Staff;
import com.wmsapp.service.StaffService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStaffFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtTelephone;
	private JTextField txtAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radbtMale;
	private JRadioButton radbtFeamale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaffFrame frame = new AddStaffFrame();
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
	public AddStaffFrame() {
		setTitle("\u5458\u5DE5\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u65B0\u5458\u5DE5\u4FE1\u606F\u767B\u8BB0");
		lblNewLabel.setBounds(125, 10, 84, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5458 \u5DE5 \u53F7");
		lblNewLabel_1.setBounds(41, 46, 54, 15);
		contentPane.add(lblNewLabel_1);

		txtID = new JTextField();
		txtID.setBounds(125, 43, 112, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u59D3    \u540D");
		lblNewLabel_2.setBounds(41, 100, 54, 15);
		contentPane.add(lblNewLabel_2);

		txtName = new JTextField();
		txtName.setBounds(125, 97, 112, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u6027    \u522B");
		lblNewLabel_3.setBounds(41, 154, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		lblNewLabel_4.setBounds(41, 208, 54, 15);
		contentPane.add(lblNewLabel_4);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(125, 205, 112, 21);
		contentPane.add(txtTelephone);
		txtTelephone.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u5730    \u5740");
		lblNewLabel_5.setBounds(41, 262, 54, 15);
		contentPane.add(lblNewLabel_5);

		txtAddress = new JTextField();
		txtAddress.setBounds(125, 259, 112, 21);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JButton btnOk = new JButton("\u767B\u8BB0");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtID.getText().length()==0) {
					JOptionPane.showConfirmDialog(AddStaffFrame.this, "登记失败，员工号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtName.getText().length()==0) {
					JOptionPane.showConfirmDialog(AddStaffFrame.this, "登记失败，姓名信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtTelephone.getText().length() != 0) {
					if (!(txtTelephone.getText().length() == 7 || txtTelephone.getText().length() == 11)) {
						JOptionPane.showConfirmDialog(AddStaffFrame.this, "登记失败，电话号码信息不为7或12位！", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				String id, name, address, gender, telephone;
				id = txtID.getText();
				name = txtName.getText();
				if (radbtMale.isSelected()) {
					gender = "男";
				} else {
					gender = "女";
				}
				address = txtAddress.getText();
				telephone = txtTelephone.getText();
				StaffService staffService = new StaffService();
				Staff staff = new Staff(id, name, address, gender, telephone);
				boolean add = false;
				try {
					add = staffService.add(staff);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (add != false) {
					JOptionPane.showMessageDialog(AddStaffFrame.this, "登记成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(AddStaffFrame.this, "登记失败！", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnOk.setBounds(41, 303, 93, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("\u9000\u51FA");
		btnCancel.setBounds(166, 303, 93, 23);
		contentPane.add(btnCancel);
		
		radbtMale = new JRadioButton("\u7537");
		buttonGroup.add(radbtMale);
		radbtMale.setSelected(true);
		radbtMale.setBounds(125, 150, 54, 23);
		contentPane.add(radbtMale);
		
		radbtFeamale = new JRadioButton("\u5973");
		buttonGroup.add(radbtFeamale);
		radbtFeamale.setBounds(181, 150, 54, 23);
		contentPane.add(radbtFeamale);
	}
	public JRadioButton getRdbtnNewRadioButton() {
		return radbtMale;
	}
	public JRadioButton getRdbtnNewRadioButton_1() {
		return radbtFeamale;
	}
}
