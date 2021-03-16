package com.schoolmanage.view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.schoolmanage.service.TeacherLessonService;
import com.schoolmanageapp.dao.ClassDao;
import com.schoolmanageapp.dao.CourseDao;
import com.schoolmanageapp.dao.TeacherLessonDao;
import com.schoolmanageapp.model.Course;
import com.schoolmanageapp.model.Teacher;
import com.schoolmanageapp.model.TeacherLesson;
import com.schoolmanageapp.model.TeacherLessonInfo;

import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddTeacherLessonFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseId;
	private JTextField txtCourseName;
	private JTextField txtClassName;
	private JTextField txtTeacherId;
	private JTextField txtTeacherName;
	private JTextField txtClassId;
	private JComboBox combPeriod;
	private JComboBox combCourse;
	private TeacherLessonInfo oldTLInfo;
	private int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherLessonFrame frame = new AddTeacherLessonFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initFrameData() throws Exception
	{//初始化界面所需的数据项：课程列表、学期列表
		combPeriod.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "16-17\u7B2C\u4E00\u5B66\u671F", "16-17\u7B2C\u4E8C\u5B66\u671F", "17-18\u7B2C\u4E00\u5B66\u671F", "17-18\u7B2C\u4E8C\u5B66\u671F", "18-19\u7B2C\u4E00\u5B66\u671F", "18-19\u7B2C\u4E8C\u5B66\u671F"}));
		CourseDao cDao=new CourseDao();
		List<Course> courseList=cDao.getAll();
		if(courseList!=null && courseList.size()>0) {
			String[] courseArray=new String[courseList.size()+1];
			int i=0;
			courseArray[i++]="请选择";
			for(Course c :courseList) {
				courseArray[i++]=c.getId()+"-"+c.getName();
			}
			combCourse.setModel(new DefaultComboBoxModel(courseArray));
		}	
	}
	/**
	 * Create the frame.
	 */
	public AddTeacherLessonFrame(TeacherLessonInfo tlInfo) {
		setResizable(false);
		this.oldTLInfo=tlInfo;
		setTitle("\u4EFB\u8BFE\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u4FE1\u606F");
		lblNewLabel.setBounds(15, 18, 62, 15);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");
		lblNewLabel_1.setBounds(15, 49, 62, 15);
		
		txtCourseId = new JTextField();
		txtCourseId.setBounds(87, 46, 100, 21);
		txtCourseId.setEditable(false);
		txtCourseId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		lblNewLabel_2.setBounds(197, 49, 48, 15);
		
		txtCourseName = new JTextField();
		txtCourseName.setBounds(255, 46, 158, 21);
		txtCourseName.setEditable(false);
		txtCourseName.setColumns(10);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u7F16\u53F7");
		label.setBounds(15, 93, 48, 15);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		label_2.setBounds(220, 93, 53, 15);
		
		txtClassName = new JTextField();
		txtClassName.setBounds(283, 90, 130, 21);
		txtClassName.setEditable(false);
		txtClassName.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u4FE1\u606F");
		label_3.setBounds(15, 134, 48, 15);
		
		JButton btTeacher = new JButton("\u8BF7\u9009\u62E9...");
		btTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDialog tDlg=new TeacherDialog(AddTeacherLessonFrame.this);
				tDlg.SetButtonPaneVisible(true);
				tDlg.setModal(true);
				tDlg.setVisible(true);
				Teacher t=tDlg.getSelectedTeacher();
				if(t!=null) {
				txtTeacherId.setText(t.getId());
				txtTeacherName.setText(t.getName());
				}
			}
		});
		btTeacher.setBounds(73, 130, 87, 23);
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u7F16\u53F7");
		label_4.setBounds(15, 166, 48, 15);
		
		txtTeacherId = new JTextField();
		txtTeacherId.setBounds(73, 163, 114, 21);
		txtTeacherId.setEditable(false);
		txtTeacherId.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6559\u5E08\u540D\u79F0");
		label_5.setBounds(197, 166, 48, 15);
		
		txtTeacherName = new JTextField();
		txtTeacherName.setBounds(255, 163, 158, 21);
		txtTeacherName.setEditable(false);
		txtTeacherName.setColumns(10);
		
		JButton btCancel = new JButton("\u53D6\u6D88");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btCancel.setBounds(356, 240, 57, 23);
		
		JButton btSave = new JButton("\u4FDD\u5B58");
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCourseName.getText().length()==0) {
					JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "课程信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				return;	
				}
				if(txtClassName.getText().length()==0)
					{JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "班级信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;}
					
				if(txtTeacherName.getText().length()==0)
					{JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "教师信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;}
				
				if(combPeriod.getSelectedIndex()==0)
					{JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "学期信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
					}
				
				//信息有效
				TeacherLesson tl=null;
				if(oldTLInfo!=null) {
					tl=new TeacherLesson(oldTLInfo.getId(),txtCourseId.getText(),txtClassId.getText(),txtTeacherId.getText(),combPeriod.getSelectedItem().toString());
				}
				else
				{tl=new TeacherLesson(0,txtCourseId.getText(),txtClassId.getText(),txtTeacherId.getText(),combPeriod.getSelectedItem().toString());
			}				
				TeacherLessonService tlService=new TeacherLessonService();
				try {				
					if(oldTLInfo!=null)
					{
						if(tlService.update(tl))
						{JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "任课修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);					
						}else
						{
							JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "任课修改失败！", "提示", JOptionPane.WARNING_MESSAGE);
						}
					}else
					{
						if(tlService.add(tl))
						{JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "任课登记成功！", "提示", JOptionPane.INFORMATION_MESSAGE);					
						}else
						{
							JOptionPane.showMessageDialog(AddTeacherLessonFrame.this, "任课登记失败！", "提示", JOptionPane.WARNING_MESSAGE);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btSave.setBounds(289, 240, 57, 23);
		
		combCourse = new JComboBox();
		combCourse.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(combCourse.getSelectedIndex()>0) {
					String selectedCourse=combCourse.getSelectedItem().toString();
					txtCourseId.setText(selectedCourse.substring(0, selectedCourse.indexOf("-")));
					txtCourseName.setText(selectedCourse.substring(selectedCourse.indexOf("-")+1));
				}else
				{
					txtCourseId.setText("");
					txtCourseName.setText("");
				}
			}
		});
		combCourse.setBounds(87, 15, 158, 21);
		
		txtClassId = new JTextField();
		txtClassId.setBounds(73, 90, 74, 21);
		txtClassId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u671F\u4FE1\u606F");
		lblNewLabel_3.setBounds(15, 213, 48, 15);
		
		combPeriod = new JComboBox();
		combPeriod.setBounds(73, 210, 172, 21);
		
		JButton btClassId = new JButton("\u8BFB\u53D6");
		btClassId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(txtClassId.getText());
				if(btClassId.getText().equals("更改")) {
					txtClassId.setText("");
					txtClassId.setEditable(true);
					txtClassName.setText("");
					btClassId.setText("读取");
					txtClassId.requestFocus();
					return;
				}
				if(txtClassId.getText().length()>0) {
					ClassDao clDao=new ClassDao();
					try {
						com.schoolmanageapp.model.Class cl=clDao.getById(txtClassId.getText());
						if(cl!=null)
						{
							txtClassName.setText(cl.getName());
							txtClassId.setEditable(false);
							btClassId.setText("更改");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btClassId.setBounds(153, 89, 67, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(combCourse);
		contentPane.add(lblNewLabel_1);
		contentPane.add(txtCourseId);
		contentPane.add(lblNewLabel_2);
		contentPane.add(txtCourseName);
		contentPane.add(label);
		contentPane.add(txtClassId);
		contentPane.add(btClassId);
		contentPane.add(label_2);
		contentPane.add(txtClassName);
		contentPane.add(btSave);
		contentPane.add(btCancel);
		contentPane.add(label_3);
		contentPane.add(btTeacher);
		contentPane.add(lblNewLabel_3);
		contentPane.add(combPeriod);
		contentPane.add(label_4);
		contentPane.add(txtTeacherId);
		contentPane.add(label_5);
		contentPane.add(txtTeacherName);
		try {
			initFrameData();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(oldTLInfo!=null) {//编辑资料情况
			id=oldTLInfo.getId();
			txtCourseId.setText(oldTLInfo.getCourseId());
			txtCourseName.setText(oldTLInfo.getCourseName());
			txtClassId.setText(oldTLInfo.getClassId());
			txtClassName.setText(oldTLInfo.getClassName());
			txtTeacherId.setText(oldTLInfo.getTeacherId());
			txtTeacherName.setText(oldTLInfo.getTeacherName());
			combPeriod.setSelectedItem(oldTLInfo.getPeriod());
			txtClassId.setEditable(false);
			btClassId.setText("更改");
			setTitle("任课修改");
		}
		
	}
}
