package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
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
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdataStaffFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtTelephone;
	private JTextField txtAddress;

	private Staff staff = null;

	/**
	 * ��ʼ��Ҫ�༭��Ա������������༭�ؼ�
	 */
	public void initData(Staff staff) {
		if (staff != null) {
			txtID.setText(staff.getS_ID());
			txtName.setText(staff.getS_Name());
			txtGender.setText(staff.getS_Gender());
			txtTelephone.setText(staff.getS_Telephone());
			txtAddress.setText(staff.getS_Address());
			this.staff = staff;
		}
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdataStaffFrame frame = new UpdataStaffFrame(staff);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdataStaffFrame(Staff staff) {
		
		setTitle("\u5458\u5DE5\u8D44\u6599\u7F16\u8F91");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5458 \u5DE5 \u53F7");
		lblNewLabel.setBounds(30, 25, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u59D3    \u540D");
		lblNewLabel_1.setBounds(30, 61, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u6027    \u522B");
		lblNewLabel_2.setBounds(30, 96, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		lblNewLabel_3.setBounds(30, 134, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u5730    \u5740");
		lblNewLabel_4.setBounds(30, 172, 54, 15);
		contentPane.add(lblNewLabel_4);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(94, 22, 118, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(94, 58, 118, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtGender = new JTextField();
		txtGender.setBounds(94, 93, 118, 21);
		contentPane.add(txtGender);
		txtGender.setColumns(10);

		txtTelephone = new JTextField();
		txtTelephone.setBounds(94, 131, 118, 21);
		contentPane.add(txtTelephone);
		txtTelephone.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(94, 169, 118, 21);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, name, address, gender, telephone;
				id = txtID.getText();
				name = txtName.getText();
				gender = txtGender.getText();
				address = txtAddress.getText();
				telephone = txtTelephone.getText();
				staff.setS_ID(id);
				staff.setS_Name(name);
				staff.setS_Gender(gender);
				staff.setS_Address(address);
				staff.setS_Telephone(telephone);
				StaffService staffService = new StaffService();
					try {
						if (staffService.update(staff)) {
							JOptionPane.showMessageDialog(null, "��ϲ���޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "�ź����޸�ʧ�ܣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(128, 217, 64, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(208, 217, 64, 23);
		contentPane.add(btnNewButton_1);
		initData(staff);
	}
}
