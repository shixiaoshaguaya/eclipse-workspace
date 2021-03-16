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

import com.wmsapp.dao.GoodsDao;
import com.wmsapp.model.Goods;


public class GetGoodsFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetGoodsFrame frame = new GetGoodsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void loadData() {
		GoodsDao goodsDao = new GoodsDao();
		List<Goods> staffList = null;
		try {
			staffList = goodsDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] stuTableData = new Object[staffList.size()][5];
		int i = 0;
		for (Goods goods: staffList) {
			stuTableData[i][0] = goods.getG_ID();
			stuTableData[i][1] = goods.getG_Name();
			stuTableData[i][2] = goods.getG_Price();
			stuTableData[i][3] = goods.getG_Number();
			stuTableData[i][4] = goods.getG_Factory();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(stuTableData, new String[] { "货号", "名称", "单价", "数量", "生产商" });
		table.setModel(model);// 将准备好的数据模型绑定显示到JTable控件
	}

	/**
	 * Create the frame.
	 */
	public GetGoodsFrame() {
		setTitle("\u8D27\u7269\u4FE1\u606F\u68C0\u7D22");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "货号", "名称", "单价", "数量", "生产商" }));
		scrollPane.setViewportView(table);
	}
}
