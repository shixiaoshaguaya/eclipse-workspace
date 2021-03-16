package guiapp.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import guiapp.pojo.Student;

public class DataSource {// 本类模拟数据源功能，提供数据的存储及增删改查功能接口
	
	private static List<Student> studentLst = new ArrayList<Student>();

	public static boolean add(Student student) {
		if (studentLst.add(student)) {
			return true;
		} else {
			return false;
		}
	}

	public static void clear() {
		studentLst.clear();
	}

	public static List<Student> getAll() {
		return studentLst;
	}
	
	public static boolean deleteByName(String name) {//根据姓名删除数据的方法
		boolean result=false;
		if(name==null || studentLst.size()==0) return result;
		Iterator<Student> it=studentLst.iterator();
		while(it.hasNext()) {//遍历整个列表
			Student stu=it.next();
			if(name.equals(stu.getName()))//判断当前记录的姓名是否与所要删除的条件一致
			{
				it.remove();//从列表中删除该记录
				result=true;
			}
		}
		return result;
	}
}
