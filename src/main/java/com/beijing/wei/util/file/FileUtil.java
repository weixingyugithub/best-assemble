package com.beijing.wei.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.beijing.wei.util.common.CommonVariable;

public class FileUtil {
	
	/**
	 * <p>以文件流的方式复制文件</p>
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	
	public static void copyFile(String src,String dest) throws IOException{
        FileInputStream in=new FileInputStream(src);
        File file=new File(dest);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file);
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++)
                out.write(buffer[i]);        
        }
        in.close();
        out.close();
    }
	
	/**
	 * <p>利用PrintStream写文件</p>
	 */
	
	public static void PrintStreamDemo(String path){
        try {
            FileOutputStream out=new FileOutputStream(path);
            PrintStream p=new PrintStream(out);
            for(int i=0;i<10;i++)
                p.println("This is "+i+" line");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	/**
	 * <p>利用StringBuffer写文件</p>
	 * @throws IOException
	 */
	public static void StringBufferDemo(String path) throws IOException{
        File file=new File(path);//"/root/sms.log");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true);        
        for(int i=0;i<10000;i++){
            StringBuffer sb=new StringBuffer();
            sb.append("这是第"+i+"行:前面介绍的各种方法都不关用,为什么总是奇怪的问题 ");
            out.write(sb.toString().getBytes("utf-8"));
        }        
        out.close();
    }
	
	/**
	 * <p>文件重命名</p>
	 * @param path
	 * @param oldname
	 * @param newname
	 */
	
	public static void renameFile(String path,String oldname,String newname){
        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile=new File(path + CommonVariable.FILE_SEPARATOR + oldname);
            File newfile=new File(path + CommonVariable.FILE_SEPARATOR + newname);
            if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                System.out.println(newname+"已经存在！");
            else{
                oldfile.renameTo(newfile);
            }
        }         
    }
	
	/**
	 * <p>转移文件目录不等同于复制文件，
	 * 	   复制文件是复制后两个目录都存在该文件，
	 *   而转移文件目录则是转移后，
	 *   只有新目录中存在该文件</p>
	 * @param filename
	 * @param oldpath
	 * @param newpath
	 * @param cover
	 */
	
	public static void changeDirectory(String filename,String oldpath,String newpath,boolean cover){
        if(!oldpath.equals(newpath)){
            File oldfile=new File(oldpath + CommonVariable.FILE_SEPARATOR + filename);
            File newfile=new File(newpath + CommonVariable.FILE_SEPARATOR + filename);
            if(newfile.exists()){//若在待转移目录下，已经存在待转移文件
                if(cover)//覆盖
                    oldfile.renameTo(newfile);
                else
                    System.out.println("在新目录下已经存在："+filename);
            }
            else{
                oldfile.renameTo(newfile);
            }
        }       
    }
	
	/**
	 * <p>利用FileInputStream读取文件</p>
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String FileInputStreamDemo(String path) throws IOException{
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        FileInputStream fis=new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb=new StringBuffer();
        while((fis.read(buf))!=-1){
            sb.append(new String(buf));    
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        return sb.toString();
    }
	/**
	 * <p>利用BufferedReader读取</p>
	 * 	利用BufferedReader和BufferedWriter效率会更高一点
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String BufferedReaderDemo(String path) throws IOException{
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        while(temp!=null){
            sb.append(temp+" ");
            temp=br.readLine();
        }
        return sb.toString();
    }
	
	/**
	 * <p>利用dom4j读取xml文件</p>
	 * @param path
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	
	public static Document readXml(String path) throws DocumentException, IOException{
        File file=new File(path);
        BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
        SAXReader saxreader = new SAXReader();
        Document document = (Document)saxreader.read(bufferedreader);
        bufferedreader.close();
        return document;
    }
	
	/**
	 * 创建文件夹  
	 * @param path
	 */
    public static void createDir(String path){
        File dir=new File(path);
        if(!dir.exists())
            dir.mkdir();
    }
	/**
	 * 创建新文件
	 * @param path
	 * @param filename
	 * @throws IOException
	 */
    public static void createFile(String path,String filename) throws IOException{
        File file=new File(path + CommonVariable.FILE_SEPARATOR + filename);
        if(!file.exists())
            file.createNewFile();
    }

    /**
     * <p>删除文件(目录)</p>
     */
 
    public static void delFile(String path,String filename){
        File file=new File(path + CommonVariable.FILE_SEPARATOR + filename);
        if(file.exists()&&file.isFile())
            file.delete();
    }
	/**
	 * <p>删除目录</p>
	 * 	要利用File类的delete()方法删除目录时，
	 * 必须保证该目录下没有文件或者子目录，
	 * 否则删除失败，因此在实际应用中，我们要删除目录
	 * ，必须利用递归删除该目录下的所有子目录和文件，
	 * 然后再删除该目录。  
	 */

    public static void delDir(String path){
        File dir=new File(path);
        if(dir.exists()){
            File[] tmp=dir.listFiles();
            for(int i=0;i<tmp.length;i++){
                if(tmp[i].isDirectory()){
                    delDir(path + CommonVariable.FILE_SEPARATOR + tmp[i].getName());
                }
                else{
                    tmp[i].delete();
                }
            }
            dir.delete();
        }
    }
    
    public static void main(String[] args) {
    	FileUtil.delFile("C:\\Users\\IBM_ADMIN\\Desktop","QQ圖片20140923173526.jpg");
	}
}
