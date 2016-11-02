package com.beijing.wei.util.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author com.beijing.wei@live.com
 *
 * @param <T>
 */
public class Dom4jUtil<T> {
	/**  
     * DMO4J写入XML  
     * @param obj        泛型对象  
     * @param entityPropertys 泛型对象的List集合  
     * @param Encode     XML自定义编码类型(推荐使用GBK)  
     * @param XMLPathAndName    XML文件的路径及文件名  
     */  
    public void writeListToXmlDocument(T obj, List<T> entityPropertys, String Encode,   
            String XMLPathAndName) {   
        long lasting = System.currentTimeMillis();//效率检测   
        SysLogs.print("INFO", "写入xml开始======");
        try {   
            XMLWriter writer = null;// 声明写XML的对象    
            OutputFormat format = OutputFormat.createPrettyPrint();   
            format.setEncoding(Encode);// 设置XML文件的编码格式   
  
            String filePath = XMLPathAndName;//获得文件地址   
            File file = new File(filePath);//获得文件     
  
            if (file.exists()) {   
                file.delete();   
  
            }   
            // 新建student.xml文件并新增内容   
            Document document = DocumentHelper.createDocument();   
            String rootname = obj.getClass().getSimpleName();//获得类名   
            Element root = document.addElement(rootname + "s");//添加根节点   
            Field[] properties = obj.getClass().getDeclaredFields();//获得实体类的所有属性   
            
            for (T t : entityPropertys) {                                //递归实体   
                Element secondRoot = root.addElement(rootname);            //二级节点   
                
                for (int i = 0; i < properties.length; i++) {                      
                    //反射get方法       
                    Method meth = t.getClass().getMethod(                      
                            "get"  
                                    + properties[i].getName().substring(0, 1)   
                                            .toUpperCase()   
                                    + properties[i].getName().substring(1));   
                    //为二级节点添加属性，属性值为对应属性的值   
                    secondRoot.addElement(properties[i].getName()).setText(   
                            meth.invoke(t).toString());   
  
                }   
            }   
            //生成XML文件   
            writer = new XMLWriter(new FileWriter(file), format);   
            writer.write(document);   
            writer.close();   
            long lasting2 = System.currentTimeMillis();   
            System.out.println("写入XML文件结束,用时"+(lasting2 - lasting)+"ms");  
            SysLogs.print("INFO", "写入xml成功=======================用时"+(lasting2 - lasting)+"秒");
        } catch (SecurityException e) {
			System.out.println("XML文件写入失败");   
			SysLogs.print("INFO", "写入xml===================失败");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("XML文件写入失败");   
			SysLogs.print("INFO", "写入xml===================失败");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("XML文件写入失败");   
			SysLogs.print("INFO", "写入xml===================失败");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("XML文件写入失败");   
			SysLogs.print("INFO", "写入xml===================失败");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("XML文件写入失败");   
			SysLogs.print("INFO", "写入xml===================失败");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("XML文件写入失败");   
			SysLogs.print("INFO", "写入xml===================失败");
			e.printStackTrace();
		}
    }  
    
    /**  
     * DMO4J写入XML  
     * @param obj        泛型对象  
     * @param entityPropertys 泛型对象的List集合  
     * @param Encode     XML自定义编码类型(推荐使用GBK)  
	 * return xml
     */  
    public String writeListToXmlDocument(T obj, List<T> entityPropertys, String Encode) {   
        long lasting = System.currentTimeMillis();//效率检测   
        SysLogs.print("INFO", "写入xml开始======");
        String xml = "";
        try {   
            XMLWriter writer = null;// 声明写XML的对象    
            OutputFormat format = OutputFormat.createPrettyPrint();   
            format.setEncoding(Encode);// 设置XML文件的编码格式   
  
            // 新建student.xml文件并新增内容   
            Document document = DocumentHelper.createDocument();   
            String rootname = obj.getClass().getSimpleName();//获得类名   
            Element root = document.addElement(rootname + "s");//添加根节点   
            Field[] properties = obj.getClass().getDeclaredFields();//获得实体类的所有属性   
            
            for (T t : entityPropertys) {                                //递归实体   
                Element secondRoot = root.addElement(rootname);            //二级节点   
                
                for (int i = 0; i < properties.length; i++) {                      
                    //反射get方法       
                    Method meth = t.getClass().getMethod(                      
                            "get"  
                                    + properties[i].getName().substring(0, 1)   
                                            .toUpperCase()   
                                    + properties[i].getName().substring(1));   
                    //为二级节点添加属性，属性值为对应属性的值   
                    secondRoot.addElement(properties[i].getName()).setText(   
                            meth.invoke(t).toString());   
  
                }   
            }   
            //生成XML文件   
            long lasting2 = System.currentTimeMillis();   
            System.out.println("写入XML文件结束,用时"+(lasting2 - lasting)+"ms"); 
            SysLogs.print("INFO", "写入xml成功=======================用时"+(lasting2 - lasting)+"秒");
            xml =  document.asXML();
        } catch (Exception e) {   
            System.out.println("XML文件写入失败");  
            SysLogs.print("INFO", "写入xml===================失败");
        }   
        return xml;
    }  
    
    /**
     * <P>Bean转换为XML</P>
     * @param obj 实例的Bean对象
     * @param Encode  编码格式
     * @param XMLPathAndName  xml地址
     */
    
    public void writeBeanToXmlDocument(T obj, String Encode,   
            String XMLPathAndName){
    	long lasting = System.currentTimeMillis();//效率检测   
        SysLogs.print("INFO", "写入xml开始======");
    
            try {
				XMLWriter writer = null;// 声明写XML的对象    
				OutputFormat format = OutputFormat.createPrettyPrint();   
				format.setEncoding(Encode);// 设置XML文件的编码格式   
  
				String filePath = XMLPathAndName;//获得文件地址   
				File file = new File(filePath);//获得文件     
  
				if (file.exists()) {   
				    file.delete();   
  
				}   
				// 新建student.xml文件并新增内容   
				Document document = DocumentHelper.createDocument();   
				String rootname = obj.getClass().getSimpleName();//获得类名   
				Element root = document.addElement(rootname + "s");//添加根节点   
				Field[] properties = obj.getClass().getDeclaredFields();//获得实体类的所有属性   
				
				Element secondRoot = root.addElement(rootname);            //二级节点   
				
				for (int i = 0; i < properties.length; i++) {                      
				    //反射get方法       
				    Method meth = obj.getClass().getMethod(                      
				            "get"  
				                    + properties[i].getName().substring(0, 1)   
				                            .toUpperCase()   
				                    + properties[i].getName().substring(1));   
				    //为二级节点添加属性，属性值为对应属性的值   
				        secondRoot.addElement(properties[i].getName()).setText(   
				                meth.invoke(obj).toString());   
  
				    }   
				//生成XML文件   
				writer = new XMLWriter(new FileWriter(file), format);   
				writer.write(document);   
				writer.close();   
				long lasting2 = System.currentTimeMillis();   
				System.out.println("写入XML文件结束,用时"+(lasting2 - lasting)+"ms");  
				SysLogs.print("INFO", "写入xml成功=======================用时"+(lasting2 - lasting)+"秒");
			} catch (SecurityException e) {
				System.out.println("XML文件写入失败");   
				SysLogs.print("INFO", "写入xml===================失败");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("XML文件写入失败");   
				SysLogs.print("INFO", "写入xml===================失败");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("XML文件写入失败");   
				SysLogs.print("INFO", "写入xml===================失败");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("XML文件写入失败");   
				SysLogs.print("INFO", "写入xml===================失败");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println("XML文件写入失败");   
				SysLogs.print("INFO", "写入xml===================失败");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("XML文件写入失败");   
				SysLogs.print("INFO", "写入xml===================失败");
				e.printStackTrace();
			}
           
    }
    
    /**
     * <P>Bean转换为XML</P>
     * @param obj 实例的Bean对象
     * @param Encode  编码格式
     * return xml字符串
     */
    
    public String writeBeanToXmlDocument(T obj, String Encode){
    	long lasting = System.currentTimeMillis();//效率检测   
    	String xml = "";
        SysLogs.print("INFO", "写入xml开始======");
        try {   
            XMLWriter writer = null;// 声明写XML的对象    
            OutputFormat format = OutputFormat.createPrettyPrint();   
            format.setEncoding(Encode);// 设置XML文件的编码格式   
  
            Document document = DocumentHelper.createDocument();   
            String rootname = obj.getClass().getSimpleName();//获得类名   
            Element root = document.addElement(rootname + "s");//添加根节点   
            Field[] properties = obj.getClass().getDeclaredFields();//获得实体类的所有属性   
            
            Element secondRoot = root.addElement(rootname);            //二级节点   
            
            for (int i = 0; i < properties.length; i++) {                      
                //反射get方法       
                Method meth = obj.getClass().getMethod(                      
                        "get"  
                                + properties[i].getName().substring(0, 1)   
                                        .toUpperCase()   
                                + properties[i].getName().substring(1));   
                //为二级节点添加属性，属性值为对应属性的值   
                    secondRoot.addElement(properties[i].getName()).setText(   
                            meth.invoke(obj).toString());   
  
                }   
            long lasting2 = System.currentTimeMillis();   
            xml = document.asXML();
            System.out.println("写入XML文件结束,用时"+(lasting2 - lasting)+"ms");  
            SysLogs.print("INFO", "写入xml成功=======================用时"+(lasting2 - lasting)+"秒");
        } catch (Exception e) {   
            System.out.println("XML文件写入失败");   
            SysLogs.print("INFO", "写入xml===================失败");
        }   
        return xml;
    }
    
    /**
     * <P>微信Bean转换为XML</P>
     * @param obj 实例的Bean对象
     * @param Encode  编码格式
     * return xml字符串
     */
    
    public String writeWeiXinBeanToXmlDocument(T obj, String Encode){
    	long lasting = System.currentTimeMillis();//效率检测   
    	String xml = "";
        SysLogs.print("INFO", "写入xml开始======");
        try {   
            XMLWriter writer = null;// 声明写XML的对象    
            OutputFormat format = OutputFormat.createPrettyPrint();   
            format.setEncoding(Encode);// 设置XML文件的编码格式   
  
            Document document = DocumentHelper.createDocument();   
            String rootname = obj.getClass().getSimpleName();//获得类名   
            Element root = document.addElement("xml");//添加根节点   
            Field[] properties = obj.getClass().getDeclaredFields();//获得实体类的所有属性   
            
            for (int i = 0; i < properties.length; i++) {                      
                //反射get方法       
                Method meth = obj.getClass().getMethod(                      
                        "get"  
                                + properties[i].getName().substring(0, 1)   
                                        .toUpperCase()   
                                + properties[i].getName().substring(1));   
                //为二级节点添加属性，属性值为对应属性的值   
                    root.addElement(properties[i].getName()).setText(   
                            meth.invoke(obj).toString());   
  
                }   
            long lasting2 = System.currentTimeMillis();   
            xml = document.asXML();
            System.out.println("写入XML文件结束,用时"+(lasting2 - lasting)+"ms");  
            SysLogs.print("INFO", "写入xml成功=======================用时"+(lasting2 - lasting)+"秒");
        } catch (Exception e) {   
            System.out.println("XML文件写入失败");   
            SysLogs.print("INFO", "写入xml===================失败");
        }   
        return xml;
    }
}
