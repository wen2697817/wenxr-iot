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
		String url = "http://127.0.0.1/iot/monitor-Monitor-loadMonitor.action?userCode=1112&equipmentCode=MidECW1000";
		try {
			URL oracle = new URL(url);
			URLConnection conn = oracle.openConnection();// 或HttpURLConnection connect = (HttpURLConnection)
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine = null;
			String m="";
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
				m = m+inputLine;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
