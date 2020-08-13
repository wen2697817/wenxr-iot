package iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class TestUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String url = "http://127.0.0.1/iot/monitor-Monitor-loadMonitor.action?userCode=1112&equipmentCode=MidECW1000";
//		try {
//			URL oracle = new URL(url);
//			URLConnection conn = oracle.openConnection();// 或HttpURLConnection connect = (HttpURLConnection)
//			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String inputLine = null;
//			String m="";
//			while ((inputLine = br.readLine()) != null) {
//				System.out.println(inputLine);
//				m = m+inputLine;
//			}
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		String s = "1,User00018,MidE700018,01,HE染色,02,00:27,01:48,00160}{1,User00018,MidE700018,02,HE染色,15,01:15,10:56,00160}{1,User00018,MidE700018,03,HE染色,05,02:15,19:01,00160}{1,User00018,MidE700018,04,HE染色,16,00:00,24:46,00160}{1,User00018,MidE700018,05,HE染色,09,00:00,24:46,00160}{1,User00018,MidE700018,06,HE染色,19,00:58,28:44,00160}{1,User00018,MidE700018,07,HE染色,22,01:52,33:38,00160}{1,User00018,MidE700018,08,HE染色,23,02:03,38:49,00160}{1,User00018,MidE700018,09,HE染色,24,03:36,45:22,00160";
		String ss[] = s.split("\\}\\{");
		System.out.println(ss[0]);
	}
}
