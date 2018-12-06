package com.csii.lipei.springbootProject.trigger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.xmlunit.builder.Input;

/**
 * 
 * @author lipei
 *
 */
public class ReplacFile {
	
	private String reMnt;
	
	private String oldChar;
	
	private String reChar;
	
	public ReplacFile() {
	}
	
	public ReplacFile(String reMnt, String oldChar, String reChar) {
		super();
		this.reMnt = reMnt;
		this.oldChar = oldChar;
		this.reChar = reChar;
	}

	public static void main(String[] args) throws IOException {
		/*ReplacFile rf = new ReplacFile("E:/lipei/","ABCDEFGHIGK","ABdcEFGHIGK");
		rf.start();*/
		
		File file = new File("E:/lipei/rocketmq-externals-master.zip");
		File file2 = new File("E:/lipei/rocketmq-externals-master2.zip");
		InputStream is = new FileInputStream(file);
		byte[] bytes = new byte[is.available()];
		is.read(bytes);
		OutputStream os = new FileOutputStream(file2);
		os.write(bytes);
		os.close();
		is.close();
	}
	
	public void start() throws IOException{
		this.checkFile(new File(this.reMnt));
	}
	
	/**
	 * 遍历盘符下的文件
	 * @param mnt
	 * @throws IOException 
	 */
	public void checkFile(File mnt) throws IOException{
		if (mnt.isDirectory()) {
			File[] childMnt = mnt.listFiles();
			if (childMnt == null) {
				return ;
			}
			for (File file : childMnt) {
				checkFile(file);
			}
			
		}else{
			if (replaceFile(mnt) != null) {
				copyFile(mnt);
			};
		}
		
	}
	
	public Object replaceFile(File pointFile) throws IOException{
		Object obj = null;
		InputStream is = new FileInputStream(pointFile);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfer = new BufferedReader(isr);
		String readLine = null;
		while ((readLine = bfer.readLine()) != null) {
			readLine = new String(readLine.getBytes(),"UTF-8");
			if (readLine.contains(this.oldChar)) {
				obj = pointFile;
			}
				
		}
		
		if (bfer != null) 
			bfer.close();
		if (isr != null) 
			isr.close();
		if (is != null) 
			is.close();
		return obj;
	}
	
	public void copyFile(File pointFile) throws IOException{
		InputStream is = new FileInputStream(pointFile);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfer = new BufferedReader(isr);
		File newFile = new File(pointFile.getAbsolutePath() + ".esc");
		OutputStream ops = new FileOutputStream(newFile);
		OutputStreamWriter opsw = new OutputStreamWriter(ops);
		BufferedWriter bfew = new BufferedWriter(opsw);
		String readLine = null;
		String newLine = null;
		while ((readLine = bfer.readLine()) != null) {
			readLine = new String(readLine.getBytes(),"UTF-8");
			if (readLine.contains(this.oldChar)) {
				newLine = readLine.replace(this.oldChar, this.reChar);
			}
			bfew.write(newLine);
		}
		if (bfer != null) 
			bfer.close();
		if (isr != null) 
			isr.close();
		if (is != null) 
			is.close();
		if (bfew != null) 
			bfew.close();
		if (opsw != null) 
			opsw.close();
		if (ops != null) 
			ops.close();
		pointFile.delete();
		newFile.renameTo(pointFile);
	}
}	
