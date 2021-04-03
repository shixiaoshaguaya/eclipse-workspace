package cn.lmu.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class HDFSHelper {
	private FileSystem fs;

	public HDFSHelper() {
		fs = getFileSystem();
	}

	/**
	 * Configuration是配置对象，conf可以理解为包含了所有配置信息的一个集合，可以认为是Map, 在初始化的时候底层会加载一堆配置文件
	 * core-site.xml;hdfs-site.xml;mapred-site.xml;yarn-site.xml
	 * 如果需要项目代码自动加载配置文件中的信息，那么就必须把配置文件改成-default.xml或者-site.xml的名称，
	 * 而且必须放置在src下,如果不叫这个名，或者不在src下，也需要加载这些配置文件中的参数，必须使用conf对象提供的方法手动加载.
	 * 依次加载的参数信息的顺序是： 1.加载core/hdfs/mapred/yarn-default.xml
	 * 2.加载通过conf.addResource()加载的配置文件 3.加载conf.set(name,value)
	 */
	private Configuration getConfiguration() {
		Configuration conf = new Configuration();
		// conf.addResource("xxx");
		// conf.set("xxx","xxx");
		// Configuration.addDefaultResource("core-site.xml");
		// Configuration.addDefaultResource("hdfs-site.xml");
		// conf.set("fs.default.name","hdfs://probd01:8020");
		// HA模式的配置
		conf.set("fs.defaultFS", "hdfs://probd");
		conf.set("dfs.nameservices", "probd");
		conf.set("dfs.ha.namenodes.probd", "nn1,nn2");
		conf.set("dfs.namenode.rpc-address.probd.nn1", "probd01:8020");
		conf.set("dfs.namenode.rpc-address.probd.nn2", "probd02:8020");
		conf.set("dfs.client.failover.proxy.provider.probd",
				"org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
		// 防止报错：no FileSystem for scheme: hdfs...
		conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
		return conf;
	}

	/**
	 * 获取文件系统 本地文件系统为LocalFileSystem，URL形式: file:///c:myProgram
	 * HDFS文件系统为DistributedFileSystem，URL形式: fs.defaultFS=hdfs://hadoop01:9000
	 */
	public FileSystem getFileSystem() {
		Configuration conf = getConfiguration();
		FileSystem fs = null;
		try {
			fs = FileSystem.get(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(fs);
		return fs;
	}

	/**
	 * 上传本地文件到HDFS，底层就是采用流的方式
	 * 
	 * @param localPath  本地文件路径
	 * @param remotePath HDFS文件路径
	 * @return 是否上传成功
	 */
	public boolean copyFromLocal(String localPath, String remotePath) {
		if (fs == null)
			return false;
		try {
			fs.copyFromLocalFile(new Path(localPath), new Path(remotePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 从HDFS下载文件，底层就是采用流的方式
	 * 
	 * @param remotePath HDFS文件路径
	 * @param localPath  本地路径
	 * @return 是否下载成功
	 */
	public boolean copyToLocal(String remotePath, String localPath) {
		if (fs == null)
			return false;
		try {
			fs.copyToLocalFile(new Path(remotePath), new Path(localPath));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 获取目录下的文件
	 * 
	 * @param remotePath HDFS文件路径
	 * @param recursive  是否级联（该文件夹下面如果还有子文件 要不要看,注意没有 子文件夹!!）
	 */
	public void listFiles(String remotePath, boolean recursive) {
		if (fs == null)
			return;
		try {
			RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path(remotePath), recursive);
			while (iterator.hasNext()) {
				LocatedFileStatus fileStatus = iterator.next(); // 文件的存储路径，以hdfs://开头的全路径 ==>
																// hdfs://hadoop01:9000/a/gg.txt
				System.out.println("file path === " + fileStatus.getPath());
				// 文件名
				System.out.println("file name === " + fileStatus.getPath().getName());
				// 文件长度
				System.out.println("file size === " + fileStatus.getLen());
				// 文件所有者
				System.out.println("file owner === " + fileStatus.getOwner());
				// 分组信息
				System.out.println("file group === " + fileStatus.getGroup());
				// 文件权限信息
				System.out.println("file permission === " + fileStatus.getPermission());
				// 文件副本数
				System.out.println("file blocks === " + fileStatus.getReplication());
				// 块大小
				System.out.println("file block size === " + fileStatus.getBlockSize());
				// 块位置相关信息
				BlockLocation[] blockLocations = fileStatus.getBlockLocations();
				// 块的数量
				System.out.println("file block nums === " + blockLocations.length);
				for (BlockLocation bl : blockLocations) {
					String[] hosts = bl.getHosts();
					for (String host : hosts) {
						System.out.println("block host === " + host);
					}
					// 块的一个逻辑路径
					bl.getTopologyPaths();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取目录下的文件 此方法与listFiles不同,不支持传true或false,即不能级联，如果想实现级联就采用递归的方式
	 * 
	 * @param remotePath HDFS文件路径
	 */
	public void listStatus(String remotePath) {
		if (fs == null)
			return;
		try {
			FileStatus[] listStatus = fs.listStatus(new Path(remotePath));
			for (FileStatus fss : listStatus) {
				// 判断是不是文件夹
				boolean directory = fss.isDirectory();
				// 判断是不是文件
				boolean file = fss.isFile();
				String name = fss.getPath().getName();
				if (file) {
					System.out.println(name + ":文件");
				} else {
					System.out.println(name + ":文件夹");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除空文件夹或空文件
	 * 
	 * @param path
	 */
	public void deleteEmptyDirAndFile(Path path) {
		if (fs == null)
			return;
		try {
			FileStatus[] listStatus = fs.listStatus(path);
			if (listStatus.length == 0) {
				// 删除空文件夹
				fs.delete(path, true);
				return;
			}
			RemoteIterator<LocatedFileStatus> iterator = fs.listLocatedStatus(path);
			while (iterator.hasNext()) {
				LocatedFileStatus next = iterator.next();
				Path currentPath = next.getPath();
				Path parentPath = next.getPath().getParent();
				if (next.isDirectory()) {
					// 如果是空文件夹
					if (fs.listStatus(currentPath).length == 0) {
						// 删除掉
						fs.delete(currentPath, true);
					} else {
						// 不是空文件夹，那么则继续遍历
						if (fs.exists(currentPath)) {
							deleteEmptyDirAndFile(currentPath);
						}
					}
				} else {
					// 获取文件的长度
					long fileLength = next.getLen();
					// 当文件是空文件时， 删除
					if (fileLength == 0) {
						fs.delete(currentPath, true);
					}
				}
				// 当空文件夹或者空文件删除时，有可能导致父文件夹为空文件夹，
				// 所以每次删除一个空文件或者空文件的时候都需要判断一下，如果真是如此，那么就需要把该文件夹也删除掉
				int length = fs.listStatus(parentPath).length;
				if (length == 0) {
					fs.delete(parentPath, true);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建文件夹
	 * 
	 * @param remotePath HDFS文件路径
	 * @return 是否创建成功
	 */
	public boolean mkdir(String remotePath) {
		if (fs == null)
			return false;
		boolean success = false;
		try {
			success = fs.mkdirs(new Path(remotePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 写入文件
	 * 
	 * @param remotePath HDFS文件路径
	 * @param content    内容
	 * @return 是否写入成功
	 */
	public boolean writeToFile(String remotePath, String content) {
		if (fs == null)
			return false;
		try {
			FSDataOutputStream out = fs.create(new Path(remotePath));
			out.writeUTF(content);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取文件数据
	 * 
	 * @param remotePath HDFS文件路径
	 * @return 读取的结果数据
	 */
	public String readFromFile(String remotePath) {
		String result = null;
		if (fs == null)
			return null;
		try {
			FSDataInputStream in = fs.open(new Path(remotePath));
			result = in.readUTF();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 重命名文件
	 * 
	 * @param oldPath 旧文件路径
	 * @param newPath 新文件路径
	 * @return 是否重命名成功
	 */
	public boolean renameFile(String oldPath, String newPath) {
		if (fs == null)
			return false;
		Path old = new Path(oldPath);
		Path now = new Path(newPath);
		boolean rename = false;
		try {
			rename = fs.rename(old, now);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rename;
	}

	/**
	 * 删除目录和文件
	 * 
	 * @param remotePath HDFS文件路径
	 * @return 是否删除成功
	 */
	public boolean deleteFile(String remotePath) {
		if (fs == null)
			return false;
		boolean success = false;
		try {
			success = fs.delete(new Path(remotePath), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 检查文件是否存在
	 * 
	 * @param remotePath HDFS文件路径
	 * @return 是否存在
	 */
	public boolean existFile(String remotePath) {
		if (fs == null)
			return false;
		boolean exist = false;
		try {
			exist = fs.exists(new Path(remotePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return exist;
	}

	/**
	 * 关闭FileSystem
	 */
	public void closeFileSystem() {
		if (fs != null) {
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
