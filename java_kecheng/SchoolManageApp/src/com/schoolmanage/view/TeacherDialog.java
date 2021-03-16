package com.schoolmanage.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.schoolmanage.service.TeacherService;
import com.schoolmanageapp.dao.TeacherDao;
import com.schoolmanageapp.model.Teacher;
import com.schoolmanageapp.model.TeacherLessonInfo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class TeacherDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCondition;
	private JTable table;
	protected String condition;
private List<Teacher> teacherList;
TeacherService tService=new TeacherService();
private JButton btSearch;
private JButton btAdd;
private JButton btDelete;
private JButton btEdit;
private JButton btExport;
private Teacher selectedTeacher=null;
private JPanel buttonPane;
public void SetButtonPaneVisible(boolean visible)
{buttonPane.setVisible(visible);
}
public void setSelectedTeacher(Teacher teacher) {
	this.selectedTeacher = teacher;
}
public Teacher getSelectedTeacher() {
	return this.selectedTeacher;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TeacherDialog dialog = new TeacherDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TeacherDialog(Frame owner) {// owner为打开该对话框的父窗体
		super(owner);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("\u6559\u5E08\u4FE1\u606F");
		setBounds(100, 100, 761, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u6761\u4EF6");
		JComboBox combCondition = new JComboBox();
		combCondition.setModel(new DefaultComboBoxModel(new String[] {"\u67E5\u8BE2\u5168\u90E8", "\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u804C\u79F0", "\u5B66\u9662"}));
		txtCondition = new JTextField();
		txtCondition.setColumns(10);
		btSearch = new JButton("\u67E5\u8BE2");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(combCondition.getSelectedIndex()>0 && txtCondition.getText().length()>0)
				{switch(combCondition.getSelectedIndex()) {
				case 1://工号
					condition=" t_id like '%"+txtCondition.getText()+"%'";
					break;
				case 2://姓名
					condition=" t_name like '%"+txtCondition.getText()+"%'";
					break;
				case 3://性别
					condition=" t_sex like '%"+txtCondition.getText()+"%'";
					break;
				case 4://职称
					condition=" t_professionaltitle like '%"+txtCondition.getText()+"%'";
					break;	
				case 5://学院
					condition=" t_department like '%"+txtCondition.getText()+"%'";
					break;	
				}					
				}
				btSearch.setEnabled(false);
				new Thread() {//数据库查询可能发生阻塞，可采用多线程技术解决界面无响应问题
			            public void run() {
			            	if(condition==null) {								
								try {
									teacherList=tService.getAll();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else
							{
								try {
									teacherList=tService.getAllByCondition(condition);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}			            	
			            	setTable(teacherList);			            
			            	btSearch.setEnabled(true);
			            }
			        }.start();
			}
		});
		btAdd = new JButton("\u589E\u52A0");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrame frm=new AddTeacherFrame(null);
				frm.setVisible(true);
			}
		});
		btDelete = new JButton("\u5220\u9664");
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除当前所选记录
				int rowIndex=table.getSelectedRow();			
				if(rowIndex >-1) {
					String selectedId=table.getValueAt(rowIndex, 0).toString();//获得记录编号
					if(!selectedId.equals("")) {
						if(JOptionPane.showConfirmDialog(TeacherDialog.this,"您确定要删除当前所选记录？（是/否）","提示",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
							btDelete.setEnabled(false);
							new Thread() {
					            public void run() {
					            	try {					            		
					            		if(tService.delete(selectedId))
					            		{
									btSearch.doClick();									
									}
					            	JOptionPane.showMessageDialog(TeacherDialog.this,"删除记录成功！","信息",JOptionPane.INFORMATION_MESSAGE);
									btDelete.setEnabled(true);									
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									};
									
					            }
					        }.start();
						}
						
					
					}
				}
			}
		});
		btEdit = new JButton("\u7F16\u8F91");
		btEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex=table.getSelectedRow();			
				if(rowIndex >-1) {
					String selectedId=table.getValueAt(rowIndex, 0).toString();//获得记录编号
					if(!selectedId.equals("")) {
						Teacher t=new Teacher();
						t.setId(selectedId);
						t.setName(table.getValueAt(rowIndex, 1).toString());
						t.setSex(table.getValueAt(rowIndex, 2).toString());
						SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
						try {
							t.setBirth(sdf.parse(table.getValueAt(rowIndex, 3).toString()));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						t.setProfessionalTitle(table.getValueAt(rowIndex, 4).toString());
						t.setDepartment(table.getValueAt(rowIndex, 5).toString());
						t.setSalary(Double.valueOf(table.getValueAt(rowIndex, 6).toString()));					
						AddTeacherFrame frm=new AddTeacherFrame(t);
						frm.setVisible(true);
					}
				}
			}
		});
		btExport = new JButton("\u5BFC\u51FA");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(combCondition, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtCondition, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btAdd, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btDelete, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btEdit, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btExport, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(label))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(combCondition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCondition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btSearch)
						.addComponent(btAdd)
						.addComponent(btDelete)
						.addComponent(btEdit)
						.addComponent(btExport))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setVisible(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");			
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//当前所选记录						
						int rowIndex=table.getSelectedRow();			
						if(rowIndex >-1) {						
							String id=table.getValueAt(rowIndex, 0).toString();//获得记录编号
							String name=table.getValueAt(rowIndex, 1).toString();//获得记录编号
							String sex=table.getValueAt(rowIndex, 2).toString();//获得记录编号
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date birth=null;
							try {
								birth = sdf.parse(table.getValueAt(rowIndex, 3).toString());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}//获得记录编号
							String professionalTitle=table.getValueAt(rowIndex, 4).toString();//获得记录编号
							String department=table.getValueAt(rowIndex, 5).toString();//获得记录编号
							Double salary=Double.valueOf(table.getValueAt(rowIndex, 6).toString());//获得记录编号
							selectedTeacher=new Teacher(id,name,sex,birth,professionalTitle,department,salary);
					}
						dispose();	
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selectedTeacher=null;
						dispose();	
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setTable(List<Teacher> tlList) {
		if(tlList!=null && tlList.size()>0 ) {						
			Object[][] tableData=new Object[tlList.size()][7];
			Iterator<Teacher> it=tlList.iterator();
			Teacher tl;
			int i=0;
			while(it.hasNext()) {
				tl=it.next();
				tableData[i][0]=tl.getId();
				tableData[i][1]=tl.getName();
				tableData[i][2]=tl.getSex();
				tableData[i][3]=tl.getBirth();
				tableData[i][4]=tl.getProfessionalTitle();
				tableData[i][5]=tl.getDepartment();
				tableData[i][6]=tl.getSalary();
				i=i+1;
			}											
			table.setModel(new DefaultTableModel(
					tableData,
					new String[] {
						"工号", "姓名", "性别", "出生日期", "职称", "学院", "工资"
					}
				));
	}else
	{
		table.removeAll();	
	}
	}
}
