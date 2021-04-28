package cn.lmu.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import cn.lmu.utils.*;

/*
* 输入文本文件的一行<行在文件的偏移量,该行文本>，如<1,hello world>
* 输出<word:filename, value>格式，如<hello:a.txt, 1>
* <hello:a.txt, 1>
* <hello:b.txt, 1>
*
* */
public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// 获取文件名
		// 文件路径：hdfs://10.20.14.47:8020/hadoop/invertedindex/input/a.txt
		// (split.getPath()方法)
		FileSplit split = (FileSplit) context.getInputSplit();
		// fileName：a.txt
		String fileName = StringUtil.getShortPath(split.getPath().toString());
		// 以<word:filename, value>形式存储 (便于Combiner中统计统一文件中相同单词数量)
		StringTokenizer st = new StringTokenizer(value.toString());
		while (st.hasMoreTokens()) {
			String word = st.nextToken().toLowerCase();
			word = word + ":" + fileName;
			context.write(new Text(word), new Text("1"));
		}
	}
}
