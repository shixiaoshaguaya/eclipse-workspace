package cn.lmu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Topn {
	public static final int K = 10;

	public static class MyIntWritable extends IntWritable {
		public MyIntWritable() {
		}

		public MyIntWritable(int value) {
			super(value);
		}

		@Override
		public int compareTo(IntWritable o) {
			return -super.compareTo(o); // 重写IntWritable排序方法，实现对整数排序时按降序处理，默认是升序 ，
		}
	}

	public static class MyMapper extends Mapper<LongWritable, Text, MyIntWritable, Text> {
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String[] arr = value.toString().split("\t");
			int count = Integer.parseInt(arr[1]);
			context.write(new MyIntWritable(count), new Text(arr[0]));
		}
	}

	public static class MyReducer extends Reducer<MyIntWritable, Text, Text, MyIntWritable> {
		int num = 0;

		@Override
		protected void reduce(MyIntWritable key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {
			for (Text text : values) {
				if (num < K) {
					context.write(text, key);
				}
				num++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(Topn.class);
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);
		job.setMapOutputKeyClass(MyIntWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(MyIntWritable.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileSystem fileSystem = FileSystem.get(conf);
		fileSystem.deleteOnExit(new Path(args[1]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
