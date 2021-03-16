package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wmsapp.dao.StaffDao;
import com.wmsapp.model.Staff;
import com.wmsapp.service.StaffService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffFrame frame = new StaffFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadData() {
		StaffDao staffDao = new StaffDao();
		List<Staff> staffList = null;
		try {
			staffList = staffDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] stuTableData = new Object[staffList.size()][5];
		int i = 0;
		for (Staff staff : staffList) {
			stuTableData[i][0] = staff.getS_ID();
			stuTableData[i][1] = staff.getS_Name();
			stuTableData[i][2] = staff.getS_Gender();
			stuTableData[i][3] = staff.getS_Telephone();
			stuTableData[i][4] = staff.getS_Address();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(stuTableData, new String[] { "员工号", "姓名", "性别", "电话号码", "地址" });
		table.setModel(model);// 将准备好的数据模型绑定显示到JTable控件
	}

	/**
	 * Create the frame.
	 */
	public StaffFrame() {
		setTitle("\u5458\u5DE5\u4FE1\u606F\u68C0\u7D22");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnNewButton = new JButton("\u8BFB\u53D6\u6570\u636E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 读取数据显示JTable
				StaffFrame.this.loadData();
			}
		});
		panel.add(btnNewButton);

		JButton button = new JButton("\u7F16\u8F91\u5458\u5DE5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 编辑
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					String id = table.getValueAt(rowIndex, 0).toString();
					if (!id.equals("")) {
						StaffService staffService=new StaffService();
						Staff staff = null;
						try {
							staff = staffService.getById(id);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						UpdataStaffFrame uFrame = new UpdataStaffFrame(staff);
						uFrame.setVisible(true);
						loadData();
					}
				}
			}
		});
		panel.add(button);

		JButton button_1 = new JButton("\u5220\u9664\u5458\u5DE5");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					String id=table.getValueAt(rowIndex, 0).toString();
					if(!id.equals("")) {
					if (JOptionPane.showConfirmDialog(null, "您确定要删除当前所选记录？(是/否)", "提示",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						StaffService staffService = new StaffService();
						try {
							staffService.delete(id);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						StaffFrame.this.loadData();
					}
				}
				}
			}
		});
		panel.add(button_1);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "员工号", "姓名", "性别", "电话号码", "地址" }));
		scrollPane.setViewportView(table);
	}

}
