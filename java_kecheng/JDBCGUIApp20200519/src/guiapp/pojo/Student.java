package guiapp.pojo;
import java.util.Date;
//瀛︾敓淇℃伅绫�
public class Student {
private Integer id;//缂栧彿
	private String name;// 濮撳悕
	private String sex;// 鎬у埆
	private String collage;// 鎵�灞炲闄�
	private Date birthday;// 鍑虹敓鏃ユ湡

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Student() {
		super();
	}

	public Student(Integer id,String name, String sex, String collage, Date birthday) {
		super();
		this.id=id;
		this.name = name;
		this.sex = sex;
		this.collage = collage;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", collage=" + collage + ", birthday=" + birthday + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
