package cn.lmu.hadoop.hdfs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.httpclient.URIException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Test;

public class HdfsClient {
//	@Test
//	public void testMkdirs() throws IOException, InterruptedException, URIException, URISyntaxException {
//		// 1 获取文件系统
//		Configuration configuration = new Configuration();
//		// 配置在集群上运行
//		// configuration.set("fs.defaultFS", "hdfs://server102:9000");
//		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");
//		// 2 创建目录
//		fs.mkdirs(new Path("/user/bigdata/sanguo"));
//		// 3 关闭资源
//		fs.close();
//	}

//	HDFS文件上传
//	@Test
	public void testCopyFromLocalFile() throws IOException, InterruptedException, URISyntaxException { // 1 ��ȡ�ļ�ϵͳ
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.replication", "2");
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");
		// 2 上传文件
		fs.copyFromLocalFile(new Path("E:/.Workspace/Hadoop/Hadopp_bigdata/liubei.txt"), new Path("/liubei.txt"));
		// 3 关闭资源
		fs.close();
		System.out.println("over");
	}

//	HDFS文件存在判断
//	@Test
	public void testMkdirs() throws IOException, InterruptedException, URISyntaxException {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");
		// 2 创建目录
		String filePath = "/liubei.txt";
		if (fs.exists(new Path(filePath))) {
			System.out.println("文件存在");
		} else {
			System.out.println("文件不存在！");
		}
		// 3 关闭资源
		fs.close();
	}

//	HDFS文件下载
//	@Test
	public void testCopyToLocalFile() throws IOException, InterruptedException, URISyntaxException {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");

		// 2 执行下载操作
		// boolean delSrc 指是否将原文件删除
		// Path src 指要下载的文件路径
		// Path dst 指将文件下载到的路径
		// boolean useRawLocalFileSystem 是否开启文件校验
		fs.copyToLocalFile(false, new Path("/liubei.txt"),
				new Path("E:/.Workspace/Hadoop/Hadopp_bigdata/zhugeliang.txt"), true);

		// 3 关闭资源
		fs.close();
	}

//	HDFS文件夹删除
//	@Test
	public void testDelete() throws IOException, InterruptedException, URISyntaxException {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");

		// 2 执行删除
		fs.delete(new Path("/user/bigdata/sanguo/"), true);

		// 3 关闭资源
		fs.close();
	}

//	HDFS文件名更改
//	@Test
	public void testRename() throws IOException, InterruptedException, URISyntaxException {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");

		// 2 修改文件名称
		fs.rename(new Path("/liubei.txt"), new Path("/liuxuande.txt"));
		// 3 关闭资源
		fs.close();
	}

//	HDFS文件详情查看
//	@Test
	public void testListFiles() throws IOException, InterruptedException, URISyntaxException {
		// 1获取文件系统
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");

		// 2 获取文件详情
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

		while (listFiles.hasNext()) {
			LocatedFileStatus status = listFiles.next();

			// 输出详情
			// 文件名称
			System.out.println(status.getPath().getName());
			// 长度
			System.out.println(status.getLen());
			// 权限
			System.out.println(status.getPermission());
			// 分组
			System.out.println(status.getGroup());

			// 获取存储的块信息
			BlockLocation[] blockLocations = status.getBlockLocations();

			for (BlockLocation blockLocation : blockLocations) {

				// 获取块存储的主机节点
				String[] hosts = blockLocation.getHosts();

				for (String host : hosts) {
					System.out.println(host);
				}
			}

			System.out.println("-----------分割线----------");
		}
		// 3 关闭资源
		fs.close();
	}

//	HDFS文件和文件夹判断
	@Test
	public void testListStatus() throws IOException, InterruptedException, URISyntaxException{

		// 1 获取文件配置信息
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://server102:9000"), configuration, "bigdata");

		// 2 判断是文件还是文件夹
		FileStatus[] listStatus = fs.listStatus(new Path("/"));

		for (FileStatus fileStatus : listStatus) {

			// 如果是文件
			if (fileStatus.isFile()) {
				System.out.println("f:" + fileStatus.getPath().getName());
			} else {
				System.out.println("d:" + fileStatus.getPath().getName());
			}
		}

		// 3 关闭资源
		fs.close();
	}
}
