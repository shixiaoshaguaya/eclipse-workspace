package cn.lmu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class OrderDriver {
	// 用于提交MapReduce计算程序，比如到Yarn去运行
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		if (args.length == 0) {
			args = new String[] { "e:/input/", "e:/output1" };
		} // 1 获取配置信息以及封装任务
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration);
		// 2 设置jar加载路径,检索main()进入程序运行
		job.setJarByClass(OrderDriver.class);
		// 3 设置map和reduce类
		job.setMapperClass(OrderMapper.class);
		job.setReducerClass(OrderReducer.class);
		// 4 设置map输出：<hadoop,1>,<I,1>
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(OrderInfo.class);
		// 5 设置最终输出kv类型<hadoop,3>,<I,4>
		job.setOutputKeyClass(OrderInfo.class);
		job.setOutputValueClass(NullWritable.class);
		// 6 设置输入和输出路径
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		// 7 提交
		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}

}
