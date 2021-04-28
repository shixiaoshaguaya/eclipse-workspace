package cn.lmu.mapreduce;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	String title = "";
	String time = "";
	String author = "";
	String content = "";
	String word = "";
	Text k = new Text();
	IntWritable v = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String[] splits = value.toString().split("\",\"");
		if (splits.length >= 4) {
			title = splits[0];
			time = splits[1];
			author = splits[2];
			content = splits[3];
			List<Word> words = WordSegmenter.segWithStopWords(content);
			for (Word w : words) {
				word = w.getText();
				k.set(word);
				context.write(k, v);
			}
		}
	}

}
