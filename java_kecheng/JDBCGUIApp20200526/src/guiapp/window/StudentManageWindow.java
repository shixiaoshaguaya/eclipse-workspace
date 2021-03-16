package guiapp.window;

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

import guiapp.data.DataSource;
import guiapp.data.StudentDao;
import guiapp.pojo.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentManageWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageWindow frame = new StudentManageWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadData(){
		StudentDao stuDao = new StudentDao();
		List<Student> stuLst = stuDao.getAll();
		Object[][] stuTableData = new Object[stuLst.size()][5];
		int i = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		for (Student stu : stuLst) {
			stuTableData[i][0] = stu.getId();
			stuTableData[i][1] = stu.getName();
			stuTableData[i][2] = stu.getSex();
			stuTableData[i][3] = stu.getCollage();
			stuTableData[i][4] = sdf.format(stu.getBirthday());
			i++;
		}
		DefaultTableModel model =new DefaultTableModel(stuTableData, new String[] {"编号","姓名","性别","所属学院","出生日期"});
		table.setModel(model);//将准备好的数据模型绑定显示到JTable控件
	}
	/**
	 * Create the frame.
	 */
	public StudentManageWindow() {
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
				//读取数据显示JTable
				StudentManageWindow.this.loadData();
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u7F16\u8F91\u5458\u5DE5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex=table.getSelectedRow();
				if (rowIndex>-1) {
					Integer id=Integer.parseInt(table.getValueAt(rowIndex, 0).toString());
					if (id!=null) {
						StudentDao stuDao=new StudentDao();
						Student student=stuDao.getById(id);
						StudentEditDialog studentEditDialog=new StudentEditDialog(student);
						studentEditDialog.setModalityType(ModalityType.APPLICATION_MODAL);
						studentEditDialog.setVisible(true);
						loadData();
					}
				}
			}
		});
		panel.add(button);

		JButton button_1 = new JButton("\u5220\u9664\u5458\u5DE5");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//单击按钮时删除表格所选记录
				int rowIndex=table.getSelectedRow();//获取表格选中行
				
				//表格有选中行，则删除
				if(rowIndex>-1)
				{
					Integer id=Integer.parseInt(table.getValueAt(rowIndex, 0).toString());
					if(id!=null&&JOptionPane.showConfirmDialog(null, "您确定要删除编号为"+id+"的记录？(是/否)","提示",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						StudentDao stuDao=new StudentDao();
						stuDao.deleteById(id);
						StudentManageWindow.this.loadData();
					}
				}
			}
		});
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[]{"编号","姓名", "性别", "所属学院", "出生日期"}
		));
		scrollPane.setViewportView(table);
	}

}
