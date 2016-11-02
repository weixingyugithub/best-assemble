package com.beijing.wei.util.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beijing.wei.util.db.ReadProperties;

/**
 * 从FTP服务器下载文件
 * 
 * @author Administrator
 * 
 */
public class FTPUtil {
	private static Logger logger = LoggerFactory.getLogger(FTPUtil.class);
	public static String username = ReadProperties
			.getWxyValue("wxy.FTP_USERNAME");// FTP登陆名
	public static String password = ReadProperties
			.getWxyValue("wxy.FTP_PASSWORD");// FTP登陆密码
	public static String ip = ReadProperties.getWxyValue("wxy.FTP_SERVER_ADDR");// FTP地址
	// FTP端口 21
	private static int port = Integer.valueOf(null == ReadProperties.getWxyValue("wxy.FTP_SERVER_IP")?"21":ReadProperties.getWxyValue("wxy.FTP_SERVER_IP"));
	private static FTPClient ftpClient = null;// FTP客户端

	/**
	 * 打开FTP连接
	 * 
	 * @return
	 */
	public static boolean connectServer() {
		boolean flag = true;
		int reply;
		try {
			ftpClient = new FTPClient();
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setDefaultPort(port);
			ftpClient.setDataTimeout(0);
			if (ip.contains("//")) {
				ftpClient.connect(ip.split("//")[1]);
			} else {
				ftpClient.connect(ip);
			}
			ftpClient.login(username, password);
			reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				logger.debug("FTP 服务拒绝连接！");
				flag = false;
			}
		} catch (SocketException e) {
			ftpClient = null;
			flag = false;
			logger.error("登录ftp服务器【" + ip + "】失败,连接超时！");
		} catch (IOException e) {
			ftpClient = null;
			flag = false;
			logger.error("登录ftp服务器【" + ip + "】失败,FTP服务器无法打开！");
		}
		return flag;
	}

	/**
	 * 关闭连接
	 */
	public static void closeConnect() {
		try {
			if (null != ftpClient) {
				ftpClient.logout();
				ftpClient.disconnect();
				ftpClient = null;
			}
		} catch (Exception e) {
			logger.error("关闭FTP连接出现异常", e);
		}
	}

	/**
	 * 上传文件到FTP服务器
	 * 
	 * @param localFile
	 *            本地文件路径
	 * @param newFileName
	 *            上传到FTP服务器上的文件名
	 * @return 成功返回true,否则返回false
	 * @throws IOException
	 */
	public static boolean uploadFile(InputStream input, String newFileName,
			String dir) throws IOException {
		boolean flag = true;
		if (connectServer()) {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftpClient.setFileStructure(FTP.FILE_STRUCTURE);
			// 如果不能进入dir下,说明此目录不存在
			if (!ftpClient.changeWorkingDirectory(dir)) {
				if (!makeDirectory(dir)) {
					logger.debug("创建文件目录【" + dir + "】 失败！");
				}
				ftpClient.changeWorkingDirectory(dir);
			}
			// 如果文件之前存在
			if (checkFileExist(dir + newFileName)) {
				deleteFile(dir + newFileName);
			}
			flag = ftpClient.storeFile(newFileName, input);
			if (!flag) {
				logger.debug("文件【" + dir + newFileName + "】上传失败");
			} else {
				logger.debug("文件【" + dir + newFileName + "】上传成功");
			}
			input.close();
			closeConnect();
		} else {
			flag = false;
			logger.debug("FTP连接未打开");
		}
		return flag;
	}

	/**
	 * 进入到服务器的某个目录下
	 * 
	 * @param directory
	 */
	public static void changeWorkingDirectory(String directory) {
		try {
			if (connectServer()) {
				ftpClient.changeWorkingDirectory(directory);
			} else {
				logger.debug("FTP连接未打开");
			}
		} catch (IOException ioe) {
			logger.debug("进入FTP文件夹失败");
		}
	}

	/**
	 * 删除FTP上的单个文件
	 * 
	 * @param pathname
	 * @return
	 */
	public static boolean deleteFile(String pathname) {
		boolean flag = true;
		if (connectServer()) {
			try {
				flag = ftpClient.deleteFile(pathname);
				if (flag) {
					logger.debug("文件【" + pathname + "】删除成功!");
				} else {
					logger.debug("文件【" + pathname + "】删除失败!");
				}
			} catch (IOException e) {
				flag = false;
				logger.error("文件【" + pathname + "】删除出现异常,删除失败!", e);
			}
		} else {
			flag = false;
			logger.debug("FTP连接未打开");
		}
		return flag;
	}

	/**
	 * 在服务器上创建一个文件夹
	 * 
	 * @param dir
	 *            文件夹名称，不能含有特殊字符，如 \ 、/ 、: 、* 、?、 "、 <、>...
	 * @return
	 */
	public static boolean makeDirectory(String dir) {
		boolean flag = true;
		if (connectServer()) {
			try {
				flag = ftpClient.makeDirectory(dir);
			} catch (IOException e) {
				flag = false;
				logger.debug("FTP创建文件夹【" + dir + "】失败");
			}
		} else {
			flag = false;
			logger.debug("FTP连接未打开");
		}
		return flag;
	}

	/**
	 * 检测FTP上文件是否存在
	 * 
	 * @param path
	 * @return
	 */
	public static boolean checkFileExist(String path) {
		boolean flag = true;
		if (connectServer()) {
			try {
				FTPFile[] ftpFile = ftpClient.listFiles(path);
				if (ftpFile.length < 1) {
					flag = false;
				}
			} catch (IOException e) {
				flag = false;
				logger.debug("获取FTP上【" + path + "】文件失败");
			}
		} else {
			flag = false;
			logger.debug("FTP连接未打开");
		}
		return flag;
	}

	
	public static void main(String[] args) {
		boolean b = connectServer();
		if(b){
			if(checkFileExist("自主研发平台培训学习路线-V1.2.doc")){
				System.out.println("--");
			}
		}
	}
}
