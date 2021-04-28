package cn.lmu.mapreduce;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvertedIndexDriver {
	public static void main(String[] args)
			throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
		if (args.length == 0) {
			args = new String[] { "/user/cz40/invertedindex/input", "/user/cz40/invertedindex/output" };
		}
		Configuration conf = new Configuration();
		// 删除已经存在的输出路径,HDFS API接口应用
		FileSystem fs = FileSystem.get(new URI(args[1]), conf);
		if (fs.exists(new Path(args[1]))) {
			fs.delete(new Path(args[1]), true);
		}
		Job job = Job.getInstance(conf, "InvertedIndex");
		job.addArchiveToClassPath(new Path("hdfs://192.168.139.130:9000/user/cz40/jars/word-1.3.1.jar"));
		job.setJarByClass(InvertedIndexDriver.class);
		job.setMapperClass(InvertedIndexMapper.class);
		// 在Map阶段的末尾加入Combiner操作，进行本Map阶段的汇总
		job.setCombinerClass(InvertedIndexCombiner.class);
		// 再进入Reducer
		job.setReducerClass(InvertedIndexReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
