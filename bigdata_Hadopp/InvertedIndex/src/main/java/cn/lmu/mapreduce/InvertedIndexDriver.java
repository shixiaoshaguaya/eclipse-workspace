package cn.lmu.mapreduce;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvertedIndexDriver {
	public static void main(String[] args)
			throws IOException, URISyntaxException, ClassNotFoundException, InterruptedException {
		if (args.length == 0) {
			args = new String[] { "/user/bigdata/invertedindex/input", "/user/bigdata/invertedindex/output" };
		}
		Configuration conf = new Configuration();
		// 删除已经存在的输出路径
		FileSystem fs = FileSystem.get(new URI(args[1]), conf);
		if (fs.exists(new Path(args[1]))) {
			fs.delete(new Path(args[1]), true);
		}

		Job job = Job.getInstance(conf, "InvertedIndex");
		job.setJarByClass(InvertedIndexDriver.class);
		job.setMapperClass(InvertedIndexMapper.class);
		job.setCombinerClass(InvertedIndexCombiner.class);
		job.setReducerClass(InvertedIndexReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
