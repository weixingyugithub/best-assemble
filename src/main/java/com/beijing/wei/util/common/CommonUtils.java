package com.beijing.wei.util.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.beijing.wei.util.file.SysLogs;
/**
 * @author com.beijing.wei@live.com
 * 通用工具类
 */
public class CommonUtils {
	/**
	 * @param plainText 加密前明文
	 * @return 密文
	 */
	public static String Md5(String plainText){
		return Md5(plainText,32);
	}
	/**
	 * @param plainText 明文字符串
	 * @param Md5 digit 16代表16位;32代表32位
	 */
	public static String Md5(String plainText,int digit) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			if(digit == 16){
				result = buf.toString().substring(8, 24).toUpperCase();
			}else {
				result = buf.toString().toUpperCase();
			}
		} catch (NoSuchAlgorithmException e) {
			SysLogs.print("ERROR", "MD5加密失败-->:"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6','7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static char toHex(int nibble) {
		return hexDigit[(nibble & 0xF)];
	}
	
	/**

     * 将字符串编码成 Unicode 形式的字符串. 如 "黄" to "\u9EC4"

     * Converts unicodes to encoded \\uxxxx and escapes

     * special characters with a preceding slash

     *  s = toEncodedUnicode(s, true);

        System.out.println("to unicode:\t\t" + s);

     * @param theString

     *        待转换成Unicode编码的字符串。

     * @param escapeSpace

     *        是否忽略空格，为true时在空格后面是否加个反斜杠。

     * @return 返回转换后Unicode编码的字符串。

     */

    public static String toEncodedUnicode(String theString, boolean escapeSpace) {

        int len = theString.length();

        int bufLen = len * 2;

        if (bufLen < 0) {

            bufLen = Integer.MAX_VALUE;

        }

        StringBuffer outBuffer = new StringBuffer(bufLen);

 


        for (int x = 0; x < len; x++) {

            char aChar = theString.charAt(x);

            // Handle common case first, selecting largest block that

            // avoids the specials below

            if ((aChar > 61) && (aChar < 127)) {

                if (aChar == '\\') {

                    outBuffer.append('\\');

                    outBuffer.append('\\');

                    continue;

                }

                outBuffer.append(aChar);

                continue;

            }

           

            switch (aChar) {

            case ' ':

                if (x == 0 || escapeSpace) outBuffer.append('\\');

                outBuffer.append(' ');

                break;

            case '\t':

                outBuffer.append('\\');

                outBuffer.append('t');

                break;

            case '\n':

                outBuffer.append('\\');

                outBuffer.append('n');

                break;

            case '\r':

                outBuffer.append('\\');

                outBuffer.append('r');

                break;

            case '\f':

                outBuffer.append('\\');

                outBuffer.append('f');

                break;

            case '=': // Fall through

            case ':': // Fall through

            case '#': // Fall through

            case '!':

                outBuffer.append('\\');

                outBuffer.append(aChar);

                break;

            default:

                if ((aChar < 0x0020) || (aChar > 0x007e)) {

                    // 每个unicode有16位，每四位对应的16进制从高位保存到低位

                    outBuffer.append('\\');

                    outBuffer.append('u');

                    outBuffer.append(toHex((aChar >> 12) & 0xF));

                    outBuffer.append(toHex((aChar >> 8) & 0xF));

                    outBuffer.append(toHex((aChar >> 4) & 0xF));

                    outBuffer.append(toHex(aChar & 0xF));

                } else {

                    outBuffer.append(aChar);

                }

            }

        }

        return outBuffer.toString();

    }

 


    /**

     * 从 Unicode 形式的字符串转换成对应的编码的特殊字符串。 如 "\u9EC4" to "黄".

     * Converts encoded \\uxxxx to unicode chars

     * and changes special saved chars to their original forms
      
     * s = fromEncodedUnicode(s.toCharArray(), 0, s.length());

        System.out.println("from unicode:\t" + s);

     * @param in

     *        Unicode编码的字符数组。

     * @param off

     *        转换的起始偏移量。

     * @param len

     *        转换的字符长度。

     * @param convtBuf

     *        转换的缓存字符数组。

     * @return 完成转换，返回编码前的特殊字符串。

     */

    public static String fromEncodedUnicode(char[] in, int off, int len) {

        char aChar;

        char[] out = new char[len]; // 只短不长

        int outLen = 0;

        int end = off + len;

 


        while (off < end) {

            aChar = in[off++];

            if (aChar == '\\') {

                aChar = in[off++];

                if (aChar == 'u') {

                    // Read the xxxx

                    int value = 0;

                    for (int i = 0; i < 4; i++) {

                        aChar = in[off++];

                        switch (aChar) {

                        case '0':

                        case '1':

                        case '2':

                        case '3':

                        case '4':

                        case '5':

                        case '6':

                        case '7':

                        case '8':

                        case '9':

                            value = (value << 4) + aChar - '0';

                            break;

                        case 'a':

                        case 'b':

                        case 'c':

                        case 'd':

                        case 'e':

                        case 'f':

                            value = (value << 4) + 10 + aChar - 'a';

                            break;

                        case 'A':

                        case 'B':

                        case 'C':

                        case 'D':

                        case 'E':

                        case 'F':

                            value = (value << 4) + 10 + aChar - 'A';

                            break;

                        default:

                            throw new IllegalArgumentException("Malformed \\uxxxx encoding.");

                        }

                    }

                    out[outLen++] = (char) value;

                } else {

                    if (aChar == 't') {

                        aChar = '\t';

                    } else if (aChar == 'r') {

                        aChar = '\r';

                    } else if (aChar == 'n') {

                        aChar = '\n';

                    } else if (aChar == 'f') {

                        aChar = '\f';

                    }

                    out[outLen++] = aChar;

                }

            } else {

                out[outLen++] = (char) aChar;

            }

        }

        return new String(out, 0, outLen);

    }

	/**
	 * comma 逗号
	 */
	public static final String comma = "\\{comma\\}";
	/**
	 * @param infMsg 转码前
	 * @return UTF-8 转码后
	 */
	public static String getEnableCode(String infMsg) {
		if (null != infMsg) {
			byte temp[];
			try {
				temp = infMsg.getBytes("iso-8859-1");
				infMsg = new String(temp, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				SysLogs.print("ERROR", e.toString());
			}
		}
		return infMsg;
	}

	/**
	 * 以字符为单位从文件中读取数据。使用场景：读取文本、数字等
	 * 
	 * @param filepath
	 * @return
	 */
	public static String readByCharsFromFile(String filepath) {
		String result = null;
		try {
			File file = new File(filepath);
			if (!file.exists() || file.isDirectory())
				throw new FileNotFoundException();
			FileInputStream fis = new FileInputStream(file);
			byte[] buf = new byte[4096];
			StringBuffer sb = new StringBuffer();
			while ((fis.read(buf)) != -1) {
				sb.append(new String(buf));
				buf = new byte[4096];// 重新生成，避免和上次读取的数据重复
			}
			result = sb.toString();
		} catch (Exception e) {
			SysLogs.print("ERROR", e.toString());
		}
		return result;

	}
	/**
	 * @param sourceStr 要处理的源字符串
	 * @param regex	正则表达式
	 * @param replaceBy 替换正则表达式中的字符
	 */
	public static String replaceByPattern(String sourceStr,String regex,String replaceBy){
		String result = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sourceStr);
		result = matcher.replaceAll(replaceBy);
		return result;
	}
	/**
	 * @param sourceStr 源串
	 * @param regex 正则表达式 如: getStringByPattern(srcString,"(\\[.*\\]\\.?){7}")
	 * @return 匹配的值
	 */
	public static List getStringByPattern(String sourceStr,String regex){
		List result = null;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sourceStr);
		while (matcher.find()) { 
			if(result == null){
			   result = new ArrayList();
			}
            String r = matcher.group(); 
            result.add(r);
        }
		return result;
	}
	/**
	 * @param sourceStr 源串
	 * @param regex 正则表达式 如: getMapByPattern(srcString,"(\\[.*\\]\\.?){7}")
	 * \\{([^\\$].*?)\\}  匹配出{} 的内容
	 * @return 返回的Map 如表达式字符串%55555% 那么map中的key是55555 value是%55555%
	 */
	public static List<Map> getMapByPattern(String sourceStr,String regex){
		List result = null;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sourceStr);
		while (matcher.find()) { 
			if(result == null){
			   result = new ArrayList();
			}
            String r = matcher.group(); 
            Map map = new HashMap();
            map.put(matcher.group(1), matcher.group(0));//key,表达式
            result.add(map);
        }
		return result;
	}
	
	/**
	 * @param instanceClass 要实例化的类 com.xxx.ClassName
	 * @return 类的实例对象
	 */
	public static Object getInstanceByClass(String instanceClass){
		Object result = null;
		try {
			SysLogs.print("INFO", "正在实例化对象-->:" + instanceClass);
			result = Class.forName(instanceClass).newInstance();
		} catch (Exception e) {
			SysLogs.print("ERROR", "实例参数对象:" + instanceClass + "失败！");
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String arg[]){
		String tt = "一";
		
	}
}
