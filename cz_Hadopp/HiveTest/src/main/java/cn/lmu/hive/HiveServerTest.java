package cn.lmu.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
*
* 使用JDBC协议连接HiveServer测试类
*/
public class HiveServerTest {
	// 连接
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 测试前准备工作
	 */
	@Before
	public void before() {
		try {
			// Hive的JDBC驱动
			String classDriver = "org.apache.hive.jdbc.HiveDriver";
			// 连接串,接数据库名mydb,数据库写你你要访问的Hive数据仓库中数据库名称
			String url = "jdbc:hive2://192.168.139.130:10000/hdb";
			// 加载驱动
			Class.forName(classDriver);
			// 获得连接
			connection = DriverManager.getConnection(url, "cz", "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向表中增加数据
	 */
//	@Test
	public void testInsert() {
		try {
			// 表和数据需要提前准备好
			String sql = "insert into htest(name,age) values('keti',18)";
			// 执行SQL语句
			ps = connection.prepareStatement(sql);
			// 提交执行
			ps.execute();
			System.out.println("OK!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询表中的数据
	 */
	@Test
	public void testSelect() {
		try {
			// 表和数据需要提前准备好
			String sql = "select * from htest";
			// 执行SQL语句
			ps = connection.prepareStatement(sql);
			// 得到结果集
			rs = ps.executeQuery();
			// 遍历结果集
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试结束后关闭连接
	 */
	@After
	public void after() {
		try {
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
