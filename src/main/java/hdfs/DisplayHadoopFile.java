package hdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class DisplayHadoopFile {
	
	public static void main(String[] args) throws Exception {
		String filePath = "infile/in.txt"; // 하둡 서버 존재 => local에 저장
		Path pt = new Path(filePath);
		Configuration conf = new Configuration(); // 하둡 환경
		FileSystem fs = FileSystem.get(conf); // hdfs 시스템, Hadoop Distribute File System
		BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(pt), "UTF-8"));
		// fs.open : FSDataInputStream
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

}
