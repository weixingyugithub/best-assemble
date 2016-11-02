package com.beijing.wei.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 功能:zip压缩、解压 说明:本程序通过ZipOutputStream和ZipInputStream实现了zip压缩和解压功能.
 * 问题:由于java.util.zip包并不支持汉字,当zip文件中有名字为中文的文件时,
 * 就会出现异常:"Exception  in thread "main " java.lang.IllegalArgumentException at
 * java.util.zip.ZipInputStream.getUTF8String(ZipInputStream.java:285) 解决:
 */

public class ZipFileUtil {
	private ZipInputStream zipIn; // 解压Zip
	private ZipOutputStream zipOut; // 压缩Zip
	private ZipEntry zipEntry;
	private static int bufSize; // size of bytes
	private byte[] buf;
	private int readedBytes;

	public ZipFileUtil() {
		this(512);
	}

	public ZipFileUtil(int bufSize) {
		this.bufSize = bufSize;
		this.buf = new byte[this.bufSize];
	}

	// 压缩文件夹内的文件
	public void doZip(String zipDirectory) {// zipDirectoryPath:需要压缩的文件夹名
		File zipDir;

		zipDir = new File(zipDirectory);
		String zipFileName = zipDir.getPath() + ".zip";// 压缩后生成的zip文件名

		try {
			this.zipOut = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(zipFileName)));
			handleDir(zipDir, this.zipOut);
			this.zipOut.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// 由doZip调用,递归完成目录文件读取
	private void handleDir(File dir, ZipOutputStream zipOut) throws IOException {
		FileInputStream fileIn;
		File[] files;

		files = dir.listFiles();

		if (files.length == 0) {// 如果目录为空,则单独创建之.
			// ZipEntry的isDirectory()方法中,目录以"/"结尾.
			this.zipOut.putNextEntry(new ZipEntry(dir.toString() + "/"));
			this.zipOut.closeEntry();
		} else {// 如果目录不为空,则分别处理目录和文件.
			for (File fileName : files) {
				// System.out.println(fileName);

				if (fileName.isDirectory()) {
					handleDir(fileName, this.zipOut);
				} else {
					fileIn = new FileInputStream(fileName);
					this.zipOut.putNextEntry(new ZipEntry(fileName.getName()));

					while ((this.readedBytes = fileIn.read(this.buf)) > 0) {
						this.zipOut.write(this.buf, 0, this.readedBytes);
					}

					this.zipOut.closeEntry();
				}
			}
		}
	}

	// 解压指定zip文件
	public void unZip(String unZipfileName) {// unZipfileName需要解压的zip文件名
		FileOutputStream fileOut;
		File file = new File(unZipfileName);
		String path = "";
		if(file.isFile()){
			path = file.getPath().substring(0,file.getPath().lastIndexOf(".")) + File.separator;
		}
		try {
			this.zipIn = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(unZipfileName)));

			while ((this.zipEntry = this.zipIn.getNextEntry()) != null) {
				file = new File(path + this.zipEntry.getName());
				// System.out.println(file);///

				if (this.zipEntry.isDirectory()) {
					file.mkdirs();
				} else {
					// 如果指定文件的目录不存在,则创建之.
					File parent = file.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}

					fileOut = new FileOutputStream(file);
					while ((this.readedBytes = this.zipIn.read(this.buf)) > 0) {
						fileOut.write(this.buf, 0, this.readedBytes);
					}
					fileOut.close();
				}
				this.zipIn.closeEntry();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// 设置缓冲区大小
	public void setBufSize(int bufSize) {
		this.bufSize = bufSize;
	}

	// 测试Zip类
	public static void main(String[] args) throws Exception {
		ZipFileUtil zip = new ZipFileUtil();
		zip.unZip("C:\\temp\\PowerDesigner15.1_CN_CR.rar");
		//File file = new File("G:\\tvrcyygygy\\wxys\\HttpwatchPr");
		//System.out.println(file.isDirectory());
		//System.out.println(file.listFiles().length);
	}
}