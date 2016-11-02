package com.beijing.wei.util.autoReack;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 小黄鸡机器人
 */
public class SimsimiTools {
	private static final String SIMSIMI_URL = "http://www.niurenqushi.com/app/simsimi/ajax.aspx";

	public static void main(String[] args) throws Exception {
		String result = getSimsimiResponseMsg("杭州天气怎么样");
		System.out.println(result);
	}

	public static String getSimsimiResponseMsg(String requestMsg) throws Exception {
		StringBuffer responseMsg = new StringBuffer();

		URL url = new URL(SIMSIMI_URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		HttpURLConnection.setFollowRedirects(true);

		con.setConnectTimeout(20000);
		con.setReadTimeout(20000);
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("Referer", "http://www.niurenqushi.com/app/simsimi/");
		con.connect();

		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		out.write("txt=" + URLEncoder.encode(requestMsg, "UTF-8"));
		out.flush();
		out.close();

		InputStream in = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			responseMsg.append(line);
		}

		in.close();
		isr.close();
		br.close();

		return responseMsg.toString();
	}
}