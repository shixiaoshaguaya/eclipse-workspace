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

import com.wmsapp.dao.RecordDao;
import com.wmsapp.dao.StaffDao;
import com.wmsapp.model.Record;
import com.wmsapp.model.Staff;
import com.wmsapp.service.StaffService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetRecordFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRecordFrame frame = new GetRecordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void loadData() {
		RecordDao recordDao = new RecordDao();
		List<Record> recordList = null;
		try {
			recordList = recordDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] stuTableData = new Object[recordList.size()][5];
		int i = 0;
		for (Record record : recordList) {
			stuTableData[i][0] = record.getR_Date();
			stuTableData[i][1] = record.getG_ID();
			stuTableData[i][2] = record.getR_Number();
			stuTableData[i][3] = record.getS_ID();
			stuTableData[i][4] = record.getR_Type();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(stuTableData, new String[] { "时间", "货号", "数量", "员工号", "类别（出库/入库）" });
		table.setModel(model);// 将准备好的数据模型绑定显示到JTable控件
	}

	/**
	 * Create the frame.
	 */
	public GetRecordFrame() {
		setTitle("\u51FA\u5165\u5E93\u4FE1\u606F\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "时间", "货号", "数量", "员工号", "类别（出库/入库）" }));
		scrollPane.setViewportView(table);
	}

}
