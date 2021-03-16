package com.schoolmanage.view;

import java.awt.BorderLayout;
import com.schoolmanageapp.model.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.schoolmanage.service.TeacherLessonService;
import com.schoolmanageapp.dao.TeacherLessonDao;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TeacherLessonFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCondition;
	private JTable table;
	TeacherLessonService tlService=new TeacherLessonService();
	List<TeacherLessonInfo> tlList=null;
	String condition=null;
	private JButton btSearch;
	private TableModel tModel=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLessonFrame frame = new TeacherLessonFrame();
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
	public TeacherLessonFrame() {
		setTitle("\u4EFB\u8BFE\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u6761\u4EF6");
		
		JComboBox combCondition = new JComboBox();
		combCondition.setModel(new DefaultComboBoxModel(new String[] {"\u663E\u793A\u5168\u90E8", "\u8BFE\u7A0B\u540D\u79F0", "\u73ED\u7EA7\u540D\u79F0", "\u6559\u5E08\u540D\u79F0", "\u5B66\u671F\u540D\u79F0"}));
		
		txtCondition = new JTextField();
		txtCondition.setColumns(10);
		
		JButton button = new JButton("\u7F16\u8F91");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex=table.getSelectedRow();			
				if(rowIndex >-1) {
					String selectedId=table.getValueAt(rowIndex, 0).toString();//获得记录编号
					if(!selectedId.equals("")) {
						TeacherLessonInfo tlInfo=new TeacherLessonInfo();
						tlInfo.setId(Integer.valueOf(selectedId));
						tlInfo.setCourseId(table.getValueAt(rowIndex, 1).toString());
						tlInfo.setCourseName(table.getValueAt(rowIndex, 2).toString());
						tlInfo.setClassId(table.getValueAt(rowIndex, 3).toString());
						tlInfo.setClassName(table.getValueAt(rowIndex, 4).toString());
						tlInfo.setTeacherId(table.getValueAt(rowIndex, 5).toString());
						tlInfo.setTeacherName(table.getValueAt(rowIndex, 6).toString());
						tlInfo.setPeriod(table.getValueAt(rowIndex, 7).toString());
						AddTeacherLessonFrame tlFrm=new AddTeacherLessonFrame(tlInfo);
						tlFrm.setVisible(true);
					}
				}
			}
		});
		
		JButton btDelete = new JButton("\u5220\u9664");
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//删除当前所选记录
				int rowIndex=table.getSelectedRow();			
				if(rowIndex >-1) {
					String selectedId=table.getValueAt(rowIndex, 0).toString();//获得记录编号
					if(!selectedId.equals("")) {
						if(JOptionPane.showConfirmDialog(TeacherLessonFrame.this,"您确定要删除当前所选记录？（是/否）","提示",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
							btDelete.setEnabled(false);
							new Thread() {
					            public void run() {
					            	try {					            		
					            		if(tlService.delete(Integer.valueOf(selectedId)))
					            		{
									btSearch.doClick();									
									}
					            	JOptionPane.showMessageDialog(TeacherLessonFrame.this,"删除记录成功！","信息",JOptionPane.INFORMATION_MESSAGE);
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
		
		JButton btAdd = new JButton("\u589E\u52A0");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTeacherLessonFrame addTeacherFrm=new AddTeacherLessonFrame(null);
				addTeacherFrm.setVisible(true);
			}
		});
		
		btSearch = new JButton("\u67E5\u8BE2");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				if(combCondition.getSelectedIndex()>0 && txtCondition.getText().length()>0)
				{switch(combCondition.getSelectedIndex()) {
				case 1://课程名称
					condition=" c_name like '%"+txtCondition.getText()+"%'";
					break;
				case 2://班级名称
					condition=" class_name like '%"+txtCondition.getText()+"%'";
					break;
				case 3://教师名称
					condition=" t_name like '%"+txtCondition.getText()+"%'";
					break;
				case 4://学期名称
					condition=" period like '%"+txtCondition.getText()+"%'";
					break;				
				}					
				}
				btSearch.setEnabled(false);
				new Thread() {//数据库查询可能发生阻塞，可采用多线程技术解决界面无响应问题
			            public void run() {
			            	if(condition==null) {								
								try {
									tlList=tlService.getAllInfo();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else
							{
								try {
									tlList=tlService.getAllInfoByCondition(condition);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}			            	
			            	setTable2(tlList);			            
			            	btSearch.setEnabled(true);
			            }
			        }.start();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_4 = new JButton("\u5BFC\u51FA");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(combCondition, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCondition, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btSearch)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btAdd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_4)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(combCondition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCondition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btSearch)
						.addComponent(button_4)
						.addComponent(button)
						.addComponent(btDelete)
						.addComponent(btAdd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			null,
			new String[] {
				"编号", "课程编号", "课程名称", "班级编号", "班级名称", "教师编号", "教师名称", "学期名称"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	public void setTable(List<TeacherLessonInfo> tlList) {
		if(tlList!=null && tlList.size()>0 ) {						
			Object[][] tableData=new Object[tlList.size()][8];
			Iterator<TeacherLessonInfo> it=tlList.iterator();
			TeacherLessonInfo tl;
			int i=0;
			while(it.hasNext()) {
				tl=it.next();
				tableData[i][0]=tl.getId();
				tableData[i][1]=tl.getCourseId();
				tableData[i][2]=tl.getCourseName();
				tableData[i][3]=tl.getClassId();
				tableData[i][4]=tl.getClassName();
				tableData[i][5]=tl.getTeacherId();
				tableData[i][6]=tl.getTeacherName();
				tableData[i][7]=tl.getPeriod();
				i=i+1;
			}	
			
			table.setModel(new DefaultTableModel(
					tableData,
					new String[] {
						"编号", "课程编号", "课程名称", "班级编号", "班级名称", "教师编号", "教师名称", "学期名称"
					}
				));
	}else
	{
		
	}
	}
	public void setTable2(List<TeacherLessonInfo> tlList) {
		System.out.println("OK");
		if(tlList!=null && tlList.size()>0 ) {						
		Vector columnNames=new Vector();
		columnNames.add("编号");
		columnNames.add("课程编号");
		columnNames.add("课程名称");
		columnNames.add("班级编号");
		columnNames.add("班级名称");
		columnNames.add("教师编号");
		columnNames.add("教师名称");
		columnNames.add("学期名称");
			Vector tableData=new Vector();
			Iterator<TeacherLessonInfo> it=tlList.iterator();
			TeacherLessonInfo tl;
			int i=0;
			while(it.hasNext()) {
				tl=it.next();
				Vector row=new Vector();
				row.add(tl.getId());
				row.add(tl.getCourseId());
				row.add(tl.getCourseName());
				row.add(tl.getClassId());
				row.add(tl.getClassName());
				row.add(tl.getTeacherId());
				row.add(tl.getTeacherName());
				row.add(tl.getPeriod());
				tableData.add(row);
			}
			tModel=new DefaultTableModel(tableData,columnNames);
			table.setModel(tModel);
	}else
	{
		
	}
	}
}
